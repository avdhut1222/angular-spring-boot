package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mankavale, Avdhut
 * Created: 10/29/2018 1:55 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccount {

  private String customerAccountNumber;
  private String customerCompanyName;
  private String customerPriorityCode;
  private String serviceCategoryName;

}
