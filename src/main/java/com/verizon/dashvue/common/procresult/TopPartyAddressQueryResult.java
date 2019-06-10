package com.verizon.dashvue.common.procresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mankavale, Avdhut
 * Created: 3/11/2019 3:14 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopPartyAddressQueryResult {

  private String name;
  private String sapr;
  private String sano;
  private String sasf;
  private String sasd;
  private String sasn;
  private String sath;
  private String sass;
  private String ld1;
  private String lv1;
  private String ld2;
  private String lv2;
  private String city;
  private String state;
  private String zip;
}
