package com.sample.shop.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor
class TestEntity {

    BigDecimal bb = BigDecimal.ZERO;
}
