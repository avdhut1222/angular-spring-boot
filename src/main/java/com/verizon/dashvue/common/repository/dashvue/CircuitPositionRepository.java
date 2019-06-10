package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.CircuitPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CircuitPositionRepository extends JpaRepository<CircuitPosition, CircuitPosition.CircuitPositionPK> {

    @Query("select cp from CircuitPosition cp where cp.circuitDesignId3 = :circuitDesignId3" +
        " order by cp.circuitPositionPK.circuitPositionNumber")
    List<CircuitPosition> findParentByCircuitDesignId3(@Param("circuitDesignId3") Long circuitDesignId3);

    @Query("select cp from CircuitPosition cp where cp.circuitPositionPK.circuitDesignId = :circuitDesignId" +
        " order by cp.circuitPositionPK.circuitPositionNumber")
    List<CircuitPosition> findChildrenByCircuitDesignId(@Param("circuitDesignId") Long circuitDesignId);

}
