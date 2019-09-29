package com.sample.shop.persistence.repositories;

import com.sample.shop.persistence.entities.customer.CustomerAddress;
import com.sample.shop.persistence.entities.customer.CustomerAddressKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, CustomerAddressKey> {

    @Query("select ca from CustomerAddress ca where ca.key.customerId = ?1 order by ca.key.entryId")
     List<CustomerAddress> findByCustomerId(String username);
}
