package com.sample.shop.common.service;

import com.sample.shop.common.persistence.TimedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * To add tracking information for each entity.
 *
 * @param <TTEnt> Entity Type
 * @param <TKey>  Primary key type
 * @param <TRep>  Repository Type
 */
@Service
public abstract class TimedCoreService<
        TTEnt extends TimedEntity,
        TKey,
        TRep extends JpaRepository<TTEnt, TKey>
        >
        extends CoreService<TTEnt, TKey, TRep> {

    @Transactional
    public TTEnt create(TTEnt entity) {
        entity.setCreatedBy("abc");
     //   entity.setCreationTime(OffsetDateTime.now());
        entity.setLastUpdateBy("abc");
   //     entity.setLastUpdateTime(OffsetDateTime.now());
        return super.create(entity);
    }

    @Transactional
    public TTEnt update(TKey key, TTEnt entity) {
        entity.setLastUpdateBy("abc");
  //      entity.setLastUpdateTime(OffsetDateTime.now());
        return super.update(key, entity);
    }
}
