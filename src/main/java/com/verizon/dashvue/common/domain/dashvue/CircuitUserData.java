package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "CIRCUIT_USER_DATA", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class CircuitUserData implements Serializable {

  @Id
  @Column(name = "CIRCUIT_DESIGN_ID")
  @EqualsAndHashCode.Include
  private Long circuitDesignId;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "OPS_STATUS")
  private Long opsStatus;

  @Column(name = "INTRFACE_DESC")
  private String intrfaceDesc;

  @Column(name = "ENG_PKG")
  private String engPkg;

  @Column(name = "TEST_RESULTS")
  private String testResults;

  @Column(name = "PEERING_CONTACT")
  private Long peeringContact;

  @Column(name = "PEERING_NOC_EMAIL")
  private String peeringNocEmail;

  @Column(name = "PEERING_NOC_TN")
  private String peeringNocTn;

  @Column(name = "NMS_ALARM")
  private Long nmsAlarm;

  @Column(name = "NODE_NAME")
  private String nodeName;

  @Column(name = "NODE_ALIAS")
  private String nodeAlias;

  @Column(name = "NE_FIRST_OCCURRENCE")
  private String neFirstOccurrence;

  @Column(name = "PROVE_KEY")
  private String proveKey;

  @Column(name = "CLLI")
  private String clli;

  @Column(name = "CLASS")
  private String classCol;

  @Column(name = "SUMMARY")
  private String summary;

  @Column(name = "ALERT_KEY")
  private String alertKey;

  @Column(name = "IDENTIFIER")
  private String identifier;

  @Column(name = "LOCATION")
  private String location;

  @Column(name = "MARKET")
  private String market;

  @Column(name = "SRVR_SER_NUM")
  private String srvrSerNum;

  @Column(name = "CIRCUIT_PRIORITY")
  private Long circuitPriority;

  @Column(name = "BELL_INSTALL_CHARGE")
  private String bellInstallCharge;

  @Column(name = "BELL_MONTHLY_CHARGE")
  private String bellMonthlyCharge;

  @Column(name = "CUST_PREF_ROUTE")
  private Long custPrefRoute;

  @Column(name = "CFA")
  private String cfa;

  @Column(name = "SCFA")
  private String scfa;

  @Column(name = "INCLUDE_ON_ASR")
  private Long includeOnAsr;

  @Column(name = "CFA2")
  private String cfa2;

  @Column(name = "CFA3")
  private String cfa3;

  @Column(name = "CFA4")
  private String cfa4;

  @Column(name = "CFA5")
  private String cfa5;

  @Column(name = "CFA6")
  private String cfa6;

  @Column(name = "CFA7")
  private String cfa7;

  @Column(name = "CFA8")
  private String cfa8;

  @Column(name = "CFA9")
  private String cfa9;

  @Column(name = "CFA10")
  private String cfa10;

  @Column(name = "CFA11")
  private String cfa11;

  @Column(name = "CFA12")
  private String cfa12;

  @Column(name = "CFA13")
  private String cfa13;

  @Column(name = "CFA14")
  private String cfa14;

  @Column(name = "CFA15")
  private String cfa15;

  @Column(name = "CFA16")
  private String cfa16;

  @Column(name = "CFA17")
  private String cfa17;

  @Column(name = "CFA18")
  private String cfa18;

  @Column(name = "CFA19")
  private String cfa19;

  @Column(name = "CFA20")
  private String cfa20;

  @Column(name = "CFA21")
  private String cfa21;

  @Column(name = "CFA22")
  private String cfa22;

  @Column(name = "DISCO_ASR_AUTOMATION")
  private Long discoAsrAutomation;

  @Column(name = "DISCO_ASR_DUE_DATE")
  private Date discoAsrDueDate;

  @Column(name = "REQ_HDXCON")
  private Long reqHdxcon;

  @Column(name = "TYPE_II_LEC_XCON_A_LOC")
  private Long typeIiLecXconALoc;

  @Column(name = "TYPE_II_LEC_XCON_Z_LOC")
  private Long typeIiLecXconZLoc;

  @Column(name = "RING_ID")
  private String ringId;


}
