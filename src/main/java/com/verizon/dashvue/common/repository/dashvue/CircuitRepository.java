package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/6/2019 5:03 PM
 */
public interface CircuitRepository extends JpaRepository<Circuit, Long> {

    @Query("select ckt from Circuit ckt where ckt.circuitDesignId in :circuitDesignIds")
    List<Circuit> findCircuitsByDesignId(@Param("circuitDesignIds") List<Long> circuitDesignIds);

    @Query("select ckt from Circuit ckt where ckt.exchangeCarrierCircuitId like :ecckt")
    List<Circuit> findByEccktWildCard(@Param("ecckt") String ecckt);

    @Query("select ckt from Circuit ckt where ckt.exchangeCarrierCircuitId = :ecckt")
    List<Circuit> findByEcckt(@Param("ecckt") String ecckt);

    @Query("select ckt from Circuit ckt where ckt.locationId in :locationIds")
    List<Circuit> findByLocationIds(@Param("locationIds") List<Long> locationIds);

    @Query("select ckt from Circuit ckt where ckt.locationId2 in :location2Ids")
    List<Circuit> findByLocation2Ids(@Param("location2Ids") List<Long> location2Ids);
}
