package com.verizon.dashvue.common.procresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mankavale, Avdhut
 * Created: 3/18/2019 2:28 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationQuery {
  private Long servItemId;
  private String itemAlias;
  private String activityCd;
  private String sslServLocUse;
  private String locationId;
  private String locationName;
  private String custClli;
  private String addrLn1;
  private String addrLn2;
  private String addrLn3;
  private String addrLn4;
  private String addrLn5;
  private String suite;
  private String floor;
  private String room;
  private String additionalAddressInfo;
  private String locDescr;
  private String custDemarc;
  private String tnSwitch;
  private String connectingFacility;
  private String fromChanAssignment;
  private String toChanAssignment;
}
