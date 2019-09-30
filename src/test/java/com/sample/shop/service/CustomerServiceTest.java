package com.sample.shop.service;

import com.sample.shop.DataProvider;
import com.sample.shop.common.service.CoreException;
import com.sample.shop.persistence.entities.customer.Customer;
import com.sample.shop.persistence.entities.customer.CustomerAddress;
import com.sample.shop.persistence.repositories.CustomerRepository;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Test cases for Customer Service
 */
@RunWith(JUnitParamsRunner.class)
public class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerService customerService;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    /**
     * @return List of valid addresses, each passed to the testcase.
     */
    public static List<CustomerAddress> addressHasTypeValid() {
        return DataProvider.getCustomerAddresses();
    }

    /**
     * @return List of invalid addresses, each passed to the testcase.
     */
    public static List<CustomerAddress> addressHasTypeInValid() {
        return DataProvider.getInvalidCustomerAddresses();
    }

    /**
     * @see CustomerService#checkAddressHasType(CustomerAddress)
     * @param address each address passed to the method
     */
    @Test
    @Parameters(method = "addressHasTypeValid")
    public void checkAddressHasType_true(CustomerAddress address) {
        customerService.checkAddressHasType(address);
    }

    /**
     * @see CustomerService#checkAddressHasType(CustomerAddress)
     * @param address each address passed to the method
     */
    @Test(expected = CoreException.class)
    @Parameters(method = "addressHasTypeInValid")
    public void checkAddressHasType_false(CustomerAddress address) {
        customerService.checkAddressHasType(address);
    }

    /**
     * @see CustomerService#authenticate(String, String)
     * For wrong username or password exception is expected
     */
    @Test(expected = CoreException.class)
    public void authenticate_false() {
        String username = "test";
        String password = "wrong";
        when(customerRepository.authenticate(username, password)).thenReturn(Optional.empty());
        customerService.authenticate(username, password);
    }

    /**
     * @see CustomerService#authenticate(String, String)
     */
    @Test
    public void authenticate_true() {
        Customer customer = DataProvider.getSingleCustomer();
        String username = "test";
        String password = "abc**#";
        when(customerRepository.authenticate(username, password)).thenReturn(Optional.of(customer));
        Customer validCustomer = customerService.authenticate(username, password);
        assertEquals(customer.getUsername(), validCustomer.getUsername());
    }
}
