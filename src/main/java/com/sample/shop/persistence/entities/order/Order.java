package com.sample.shop.persistence.entities.order;

import com.sample.shop.common.persistence.TimedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    String userName = "";

    @NotNull
    LocalDate date = LocalDate.now();

    @NotNull
    BigDecimal totalPrice = BigDecimal.ZERO;

    @NotNull
    Integer totalQuantity = 0;

    @OneToMany(mappedBy = "key.orderId")
    List<OrderItem> items = new ArrayList<>();

    public Order(BigDecimal totalPrice, Integer totalQuantity) {
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
    }
}
