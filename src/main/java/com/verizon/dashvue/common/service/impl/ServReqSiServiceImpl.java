package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.Circuit;
import com.verizon.dashvue.common.domain.dashvue.ServItem;
import com.verizon.dashvue.common.domain.dashvue.ServReqSi;
import com.verizon.dashvue.common.procresult.CaBySrsiResult;
import com.verizon.dashvue.common.procresult.ValueLabelsBySrsiQuery;
import com.verizon.dashvue.common.repository.dashvue.ServReqSiRepository;
import com.verizon.dashvue.common.service.CircuitService;
import com.verizon.dashvue.common.service.ServItemService;
import com.verizon.dashvue.common.service.ServReqSiService;
import com.verizon.dashvue.util.DashvueUtils;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/19/2019 9:12 AM
 */

@Service
//@Transactional
public class ServReqSiServiceImpl extends AbstractService<ServReqSi, ServReqSi.ServReqSiPK> implements ServReqSiService {

  @Qualifier("dashvueEntityManager")
  @Autowired
  EntityManager dashvueEntityManager;

  @Autowired
  ServReqSiRepository servReqSiRepository;

  @Autowired
  ServItemService servItemService;

  @Autowired
  CircuitService circuitService;

  @Override
  protected PagingAndSortingRepository<ServReqSi, ServReqSi.ServReqSiPK> getRepository() {
    return servReqSiRepository;
  }

  @Override
  public String getActivityCdText(String activityCd) {
    switch (activityCd) {
      case "D":
        return "'Disconnect'";
      case "C":
        return "Change";
      case "I":
        return "Inservice";
      case "N":
        return "New";
      case "R":
        return "Reported";
      case "P":
        return "Pending New";
      case "A":
        return "Cancelled";
      case "Y":
        return "Suspend";
      default:
        return null;
    }
  }

  @Override
//  @Transactional
  public List<ValueLabelsBySrsiQuery> getValueLabelsBySrsiQuery(ServReqSi servReqSi) {
    List<ValueLabelsBySrsiQuery> labels = new ArrayList<>();
    StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("getValuesBySrsi");
    query.setParameter("aDocNum", servReqSi.getServReqSiPK().getDocumentNumber());
    query.setParameter("aServItem", servReqSi.getServReqSiPK().getServItemId());
    try {
      List<Object[]> results = query.getResultList();
      for (Object[] result : results) {
        if (null != result) {
          ValueLabelsBySrsiQuery valueLabelsBySrsiQuery = new ValueLabelsBySrsiQuery();
          valueLabelsBySrsiQuery.setValueLabel(DashvueUtils.objectToString(result[0]));
          valueLabelsBySrsiQuery.setSrsiValueSeq(DashvueUtils.objectToString(result[1]));
          valueLabelsBySrsiQuery.setValidValue(DashvueUtils.objectToString(result[2]));
          valueLabelsBySrsiQuery.setActivityCd(DashvueUtils.objectToString(result[3]));
          valueLabelsBySrsiQuery.setPrevValue(DashvueUtils.objectToString(result[4]));
          labels.add(valueLabelsBySrsiQuery);
        }
      }
      return labels;
    } catch (Exception e) {
      return null;
    } finally {
      query.unwrap(ProcedureOutputs.class).release();
    }
  }

  @Override
//  @Transactional
  public List<CaBySrsiResult> getCaBySrsiProc(ServReqSi servReqSi) {
    List<CaBySrsiResult> caLabels = new ArrayList<>();
    StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("getCaBySrsi");
    query.setParameter("aDocNum", servReqSi.getServReqSiPK().getDocumentNumber());
    query.setParameter("aServItem", servReqSi.getServReqSiPK().getServItemId());
    try {
      List<Object[]> results = query.getResultList();
      for (Object[] result : results) {
        if (null != result) {
          CaBySrsiResult caBySrsiResult = new CaBySrsiResult();
          caBySrsiResult.setValueLabel(DashvueUtils.objectToString(result[0]));
          caBySrsiResult.setValidValue(DashvueUtils.objectToString(result[1]));
          caBySrsiResult.setActivityCd(DashvueUtils.objectToString(result[2]));
          caBySrsiResult.setValueUom(DashvueUtils.objectToString(result[3]));
          caBySrsiResult.setCaId(DashvueUtils.objectToString(result[4]));
          caBySrsiResult.setMap(DashvueUtils.objectToString(result[5]));
          caBySrsiResult.setScv(DashvueUtils.objectToString(result[6]));
          caLabels.add(caBySrsiResult);
        }
      }
      return caLabels;
    } catch (Exception e) {
      return null;
    } finally {
      query.unwrap(ProcedureOutputs.class).release();
    }
  }

  @Override
  public Circuit getCircuit(ServReqSi servReqSi){
    ServItem servItem = servItemService.findOne(servReqSi.getServReqSiPK().getServItemId());
    if(null != servItem && null != servItem.getCircuitDesignId()) {
      return circuitService.findOne(servItem.getCircuitDesignId());
    }
    return null;
  }

}
