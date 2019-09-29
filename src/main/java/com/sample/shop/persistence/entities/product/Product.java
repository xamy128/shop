package com.sample.shop.persistence.entities.product;

import com.sample.shop.common.persistence.TimedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter  @Setter  @NoArgsConstructor
public class Product extends TimedEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id = -1;

    @NotNull
    @Size(min = 1, max = 64)
    String name = "";

    @NotNull
    BigDecimal price = BigDecimal.ZERO;

    @NotNull
    @Min(0)
    Integer availableQuantity = 0;

    @NotNull
    Boolean isActive = false;

    @NotNull
    ProductCategory productCategory = ProductCategory.MISCELLANEOUS;

    public enum ProductCategory {
        MISCELLANEOUS,
        BOOK,
        GAME,
        CLOTHES,
        TOYS,
        APPLIANCES,
        FURNITURE
    }

    public Product (int id,
             String name,
             BigDecimal price,
             int availableQuantity,
             boolean isActive,
             ProductCategory productCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.isActive = isActive;
        this.productCategory = productCategory;
    }
}