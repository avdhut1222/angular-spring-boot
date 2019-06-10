package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.DesignLayoutReport;
import com.verizon.dashvue.common.repository.dashvue.DesignLayoutReportRepository;
import com.verizon.dashvue.common.service.DesignLayoutReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignLayoutReportServiceImpl extends AbstractService<DesignLayoutReport, DesignLayoutReport.DesignLayoutReportPK> implements DesignLayoutReportService {

    @Autowired
    DesignLayoutReportRepository repository;

    @Override
    protected PagingAndSortingRepository<DesignLayoutReport, DesignLayoutReport.DesignLayoutReportPK> getRepository() {
        return repository;
    }

    @Override
    public List<DesignLayoutReport> getDlrHistory(Long circuitDesignId){
        return repository.getDlrHistory(circuitDesignId);
    }

    @Override
    public DesignLayoutReport getById(Long circuitDesignId, Long issueNbr){
        return repository.getDlrDetails(circuitDesignId, issueNbr);
    }
}
