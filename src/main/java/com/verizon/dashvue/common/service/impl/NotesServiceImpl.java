package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.Notes;
import com.verizon.dashvue.common.repository.dashvue.NotesRepository;
import com.verizon.dashvue.common.service.NotesService;
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
public class NotesServiceImpl extends AbstractService<Notes, Long> implements NotesService {

  @Autowired
  NotesRepository repository;

  @Override
  protected PagingAndSortingRepository<Notes, Long> getRepository() {
    return repository;
  }

  @Override
  public List<Notes> getNotesByDocumentNumber(Long docNum){
    return repository.findNotesByDocumentNumber(docNum);
  }
}
