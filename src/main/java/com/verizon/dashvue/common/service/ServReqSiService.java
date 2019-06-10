package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.Circuit;
import com.verizon.dashvue.common.domain.dashvue.ServReqSi;
import com.verizon.dashvue.common.procresult.CaBySrsiResult;
import com.verizon.dashvue.common.procresult.LocationQuery;
import com.verizon.dashvue.common.procresult.ValueLabelsBySrsiQuery;

import java.util.List;
import java.util.Map;

/**
 * @author Mankavale, Avdhut
 * Created: 3/19/2019 9:11 AM
 */
public interface ServReqSiService extends IOService<ServReqSi, ServReqSi.ServReqSiPK> {
  String getActivityCdText(String activityCd);

  List<ValueLabelsBySrsiQuery> getValueLabelsBySrsiQuery(ServReqSi servReqSi);
  List<CaBySrsiResult> getCaBySrsiProc(ServReqSi servReqSi);

  Circuit getCircuit(ServReqSi servReqSi);
}
