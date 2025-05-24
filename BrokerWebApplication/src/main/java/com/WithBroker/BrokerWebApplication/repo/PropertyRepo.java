package com.WithBroker.BrokerWebApplication.repo;

import com.WithBroker.BrokerWebApplication.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends JpaRepository<PropertyEntity,Long> {

    // Finds properties by exact name
    List<PropertyEntity> findByName(String name);  // to search by owr own



    // find the property by any parameter
    @Query("SELECT p FROM PropertyEntity p WHERE " +
            "(:id IS NULL OR p.id = :id) AND " +
            "(:config IS NULL OR p.config = :config) AND " +
            "(:location IS NULL OR p.location = :location)")

    //@Query("SELECT p FROM PropertyEntity p WHERE " +
    //       "(:id IS NULL OR p.id = :id) AND " +
    //       "(:config IS NULL OR LOWER(p.config) LIKE LOWER(CONCAT('%', :config, '%'))) AND " +
    //       "(:location IS NULL OR LOWER(p.location) LIKE LOWER(CONCAT('%', :location, '%')))")
    List<PropertyEntity> finByAny(@Param("id") Long id, @Param("config") String config, @Param("location") String location);
}
