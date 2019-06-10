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
@Table(name = "ADDRESS", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class Address implements Serializable {

  @Id
  @Column(name = "ADDRESS_ID")
  @EqualsAndHashCode.Include
  private Long addressId;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "ADDR_LN1")
  private String addrLine1;

  @Column(name = "ADDR_LN2")
  private String addrLine2;

  @Column(name = "ADDR_LN3")
  private String addrLine3;

  @Column(name = "ADDR_LN4")
  private String addrLine4;

  @Column(name = "ADDR_LN5")
  private String addrLine5;

  @Column(name = "ADDR_LN6")
  private String addrLine6;

  @Column(name = "ADDR_LN7")
  private String addrLine7;

  @Column(name = "STREET_NBR")
  private String streetNbr;

  @Column(name = "STREET_NM")
  private String streetName;

  @Column(name = "STREET_SUF")
  private String streetSuf;

  @Column(name = "POSTAL_CD")
  private String postalCd;

  @Column(name = "ADDR_COMP1")
  private String addrComp1;

  @Column(name = "ADDR_COMP2")
  private String addrComp2;

  @Column(name = "ADDR_COMP3")
  private String addrComp3;

  @Column(name = "ADDR_COMP4")
  private String addrComp4;

  @Column(name = "ADDR_COMP5")
  private String addrComp5;

  @Column(name = "ADDR_COMP6")
  private String addrComp6;

  @Column(name = "ADDR_COMP7")
  private String addrComp7;

  @Column(name = "ADDR_COMP8")
  private String addrComp8;

  @Column(name = "ADDR_COMP9")
  private String addrComp9;

  @Column(name = "ADDR_COMP10")
  private String addrComp10;

  @Column(name = "ADDR_COMP11")
  private String addrComp11;

  @Column(name = "ADDR_COMP12")
  private String addrComp12;

  @Column(name = "ADDR_COMP13")
  private String addrComp13;

  @Column(name = "ADDR_COMP14")
  private String addrComp14;

  @Column(name = "ADDR_COMP15")
  private String addrComp15;

  @Column(name = "ADDR_COMP16")
  private String addrComp16;

  @Column(name = "ADDR_VALID_IND")
  private String addrValidInd;

  @Column(name = "ADDR_FORMAT_TYPE")
  private String addrFormatType;

  @Column(name = "SF_TYPE_NM")
  private String sfTypeName;

  @Column(name = "SF_STRUC_FORMAT_NM")
  private String sfStrucFormatName;

  @Column(name = "ACTIVE_IND")
  private String activeInd;

  @Column(name = "GA_INSTANCE_ID_ADDR_GAT_COMP1")
  private Long gaInstanceIdAddrGatComp1;

  @Column(name = "GA_INSTANCE_ID_ADDR_GAT_COMP2")
  private Long gaInstanceIdAddrGatComp2;

  @Column(name = "GA_INSTANCE_ID_ADDR_GAT_COMP3")
  private Long gaInstanceIdAddrGatComp3;

  @Column(name = "GA_INSTANCE_ID_ADDR_GAT_COMP4")
  private Long gaInstanceIdAddrGatComp4;

  @Column(name = "GA_INSTANCE_ID_CITY")
  private Long gaInstanceIdCity;

  @Column(name = "GA_INSTANCE_ID_STATE_CD")
  private Long gaInstanceIdStateCd;

  @Column(name = "GA_INSTANCE_ID_COUNTRY")
  private Long gaInstanceIdCountry;

  @Column(name = "VALIDATION_CD")
  private String validationCd;

  @Column(name = "NEW_CONSTRUCTION")
  private String newConstruction;

  @Column(name = "ORDINANCE_NBR")
  private String ordinanceNbr;

}
