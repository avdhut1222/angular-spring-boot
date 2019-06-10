package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.AssignedTelNum;
import com.verizon.dashvue.common.domain.dashvue.ServReqSi;
import com.verizon.dashvue.common.procresult.ValueLabelsBySrsiQuery;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/15/2019 2:39 PM
 */
public interface AssignedTelNumService extends IOService<AssignedTelNum, Long> {
  List<AssignedTelNum> getByDocNumAndServItemIds(Long docNum, List<Long> servItemIds);

  String getServItemDescription(AssignedTelNum assignedTelNum);

}
