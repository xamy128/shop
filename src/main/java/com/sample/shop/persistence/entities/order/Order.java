package com.sample.shop.persistence.entities.order;

import com.sample.shop.common.persistence.TimedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Order Entity
 *
 * @author Ammarah Shakeel
 */

@Entity
@Table(name = "orders")
@Getter @Setter @NoArgsConstructor
public class Order extends TimedEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId = -1;

    @NotNull
    String userName = ""; // access to the current user somehow

    @NotNull
    LocalDate date = LocalDate.now();

    @NotNull
    BigDecimal totalPrice = BigDecimal.ZERO;

    @NotNull
    Integer totalQuantity = 0;

//join with customer table


    // delivery status

    //   var deliveryDueTo: java.time.LocalDate = java.time.LocalDate.now()

    // Payment status
    // Payment due

    // var currency: String = ""

    // var autoSendInvoiceEmail: Boolean = false

    // add refrence to order items here
    public Order(BigDecimal totalPrice, Integer totalQuantity) {
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
    }
}
