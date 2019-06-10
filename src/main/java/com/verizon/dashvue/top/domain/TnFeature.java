package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mankavale, Avdhut
 * Created: 10/12/2018 11:01 AM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TnFeature {
  private String circuit;
  private String features;
  private String status;
  private String valueLabel;
  private String validValue;

}
