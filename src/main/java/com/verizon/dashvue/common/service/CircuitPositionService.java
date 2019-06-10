package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.Circuit;
import com.verizon.dashvue.common.domain.dashvue.CircuitPosition;

import java.util.List;

public interface CircuitPositionService extends IOService<CircuitPosition, CircuitPosition.CircuitPositionPK> {
    List<CircuitPosition> getChildrenCircuits(Circuit circuit);

    List<CircuitPosition> getParentCircuits(Circuit circuit);
}
