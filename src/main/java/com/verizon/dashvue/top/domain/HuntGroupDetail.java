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
public class HuntGroupDetail {
  private String huntFr;
  private String huntTo;
  private String activity;
  private String number;
  private String details;

}
