package com.sample.shop.common.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Base Core Class to perform CRUD operations for all entities
 *
 * @param <TEnt> Entity Type
 * @param <TKey> Primary Key Type
 * @param <TRep> Repository
 */
@Service
public abstract class CoreService<TEnt, TKey, TRep extends JpaRepository<TEnt, TKey>> {
    private TRep repository;
    private final int defaultPageSize = 50;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public CoreService(TRep repository) {
        this.repository = repository;
    }
    @Transactional
    public TEnt create(TEnt entity) {
        return repository.save(entity);
    }

    @Transactional
    public TEnt update(TKey key, TEnt entity) {
        isEntityExist(key);
        return repository.save(entity);
    }

    public List<TEnt> findAll(int pageSize) {return findAllWithPageSize(pageSize);}
    public List<TEnt> findAll() { return findAllWithPageSize(0); }

    private List<TEnt> findAllWithPageSize(int pageSize) {
        int size = pageSize > 0 ? pageSize : defaultPageSize;
        return repository.findAll(
                PageRequest.of(0, size)
        ).getContent();
    }

    @Transactional
    public void delete(TKey key) {
            repository.delete(isEntityExist(key));
    }

    @Transactional
    public void deleteAll() {
        repository.deleteAll();
    }

    @Transactional
    public TEnt isEntityExist(TKey key) {
        Optional<TEnt> entity = repository.findById(key);
        if(!entity.isPresent())
            throw new CoreException(ExceptionType.NO_ENTITY);
            return entity.get();
    }
}
