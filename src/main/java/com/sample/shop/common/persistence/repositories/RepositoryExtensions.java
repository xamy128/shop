package com.sample.shop.common.persistence.repositories;

import java.util.List;

/**
 * Extended methods
 * @param <TEnt>
 */
public interface RepositoryExtensions<TEnt> {
    List<TEnt> findALLOrdered();
    List<TEnt> find(String match);
}
