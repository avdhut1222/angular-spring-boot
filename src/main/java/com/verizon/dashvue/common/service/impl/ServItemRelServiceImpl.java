package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.ServItemRel;
import com.verizon.dashvue.common.domain.dashvue.ServReqContact;
import com.verizon.dashvue.common.repository.dashvue.ServItemRelRepository;
import com.verizon.dashvue.common.repository.dashvue.ServReqContactRepository;
import com.verizon.dashvue.common.service.ServItemRelService;
import com.verizon.dashvue.common.service.ServReqContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 10/22/2018 11:36 AM
 */

@Service
//@Transactional
public class ServItemRelServiceImpl extends AbstractService<ServItemRel, ServItemRel.ServItemRelPK> implements ServItemRelService {

  @Autowired
  ServItemRelRepository repository;

  @Override
  protected PagingAndSortingRepository<ServItemRel, ServItemRel.ServItemRelPK> getRepository() {
    return repository;
  }

  @Override
  public List<ServItemRel> getRootProducts(List<Long> servItemIds){
    if(!CollectionUtils.isEmpty(servItemIds)) {
      return repository.getRootProducts(servItemIds);
    }
    return null;
  }
}
