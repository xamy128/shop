package com.sample.shop.persistence.entities.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Composite key for Custom Address Entity
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressKey implements Serializable {
    @NotNull
    @Size(max = 32)
    String username = "";

    @NotNull
    @Min(0)
    int entryId = -1;
}
