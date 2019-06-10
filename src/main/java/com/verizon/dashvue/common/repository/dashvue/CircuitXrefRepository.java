package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.CircuitXref;
import com.verizon.dashvue.common.domain.dashvue.DlrNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CircuitXrefRepository extends JpaRepository<CircuitXref, CircuitXref.CircuitXrefPK> {

    @Query("select cx from CircuitXref cx where cx.circuitXrefPK.circuitDesignId = :circuitDesignId order by cx.circuitXrefEcckt")
    List<CircuitXref> findByCktDesgnId(@Param("circuitDesignId") Long circuitDesignId);

    @Query("select cx from CircuitXref cx where cx.circuitXrefEcckt like :circuitXrefEcckt")
    List<CircuitXref> findByCircuitXrefEccktWildCard(@Param("circuitXrefEcckt") String circuitXrefEcckt);

    @Query("select cx from CircuitXref cx where cx.circuitXrefEcckt = :circuitXrefEcckt")
    List<CircuitXref> findByCircuitXrefEcckt(@Param("circuitXrefEcckt") String circuitXrefEcckt);
}
