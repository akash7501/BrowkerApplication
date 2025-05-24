package com.WithBroker.BrokerWebApplication.repo;

import com.WithBroker.BrokerWebApplication.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo  extends JpaRepository<AddressEntity,Long> {
}
