package com.verizon.dashvue.common.service.impl;

import com.google.common.collect.Lists;
import com.verizon.dashvue.common.domain.dashvue.DlrCircuitDesignLine;
import com.verizon.dashvue.common.service.IOService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 9/26/2018 1:58 PM
 */

//@Transactional
public abstract class AbstractService<T extends Serializable, ID extends Serializable> implements IOService<T, ID> {

  // read - one

  @Override
  @Transactional(readOnly = true)
  public T findOne(final ID id) {
    return getRepository().findById(id).orElse(null);
  }

  // read - all

  @Override
  @Transactional(readOnly = true)
  public List<T> findAll() {
    return Lists.newArrayList(getRepository().findAll());
  }

  @Override
  public Page<T> findPaginated(final int page, final int size) {
    return getRepository().findAll(PageRequest.of(page, size));
  }

  // write

//  @Override
//  public T create(final T entity) {
//    return getDao().save(entity);
//  }
//
//  @Override
//  public T update(final T entity) {
//    return getDao().save(entity);
//  }
//
//  @Override
//  public void delete(final T entity) {
//    getDao().delete(entity);
//  }
//
//  @Override
//  public void deleteById(final long entityId) {
//    getDao().deleteById(entityId);
//  }

  protected abstract PagingAndSortingRepository<T, ID> getRepository();

}
