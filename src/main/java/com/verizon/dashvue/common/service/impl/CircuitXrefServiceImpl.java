package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.CircuitXref;
import com.verizon.dashvue.common.domain.dashvue.DlrNotes;
import com.verizon.dashvue.common.repository.dashvue.CircuitXrefRepository;
import com.verizon.dashvue.common.repository.dashvue.DlrNotesRepository;
import com.verizon.dashvue.common.service.CircuitXrefService;
import com.verizon.dashvue.common.service.DlrNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircuitXrefServiceImpl extends AbstractService<CircuitXref, CircuitXref.CircuitXrefPK> implements CircuitXrefService {

    @Autowired
    CircuitXrefRepository circuitXrefRepository;

    @Override
    protected PagingAndSortingRepository<CircuitXref, CircuitXref.CircuitXrefPK> getRepository() {
        return circuitXrefRepository;
    }

    @Override
    public List<CircuitXref> getCktXrefByCktDesgnId(Long circuitDesignId){
        return circuitXrefRepository.findByCktDesgnId(circuitDesignId);
    }
}
