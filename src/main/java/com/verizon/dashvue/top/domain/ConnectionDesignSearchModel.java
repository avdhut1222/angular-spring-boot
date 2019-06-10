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
public class ConnectionDesignSearchModel {

  private String circuitType;
  private String locationA;
  private String locationZ;
  private String designation;
  private String rateCode;

}
