package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.Circuit;
import com.verizon.dashvue.common.domain.dashvue.CircuitPosition;
import com.verizon.dashvue.common.repository.dashvue.CircuitPositionRepository;
import com.verizon.dashvue.common.service.CircuitPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircuitPostionServiceImpl extends AbstractService<CircuitPosition, CircuitPosition.CircuitPositionPK> implements CircuitPositionService {

    @Autowired
    CircuitPositionRepository circuitPositionRepository;

    @Override
    protected PagingAndSortingRepository<CircuitPosition, CircuitPosition.CircuitPositionPK> getRepository() {
        return circuitPositionRepository;
    }

    @Override
    public List<CircuitPosition> getChildrenCircuits(Circuit circuit){
        List<CircuitPosition> circuitPositionList = circuitPositionRepository.findChildrenByCircuitDesignId(circuit.getCircuitDesignId());
        return circuitPositionList;
    }

    @Override
    public List<CircuitPosition> getParentCircuits(Circuit circuit){
        List<CircuitPosition> circuitPositionList = circuitPositionRepository.findParentByCircuitDesignId3(circuit.getCircuitDesignId());
        return circuitPositionList;
    }
}
