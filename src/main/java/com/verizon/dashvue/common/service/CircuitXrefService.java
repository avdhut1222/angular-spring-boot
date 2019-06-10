package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.CircuitXref;
import com.verizon.dashvue.common.domain.dashvue.DlrNotes;

import java.util.List;

public interface CircuitXrefService extends IOService<CircuitXref, CircuitXref.CircuitXrefPK> {
    List<CircuitXref> getCktXrefByCktDesgnId(Long circuitDesignId);
}
