
package com.sample.shop.persistence.entities.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class OrderItemKey implements Serializable {
        @NotNull
        @Size(min =1, max = 64)
        int orderId = -1;
        @NotNull
        int itemId = -1;
}
