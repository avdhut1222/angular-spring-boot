package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.DlrNotes;
import com.verizon.dashvue.common.repository.dashvue.DlrNotesRepository;
import com.verizon.dashvue.common.service.DlrNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DlrNotesServiceImpl extends AbstractService<DlrNotes, DlrNotes.DlrNotesPK> implements DlrNotesService {

    @Autowired
    DlrNotesRepository dlrNotesRepository;

    @Override
    protected PagingAndSortingRepository<DlrNotes, DlrNotes.DlrNotesPK> getRepository() {
        return dlrNotesRepository;
    }

    @Override
    public List<DlrNotes> getDlrNotesByCktDesgnIdAndIssNbr(Long circuitDesignId, Long issueNbr){
        return dlrNotesRepository.findByCktDesgnIdAndIssNbr(circuitDesignId, issueNbr);
    }
}
