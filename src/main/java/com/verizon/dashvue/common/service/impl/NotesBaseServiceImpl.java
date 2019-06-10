package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.infostore.NotesBase;
import com.verizon.dashvue.common.repository.infostore.NotesBaseRepository;
import com.verizon.dashvue.common.service.NotesBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Mankavale, Avdhut
 * Created: 10/22/2018 11:36 AM
 */

@Service
//@Transactional
public class NotesBaseServiceImpl extends AbstractService<NotesBase, Long> implements NotesBaseService {

  @Autowired
  NotesBaseRepository repository;

  @Override
  protected PagingAndSortingRepository<NotesBase, Long> getRepository() {
    return repository;
  }

  @Override
  public List<NotesBase> getNotesBaseByDocumentNumber(Long docNum){
    return repository.findNotesBaseByDocumentNumber(docNum);
  }
}
