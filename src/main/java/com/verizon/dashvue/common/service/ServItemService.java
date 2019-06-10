package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.ServItem;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/17/2019 4:56 PM
 */
public interface ServItemService extends IOService<ServItem, Long> {

  List<ServItem> getSiByServItemIds(List<Long> servItemIds);
}
