package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.ServItem;
import com.verizon.dashvue.common.repository.dashvue.ServItemRepository;
import com.verizon.dashvue.common.service.ServItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/17/2019 4:56 PM
 */

@Service
//@Transactional
public class ServItemServiceImpl extends AbstractService<ServItem, Long> implements ServItemService {

  @Autowired
  ServItemRepository servItemRepository;

  @Override
  protected PagingAndSortingRepository<ServItem, Long> getRepository() {
    return servItemRepository;
  }


  @Override
  public List<ServItem> getSiByServItemIds(List<Long> servItemIds){
    return servItemRepository.findSiByServItemIds(servItemIds);
  }

}
