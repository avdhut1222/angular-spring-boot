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
public class PsrSearchResultModel {

  private String psrNumber;
  private String suppType;
  private String shortName;
  private String descriptiveName;
  private String providerSystemId;
  private String product;
  private String rpon;
  private String circuitId;
  private String customer;
  private String project;
  private String provPlan;
  private String psrType;

}
