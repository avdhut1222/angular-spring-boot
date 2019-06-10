package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.DlrCircuitDesignLine;
import com.verizon.dashvue.common.repository.dashvue.DlrCircuitDesignLineRepository;
import com.verizon.dashvue.common.service.DlrCircuitDesignLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DlrCircuitDesignLineServiceImpl extends AbstractService<DlrCircuitDesignLine, DlrCircuitDesignLine.DlrCircuitDesignLinePK> implements DlrCircuitDesignLineService {

    @Autowired
    DlrCircuitDesignLineRepository dlrCircuitDesignLineRepository;

    @Override
    protected PagingAndSortingRepository<DlrCircuitDesignLine, DlrCircuitDesignLine.DlrCircuitDesignLinePK> getRepository() {
        return dlrCircuitDesignLineRepository;
    }

    @Override
    public List<DlrCircuitDesignLine> getDlrCircuitDesignLines(Long circuitDesignId, Long issueNbr){
        return dlrCircuitDesignLineRepository.findByCircuitDesignIdAndIssueNbr(circuitDesignId, issueNbr);
    }
}
