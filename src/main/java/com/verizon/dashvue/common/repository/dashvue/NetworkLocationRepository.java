package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.Circuit;
import com.verizon.dashvue.common.domain.dashvue.NetworkLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/6/2019 5:03 PM
 */
public interface NetworkLocationRepository extends JpaRepository<NetworkLocation, Long> {

    @Query("select nl from NetworkLocation nl where nl.clliCode like :clliCode")
    List<NetworkLocation> findByClliCodeWildCard(@Param("clliCode") String clliCode);

    @Query("select nl from NetworkLocation nl where nl.clliCode = :clliCode")
    List<NetworkLocation> findByClliCode(@Param("clliCode") String clliCode);

}
