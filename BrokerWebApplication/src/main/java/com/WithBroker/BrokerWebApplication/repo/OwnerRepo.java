package com.WithBroker.BrokerWebApplication.repo;

import com.WithBroker.BrokerWebApplication.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepo extends JpaRepository<OwnerEntity,Long> {
}
