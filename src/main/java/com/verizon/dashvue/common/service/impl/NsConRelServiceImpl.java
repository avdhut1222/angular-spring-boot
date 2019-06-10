package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.Circuit;
import com.verizon.dashvue.common.domain.dashvue.NsConRel;
import com.verizon.dashvue.common.repository.dashvue.NsConRelRepository;
import com.verizon.dashvue.common.service.NsConRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NsConRelServiceImpl extends AbstractService<NsConRel, NsConRel.NsConRelPK> implements NsConRelService {

    @Autowired
    NsConRelRepository nsConRelRepository;

    @Override
    protected PagingAndSortingRepository<NsConRel, NsConRel.NsConRelPK> getRepository() {
        return nsConRelRepository;
    }

    @Override
    public List<NsConRel> getChildrenCircuits(Circuit circuit){
        List<NsConRel> nsConRelList = nsConRelRepository.findChildrenByParentId(circuit.getCircuitDesignId());
        return nsConRelList;
    }

    @Override
    public List<NsConRel> getParentCircuits(Circuit circuit){
        List<NsConRel> nsConRelList = nsConRelRepository.findParentByChildId(circuit.getCircuitDesignId());
        return nsConRelList;
    }
}
