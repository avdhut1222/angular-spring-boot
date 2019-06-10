package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mankavale, Avdhut
 * Created: 12/3/2018 12:50 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PsrSearchModel {

  private String searchCriteria;
  private String searchValue;

}
