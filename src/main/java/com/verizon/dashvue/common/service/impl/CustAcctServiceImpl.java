package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.CustAcct;
import com.verizon.dashvue.common.repository.dashvue.CustAcctRepository;
import com.verizon.dashvue.common.service.CustAcctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mankavale, Avdhut
 * Created: 10/29/2018 1:50 PM
 */

@Service
//@Transactional
public class CustAcctServiceImpl extends AbstractService<CustAcct, Long> implements CustAcctService {

  @Autowired
  CustAcctRepository repository;

  @Override
  protected PagingAndSortingRepository<CustAcct, Long> getRepository() {
    return repository;
  }
}
