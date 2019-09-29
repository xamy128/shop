package com.sample.shop.persistence.entities.customer;

import com.sample.shop.persistence.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customer_addresses")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CustomerAddress extends Address {
    @EmbeddedId
    CustomerAddressKey key = new CustomerAddressKey();

    @NotNull
    Boolean isInvoiceAddress = false;

    @NotNull
    Boolean isDeliveryAddress = true;

    @NotNull
    Boolean isDefaultInvoiceAddress = false;

    @NotNull
    Boolean isDefaultDeliveryAddress = false;

    public CustomerAddress(String houseNo,
                           String street,
                           String city,
                           String zipCode,
                           String country,
                           String extraInformation,
                           Boolean isInvoiceAddress,
                           Boolean isDeliveryAddress,
                           Boolean isDefaultDeliveryAddress,
                           Boolean isDefaultInvoiceAddress
    ) {
    super(houseNo, street, city, zipCode, country, extraInformation);
    this.isInvoiceAddress = isInvoiceAddress;
    this.isDeliveryAddress = isDeliveryAddress;
    this.isDefaultDeliveryAddress = isDefaultDeliveryAddress;
    this.isDefaultInvoiceAddress = isDefaultInvoiceAddress;
    }
}

