package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.DlrNotes;

import java.util.List;

public interface DlrNotesService extends IOService<DlrNotes, DlrNotes.DlrNotesPK> {
    List<DlrNotes> getDlrNotesByCktDesgnIdAndIssNbr(Long circuitDesignId, Long issueNbr);
}
