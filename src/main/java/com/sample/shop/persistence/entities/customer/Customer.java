package com.sample.shop.persistence.entities.customer;

import com.sample.shop.common.persistence.TimedEntity;
import com.sample.shop.persistence.entities.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Customer entity
 */
@Entity
@Table(name = "customers")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Customer extends TimedEntity {
    @NotNull
    @Size(max = 64)
    String firstName = "";

    @NotNull
    @Size(max = 64)
    String lastName = "";

    @Id
    @NotNull
    @Size(min = 1, max = 32)
    String username = "";

    @NotNull
    @Size(min = 5, max = 60)
    String password = "";

    @NotNull
    @Email
    @Size(max = 64)
    String email = "";

    @NotNull
    String phoneNumber = "";

    @NotNull
    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod = PaymentMethod.BANK_TRANSFER;

    @OneToMany(mappedBy = "key.username")
    List<CustomerAddress> addresses = new ArrayList<>();
}