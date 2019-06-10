package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.AssignedTelNum;
import com.verizon.dashvue.common.repository.dashvue.AssignedTelNumRepository;
import com.verizon.dashvue.common.service.AssignedTelNumService;
import com.verizon.dashvue.common.service.ServItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/15/2019 2:40 PM
 */
@Service
//@Transactional
public class AssignedTelNumServiceImpl extends AbstractService<AssignedTelNum, Long> implements AssignedTelNumService {

  @Qualifier("dashvueEntityManager")
  @Autowired
  EntityManager dashvueEntityManager;

  @Autowired
  AssignedTelNumRepository assignedTelNumRepository;

  @Autowired
  ServItemService servItemService;

  @Override
  protected PagingAndSortingRepository<AssignedTelNum, Long> getRepository() {
    return assignedTelNumRepository;
  }

  @Override
  public List<AssignedTelNum> getByDocNumAndServItemIds(Long docNum, List<Long> servItemIds){
    return assignedTelNumRepository.findByDocNumSerAndServItemIds(docNum, servItemIds);
  }

  @Override
  public String getServItemDescription(AssignedTelNum assignedTelNum) {
    return servItemService.findOne(assignedTelNum.getServItemId()).getServItemDesc();
  }

}
