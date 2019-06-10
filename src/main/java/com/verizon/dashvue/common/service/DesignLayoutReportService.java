package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.DesignLayoutReport;

import java.util.List;

public interface DesignLayoutReportService extends IOService<DesignLayoutReport, DesignLayoutReport.DesignLayoutReportPK>  {
    List<DesignLayoutReport> getDlrHistory(Long circuitDesignId);

    DesignLayoutReport getById(Long circuitDesignId, Long issueNbr);
}
