package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.ServReqContact;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 10/22/2018 11:35 AM
 */
public interface ServReqContactService extends IOService<ServReqContact, ServReqContact.ServReqContactPK> {
  List<ServReqContact> findServReqContactByDocNum(Long docNum);
}
