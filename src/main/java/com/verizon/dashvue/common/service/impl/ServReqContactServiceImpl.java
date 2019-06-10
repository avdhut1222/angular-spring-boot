package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.ServReqContact;
import com.verizon.dashvue.common.repository.dashvue.ServReqContactRepository;
import com.verizon.dashvue.common.service.ServReqContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 10/22/2018 11:36 AM
 */

@Service
//@Transactional
public class ServReqContactServiceImpl extends AbstractService<ServReqContact, ServReqContact.ServReqContactPK> implements ServReqContactService {

  @Autowired
  ServReqContactRepository repository;

  @Override
  protected PagingAndSortingRepository<ServReqContact, ServReqContact.ServReqContactPK> getRepository() {
    return repository;
  }

  @Override
  public List<ServReqContact> findServReqContactByDocNum(Long docNum){
    return docNum != null ? repository.getServReqContactByDocNum(docNum) : null;
  }
}
