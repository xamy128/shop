package com.sample.shop.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @NotNull
    @Size(max = 10)
    String houseNumber = "";

    @NotNull
    @Size(max = 64)
    String street = "";

    @NotNull
    @Size(max = 64)
    String city = "";

    @NotNull
    @Size(max = 10)
    String zipCOde = "";

    @NotNull
    @Size(max = 64)
    String country = "";

    @Size(max = 128)
    String extraInformation = "";
}
