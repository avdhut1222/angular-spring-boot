package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.DlrCircuitDesignLine;

import java.util.List;

public interface DlrCircuitDesignLineService extends IOService<DlrCircuitDesignLine, DlrCircuitDesignLine.DlrCircuitDesignLinePK> {
    List<DlrCircuitDesignLine> getDlrCircuitDesignLines(Long circuitDesignId, Long issueNbr);
}
