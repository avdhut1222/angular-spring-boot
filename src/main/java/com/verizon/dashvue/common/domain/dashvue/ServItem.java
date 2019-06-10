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
@Table(name = "SERV_ITEM", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServItem implements Serializable {

  @Id
  @Column(name = "SERV_ITEM_ID")
  @EqualsAndHashCode.Include
  private Long servItemId;

  @Column(name = "STATUS")
  private String status;

  @Column(name = "FROM_EFFECTIVE_DATE")
  private Date fromEffectiveDate;

  @Column(name = "TO_EFF_DT")
  private Date toEffDt;

  @Column(name = "QTY")
  private Long qty;

  @Column(name = "TELECOM_SRVC_PRIORITY")
  private String telecomSrvcPriority;

  @Column(name = "ITEM_ALIAS")
  private String itemAlias;

  @Column(name = "TRUNK_SEG")
  private String trunkSeg;

  @Column(name = "SPEC_GRP_ID")
  private Long specGrpId;

  @Column(name = "CIRCUIT_DESIGN_ID")
  private Long circuitDesignId;

  @Column(name = "TRUNK_GROUP_DESIGN_ID")
  private Long trunkGroupDesignId;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "SERV_ITEM_TYPE_CD")
  private String servItemTypeCd;

  @Column(name = "SERV_ITEM_DESC")
  private String servItemDesc;

  @Column(name = "SRC_VERIFIED_IND")
  private String srcVerifiedInd;

  @Column(name = "CREATE_USERID")
  private String createUserid;

  @Column(name = "CREATE_DATE")
  private Date createDate;

  @Column(name = "ITEM_ALIAS_SUF")
  private Long itemAliasSuf;

  @Column(name = "DISC_REASON_CD")
  private String discReasonCd;

  @Column(name = "TERM_NBR")
  private String termNbr;

  @Column(name = "ACTIVE_IND")
  private String activeInd;

  @Column(name = "CUST_ACCT_ID")
  private Long custAcctId;

  @Column(name = "INT_EXT_CD")
  private String intExtCd;

  @Column(name = "OWNERSHIP_CD")
  private String ownershipCd;

  @Column(name = "ASSIGNMENT_CONTROL_CD")
  private String assignmentControlCd;

  @Column(name = "CUR_TRBL_IND")
  private String curTrblInd;

  @Column(name = "PREV_CIRCUIT_DESIGN_ID")
  private Long prevCircuitDesignId;

  @Column(name = "DONOR_CUST_ACCT_ID")
  private Long donorCustAcctId;

  @Column(name = "PREV_TRUNK_DESIGN_ID")
  private Long prevTrunkDesignId;

  @Column(name = "ID_XREF")
  private String idXref;

  @Column(name = "UI_LOCATION_CODE")
  private String uiLocationCode;

}
