package com.verizon.dashvue.top.service.impl;

import com.verizon.dashvue.common.domain.dashvue.Circuit;
import com.verizon.dashvue.common.domain.dashvue.CircuitPosition;
import com.verizon.dashvue.common.domain.dashvue.NsConRel;
import com.verizon.dashvue.common.service.CircuitPositionService;
import com.verizon.dashvue.common.service.CircuitService;
import com.verizon.dashvue.common.service.NsConRelService;
import com.verizon.dashvue.top.domain.ConnectionHierarchyModel;
import com.verizon.dashvue.top.domain.ConnectionHierarchySearchModel;
import com.verizon.dashvue.top.service.TopConnectionHierarchyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TopConnectionHierarchyServiceImpl implements TopConnectionHierarchyService {


    @Autowired
    CircuitService circuitService;

    @Autowired
    CircuitPositionService circuitPositionService;

    @Autowired
    NsConRelService nsConRelService;

    @Override
    public List<ConnectionHierarchyModel> getConnectionHierarchy(ConnectionHierarchySearchModel connectionHierarchySearchModel) {
        String ecckt = connectionHierarchySearchModel.getEcckt();
        Boolean eccktExactMatch = connectionHierarchySearchModel.getEccktExactMatch();
        String connectionXref = connectionHierarchySearchModel.getConnectionReference();
        Boolean connXrefExactMatch = connectionHierarchySearchModel.getConnXrefExactMatch();
        String location = connectionHierarchySearchModel.getLocationA();
        Boolean locAExactMatch = connectionHierarchySearchModel.getLocationAExactMatch();
        String location2 = connectionHierarchySearchModel.getLocationZ();
        Boolean locZExactMatch = connectionHierarchySearchModel.getLocationZExactMatch();
        List<String> circuitTypes = new ArrayList<>(connectionHierarchySearchModel.getCircuitTypes());
        List<Circuit> circuits =
            circuitService.getCircuitsForHierarchySearch(ecckt, eccktExactMatch, connectionXref, connXrefExactMatch
                , location, locAExactMatch, location2, locZExactMatch, circuitTypes);

        if (!CollectionUtils.isEmpty(circuits)) {
            List<ConnectionHierarchyModel> connectionHierarchyModelList = new ArrayList<>();
            for (Circuit circuit : circuits) {
                if (connectionHierarchySearchModel.getLookupChildren()) {
                    connectionHierarchyModelList.add(getConnectionHierarchyChildren(circuit));
                } else {
                    connectionHierarchyModelList.add(getConnectionHierarchyParent(circuit));
                }
            }
            return connectionHierarchyModelList;
        }
        return null;
    }

    private ConnectionHierarchyModel getConnectionHierarchyChildren(Circuit circuit) {
        if (null != circuit) {
            ConnectionHierarchyModel connectionHierarchyModel = new ConnectionHierarchyModel();
            connectionHierarchyModel.setCircuitDesignId(circuit.getCircuitDesignId());
            connectionHierarchyModel.setCircuitId(circuit.getExchangeCarrierCircuitId());
            connectionHierarchyModel.setCircuitType(circuit.getType());
            connectionHierarchyModel.setStatus(circuit.getStatus());
            List<ConnectionHierarchyModel> childrenList = new ArrayList<>();
            List<NsConRel> nsConRelList = nsConRelService.getChildrenCircuits(circuit);
            if (!CollectionUtils.isEmpty(nsConRelList)) {
                List<Long> nsConRelCDIList = nsConRelList
                    .stream()
                    .map(ncr -> ncr.getNsConRelPK().getCircuitDesignIdChild())
                    .collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(nsConRelCDIList)) {
                    for (Circuit ckt : circuitService.getAllByCircuitDesignId(nsConRelCDIList)) {
                        ConnectionHierarchyModel nsConRelChild = getConnectionHierarchyChildren(ckt);
                        if (null != nsConRelChild) {
                            childrenList.add(nsConRelChild);
                        }
                    }
                }
            }

            List<CircuitPosition> circuitPositionList = circuitPositionService.getChildrenCircuits(circuit);
            if (!CollectionUtils.isEmpty(circuitPositionList)) {
                List<Long> circuitPositionCDIList = circuitPositionList
                    .stream()
                    .map(cp -> cp.getCircuitDesignId3())
                    .collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(circuitPositionCDIList)) {
                    for (Circuit ckt : circuitService.getAllByCircuitDesignId(circuitPositionCDIList)) {
                        ConnectionHierarchyModel cktPositionChild = getConnectionHierarchyChildren(ckt);
                        if (null != cktPositionChild) {
                            childrenList.add(cktPositionChild);
                        }
                    }
                }
            }
            connectionHierarchyModel.setChildren(childrenList);
            return connectionHierarchyModel;
        }
        return null;
    }

    private ConnectionHierarchyModel getConnectionHierarchyParent(Circuit circuit) {
        if (null != circuit) {
            ConnectionHierarchyModel connectionHierarchyModel = new ConnectionHierarchyModel();
            connectionHierarchyModel.setCircuitDesignId(circuit.getCircuitDesignId());
            connectionHierarchyModel.setCircuitId(circuit.getExchangeCarrierCircuitId());
            connectionHierarchyModel.setCircuitType(circuit.getType());
            connectionHierarchyModel.setStatus(circuit.getStatus());
            List<ConnectionHierarchyModel> parentList = new ArrayList<>();

            List<CircuitPosition> circuitPositionList = circuitPositionService.getParentCircuits(circuit);
            if (!CollectionUtils.isEmpty(circuitPositionList)) {
                List<Long> circuitPositionCDIList = circuitPositionList
                    .stream()
                    .map(cp -> cp.getCircuitPositionPK().getCircuitDesignId())
                    .collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(circuitPositionCDIList)) {
                    for (Circuit ckt : circuitService.getAllByCircuitDesignId(circuitPositionCDIList)) {
                        ConnectionHierarchyModel cktPositionChild = getConnectionHierarchyParent(ckt);
                        if (null != cktPositionChild) {
                            parentList.add(cktPositionChild);
                        }
                    }
                }
            }

            List<NsConRel> nsConRelList = nsConRelService.getParentCircuits(circuit);
            if (!CollectionUtils.isEmpty(nsConRelList)) {
                List<Long> nsConRelCDIList = nsConRelList
                    .stream()
                    .map(ncr -> ncr.getNsConRelPK().getCircuitDesignIdParent())
                    .collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(nsConRelCDIList)) {
                    for (Circuit ckt : circuitService.getAllByCircuitDesignId(nsConRelCDIList)) {
                        ConnectionHierarchyModel nsConRelChild = getConnectionHierarchyParent(ckt);
                        if (null != nsConRelChild) {
                            parentList.add(nsConRelChild);
                        }
                    }
                }
            }

            connectionHierarchyModel.setParents(parentList);
            return connectionHierarchyModel;
        }
        return null;
    }
}
