package com.sample.shop.common.persistence;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *  Entity to store tracking information. Not every entity needs it.
 */
@MappedSuperclass
@Getter @Setter
public abstract class TimedEntity extends BaseEntity {

    @NotNull
    @Size(max = 32)
    private String createdBy = "abc";

  //  @NotNull
   // OffsetDateTime creationTime = Util.dateTimeFromMillis(0L);

    @NotNull
    @Size(max = 32)
    private String lastUpdateBy = "abc";

  //  @NotNull
  //  OffsetDateTime lastUpdateTime = Util.dateTimeFromMillis(0L);
}

