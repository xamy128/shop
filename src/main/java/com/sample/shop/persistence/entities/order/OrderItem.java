package com.sample.shop.persistence.entities.order;

import com.sample.shop.persistence.entities.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter @Setter @NoArgsConstructor
public class OrderItem {

    @EmbeddedId
    OrderItemKey key = new OrderItemKey();


    @NotNull
    int productId = -1;

    @NotNull
    @Min(0)
    int quantity = 0;

    @NotNull
    BigDecimal price = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    public OrderItem(int orderId, int itemId, int quantity, int productId, BigDecimal price) {
        this.key.orderId = orderId;
        this.key.itemId = itemId;
        this.quantity = quantity;
        this.productId = productId;
        this.price = price;
    }
}
