package com.sample.shop;

import com.sample.shop.persistence.entities.PaymentMethod;
import com.sample.shop.persistence.entities.customer.Customer;
import com.sample.shop.persistence.entities.customer.CustomerAddress;
import com.sample.shop.persistence.entities.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataProvider {

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

    public static List<CustomerAddress> getInvalidCustomerAddresses() {
        List<CustomerAddress> addresses = new ArrayList<>(getCustomerAddresses());
        for (CustomerAddress address: addresses) {
            address.setIsInvoiceAddress(false);
            address.setIsDeliveryAddress(false);
        }
        return addresses;
    }

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

     static List<Product> getProducts() {
       return Collections.singletonList(new Product(
                2,
                "pro1",
                new BigDecimal(5),
                2,
                true,
                Product.ProductCategory.MISCELLANEOUS
        ));
    }
}
