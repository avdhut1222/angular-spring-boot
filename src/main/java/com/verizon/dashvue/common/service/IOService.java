package com.verizon.dashvue.common.service;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 9/26/2018 1:31 PM
 */
public interface IOService<T extends Serializable, ID extends Serializable> {

  T findOne(final ID id);

  List<T> findAll();

  Page<T> findPaginated(int page, int size);

  // write

//  T create(final T entity);
//
//  T update(final T entity);
//
//  void delete(final T entity);
//
//  void deleteById(final long entityId);

}
