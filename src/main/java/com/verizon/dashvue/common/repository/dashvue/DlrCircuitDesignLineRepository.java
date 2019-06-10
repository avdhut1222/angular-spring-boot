package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.DlrCircuitDesignLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DlrCircuitDesignLineRepository extends JpaRepository<DlrCircuitDesignLine, DlrCircuitDesignLine.DlrCircuitDesignLinePK> {

    @Query("select new DlrCircuitDesignLine(dcdl.rowSequenceNbr, dcdl.noteInd, dcdl.location, dcdl.equipmentTypeFacilityDesig, dcdl.relayRackFacilityType, " +
        "dcdl.unitChannel, dcdl.signalVoicePathType, dcdl.zToATlp, dcdl.aToZTlp, dcdl.incrementalMileage, dcdl.miscellaneousInformation, dcdl.dlrCircuitDesignLinePK.issueNbr) " +
        "from DlrCircuitDesignLine dcdl where dcdl.dlrCircuitDesignLinePK.circuitDesignId = :circuitDesignId and dcdl.dlrCircuitDesignLinePK.issueNbr = :issueNbr " +
        "order by dcdl.rowSequenceNbr")
    List<DlrCircuitDesignLine> findByCircuitDesignIdAndIssueNbr(@Param("circuitDesignId") Long circuitDesignId, @Param("issueNbr") Long issueNbr);
}
