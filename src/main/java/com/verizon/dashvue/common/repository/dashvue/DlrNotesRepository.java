package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.DlrCircuitDesignLine;
import com.verizon.dashvue.common.domain.dashvue.DlrNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DlrNotesRepository extends JpaRepository<DlrNotes, DlrNotes.DlrNotesPK> {

    @Query("select dlrn from DlrNotes dlrn where dlrn.dlrNotesPK.circuitDesignId = :circuitDesignId" +
        " and dlrn.dlrNotesPK.issueNbr = :issueNbr order by dlrn.dlrNotesPK.noteInd")
    List<DlrNotes> findByCktDesgnIdAndIssNbr(@Param("circuitDesignId") Long circuitDesignId, @Param("issueNbr") Long issueNbr);
}
