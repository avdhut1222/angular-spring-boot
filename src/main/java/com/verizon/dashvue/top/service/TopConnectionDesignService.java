package com.verizon.dashvue.top.service;

import com.verizon.dashvue.common.procresult.TopCktQueryResult;
import com.verizon.dashvue.top.domain.CircuitDlrHistory;
import com.verizon.dashvue.top.domain.ConnectionDesignDetail;
import com.verizon.dashvue.top.domain.ConnectionDesignSearchModel;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/11/2019 11:23 PM
 */
public interface TopConnectionDesignService {
  List<TopCktQueryResult> getConnectionSearchResults(ConnectionDesignSearchModel searchModel);

    List<CircuitDlrHistory> getCircuitInfo(Long circuitDesignId);

    ConnectionDesignDetail getConnectionDesignDetail(Long circutiDesignId, Long issueNbr, Long documentNumber);
}
