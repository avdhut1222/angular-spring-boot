package com.verizon.dashvue.top.service;

import com.verizon.dashvue.top.domain.PsrSearchResultModel;
import com.verizon.dashvue.top.domain.PsrServiceLocation;
import com.verizon.dashvue.top.domain.PsrDetails;
import com.verizon.dashvue.top.domain.PsrOrderDetails;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 9/26/2018 2:13 PM
 */
public interface TopPsrService {

  PsrOrderDetails getPsrOrderDetails(Long docNum);

  PsrServiceLocation getPsrServiceLocation(Long docNum);

  PsrDetails getPsrDetails(Long docNum);

  List<PsrSearchResultModel> getPsrSearchResults(String searchCriteria, String searchValue);
}
