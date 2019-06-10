package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.NstConfigTypeSrsi;
import com.verizon.dashvue.common.repository.dashvue.NstConfigTypeSrsiRepository;
import com.verizon.dashvue.common.service.NstConfigTypeSrsiService;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/6/2019 4:11 PM
 */
@Service
//@Transactional
public class NstConfigTypeSrsiServiceImpl extends AbstractService<NstConfigTypeSrsi, NstConfigTypeSrsi.NstConfigTypeSrsiPK> implements NstConfigTypeSrsiService {

  @Qualifier("dashvueEntityManager")
  @Autowired
  EntityManager dashvueEntityManager;

  @Autowired
  NstConfigTypeSrsiRepository repository;

  @Override
  protected PagingAndSortingRepository<NstConfigTypeSrsi, NstConfigTypeSrsi.NstConfigTypeSrsiPK> getRepository() {
    return repository;
  }

  @Override
  public List<NstConfigTypeSrsi> getNstConfigTypeSrsiByDocNum(Long documentNumber) {
    return repository.findNstConfigTypeSrsiByDocNum(documentNumber);
  }

  @Override
//  @Transactional
  public List<Object> getSpecificValueLabel(Long documentNumber, Long servItemId, String valueLabel) {
    StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("getSpecificValueLabel");
    query.setParameter("aDocNum", documentNumber);
    query.setParameter("aServItem", servItemId);
    query.setParameter("aValueLabel", valueLabel);
    try {
      List<Object> results = query.getResultList();
      return results;
    } catch (Exception e) {
      return null;
    } finally {
      query.unwrap(ProcedureOutputs.class).release();
    }
  }
}
