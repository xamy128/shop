package com.sample.shop.service;

import com.sample.shop.common.service.CoreException;
import com.sample.shop.common.service.ExceptionType;
import com.sample.shop.common.service.TimedCoreService;
import com.sample.shop.persistence.entities.customer.Customer;
import com.sample.shop.persistence.entities.customer.CustomerAddress;
import com.sample.shop.persistence.entities.customer.CustomerAddressKey;
import com.sample.shop.persistence.repositories.CustomerAddressRepository;
import com.sample.shop.persistence.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Business class for customer entity
 *
 * @author Ammarah.Shakeel
 */
@Service
public class CustomerService extends TimedCoreService<Customer, String, CustomerRepository> {
    private CustomerRepository repository;
    private CustomerAddressRepository customerAddressRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerAddressRepository customerAddressRepository) {
        super(customerRepository);
        this.repository = customerRepository;
        this.customerAddressRepository = customerAddressRepository;
    }

    /**
     * Create customer
     * @param customer new customer entity
     * @return newly created customer
     */
    public Customer create(Customer customer, List<CustomerAddress> addresses) {
        Customer newCustomer = super.create(customer);

        if(addresses != null && addresses.size() > 0){
            saveAllAddress(newCustomer.getUsername(), addresses);
        }
        return newCustomer;
    }

    /**
     * Update Customer
     * @param username username of customer to update
     * @param customer to update customer entity
     * @return updated customers
     */
    public Customer update(String username, Customer customer, List<CustomerAddress> addresses) {
        Customer updateCustomer = super.update(username, customer);

        if(addresses != null && addresses.size() > 0){
            saveAllAddress(username, addresses);
        }
        return updateCustomer;
    }

    /**
     * Save all valid customer addresses
     * @param username customer to save addresses for
     * @param addresses addresses to save
     * @return List of saved addresses
     */
    private List<CustomerAddress> saveAllAddress(
            String username,
            List<CustomerAddress> addresses
    ) {
        List<CustomerAddress> oldAddresses = customerAddressRepository.findByCustomerId(username);

        if(oldAddresses.size() > 0) {
            customerAddressRepository.deleteAll(oldAddresses);
        }

        for (CustomerAddress address: addresses)
        {
            checkAddressHasType(address);
        }

        for (int i = 0; i < addresses.size(); i++) {
            addresses.get(i).setKey(new CustomerAddressKey(username, i));
        }
        return customerAddressRepository.saveAll(addresses);
    }

    /**
     * Authenticate user for login
     * @param username to validate
     * @param password to validate
     * @return authenticated customer
     */
    public Customer authenticate(String username, String password) {
        Optional<Customer> customer = repository.authenticate(username, password);
        if(!customer.isPresent()) {
            throw new CoreException(ExceptionType.USER_UNKNOWN,
                    "User with username and password does not exist. Please check your credentials and try again!");
        }
        return customer.get();
    }

    /**
     * Each address must be either invoice or delivery
     * @param customerAddress address to validate
     */
    public void checkAddressHasType(CustomerAddress customerAddress){
        if(!customerAddress.getIsDeliveryAddress() && !customerAddress.getIsInvoiceAddress()) {
            throw new CoreException(ExceptionType.VALIDATION,
                    "The address should either be delivery or invoice");
        }
    }
}
