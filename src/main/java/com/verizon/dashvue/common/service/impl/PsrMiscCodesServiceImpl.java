package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.PsrMiscCodes;
import com.verizon.dashvue.common.repository.dashvue.PsrMiscCodesRepository;
import com.verizon.dashvue.common.service.PsrMiscCodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mankavale, Avdhut
 * Created: 10/23/2018 12:26 PM
 */

@Service
//@Transactional
public class PsrMiscCodesServiceImpl extends AbstractService<PsrMiscCodes, PsrMiscCodes.PsrMiscCodesPK> implements PsrMiscCodesService {

  @Autowired
  PsrMiscCodesRepository repository;

  @Override
  protected PagingAndSortingRepository<PsrMiscCodes, PsrMiscCodes.PsrMiscCodesPK> getRepository() {
    return repository;
  }

  @Override
  public Map<String, String> getMiscCodeCategoryDescMap(String miscCodeCategory){
    Map<String, String> miscCodeCategoryDesc = new HashMap<>();
    for(PsrMiscCodes psrMiscCodes : repository.findAllByMiscellaneousCodeCategory(miscCodeCategory)){
      miscCodeCategoryDesc.put( psrMiscCodes.getPsrMiscCodesPK().getMiscellaneousCodeValue(), psrMiscCodes.getShortDescription());
    }
    return miscCodeCategoryDesc;
  }
}
