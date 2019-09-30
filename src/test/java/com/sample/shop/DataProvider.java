package com.sample.shop;

import com.sample.shop.persistence.entities.PaymentMethod;
import com.sample.shop.persistence.entities.customer.Customer;
import com.sample.shop.persistence.entities.customer.CustomerAddress;
import com.sample.shop.persistence.entities.product.Product;
import com.sample.shop.persistence.entities.product.ProductCategory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Provides data for test cases
 */
public class DataProvider {

    /**
     * @return a list of valid customer addresses
     */
    public static List<CustomerAddress> getCustomerAddresses() {
        CustomerAddress customerAddressInvoice = new CustomerAddress(
                "24A",
                "fakestraße",
                "Tokyo",
                "23452",
                "",
                "",
                true,
                false,
                true,
                false
        );

        CustomerAddress customerAddressDelivery = new CustomerAddress(
                "25",
                "fakerlane",
                "Berlin",
                "23452",
                "Germany",
                "none",
                false,
                true,
                true,
                false
        );

        CustomerAddress customerAddressBothTrue = new CustomerAddress(
                "100",
                "lane",
                "Berlin",
                "23452",
                "Germany",
                "none",
                true,
                true,
                true,
                false
        );
        return Arrays.asList(
                customerAddressBothTrue,
                customerAddressDelivery,
                customerAddressInvoice
        );
    }

    /**
     * @return a list of invalid customer addresses
     */
    public static List<CustomerAddress> getInvalidCustomerAddresses() {
        List<CustomerAddress> addresses = new ArrayList<>(getCustomerAddresses());
        for (CustomerAddress address: addresses) {
            address.setIsInvoiceAddress(false);
            address.setIsDeliveryAddress(false);
        }
        return addresses;
    }

    /**
     * @return single customer
     */
    public static Customer getSingleCustomer() {
        return new Customer(
                "test",
                "customer",
                "test1",
                "abc**#",
                "testCust@yahoo.com",
                "010024543453",
                PaymentMethod.BANK_TRANSFER,
                getCustomerAddresses()
        );
    }

    /**
     * @return list of products
     */
    static List<Product> getProducts() {
        return Arrays.asList(
                new Product(
                        2,
                        "pro1",
                        new BigDecimal(5),
                        66,
                        true,
                        ProductCategory.MISCELLANEOUS
                ),
                new Product(
                        3,
                        "pro2",
                        new BigDecimal(7),
                        34,
                        true,
                        ProductCategory.GAME)
        );
    }
}
