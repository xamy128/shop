package com.sample.shop.persistence.entities.product;

import com.sample.shop.common.persistence.TimedEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Product Entity
 */
@Entity
@Table(name = "products")
@Getter  @Setter @AllArgsConstructor @NoArgsConstructor
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
    @Enumerated(EnumType.STRING)
    ProductCategory productCategory = ProductCategory.MISCELLANEOUS;
}