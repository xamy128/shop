package com.sample.shop.persistence.entities.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class CustomerAddressKey implements Serializable {
    @NotNull
    @Size(min = 1, max = 32)
    String username = "";

    @NotNull
    @Min(0)
    int entryId = -1;
}
