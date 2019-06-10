package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "TEL_NUM_INV", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class TelNumInv implements Serializable {

  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class TelNumInvPK implements Serializable {

    @Column(name = "TEL_NBR_NPA")
    private String telNbrNpa;

    @Column(name = "TEL_NBR_NXX")
    private String telNbrNxx;

    @Column(name = "TEL_NBR_LINE_RANGE")
    private String telNbrLineRange;

    @Column(name = "TEL_NBR_SUF")
    private String telNbrSuf;

  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private TelNumInvPK telNumInvPK;

  @Column(name = "DISCON_RESERVE_UNTIL_DT")
  private Date disconReserveUntilDt;

  @Column(name = "TEL_NBR_STATUS")
  private String telNbrStatus;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "WTN_EXPIRATION_DT")
  private Date wtnExpirationDt;

  @Column(name = "TEL_NUM_REQUEST_ID")
  private Long telNumRequestId;

  @Column(name = "NBR_OF_SIMUL_CONN")
  private Long nbrOfSimulConn;

  @Column(name = "INTERCEPT_PERIOD_END_DT")
  private Date interceptPeriodEndDt;

  @Column(name = "FOREIGN_TN_IND")
  private String foreignTnInd;

  @Column(name = "RESP_ORG")
  private String respOrg;

  @Column(name = "VANITY_IND")
  private String vanityInd;

  @Column(name = "TELNBR_TYPE_CD")
  private String telnbrTypeCd;

  @Column(name = "FROM_EFF_DT")
  private Date fromEffDt;

  @Column(name = "TO_EFF_DT")
  private Date toEffDt;

  @Column(name = "LOCAL_LIST_TYPE")
  private String localListType;

  @Column(name = "FOREIGN_LIST_TYPE")
  private String foreignListType;

  @Column(name = "CUST_ACCT_ID")
  private Long custAcctId;

  @Column(name = "NENA_EXTRACT_IND")
  private String nenaExtractInd;

  @Column(name = "NENA_EXTRACT_DT")
  private Date nenaExtractDt;

  @Column(name = "LRN_NBR")
  private String lrnNbr;

  @Column(name = "LRN_NBR_TEXT")
  private String lrnNbrText;

  @Column(name = "LOCATION_ID")
  private Long locationId;

  @Column(name = "COUNTRY_TN_CD")
  private String countryTnCd;

  @Column(name = "API_CHECKPOINT_ID")
  private Long apiCheckpointId;

  @Column(name = "API_ACTIVITY_NBR_CD")
  private Long apiActivityNbrCd;

  @Column(name = "NBR_INV_ID")
  private Long nbrInvId;

  @Column(name = "TNI_CATEGORY_ID")
  private Long tniCategoryId;

  @Column(name = "TNI_SUBCATEGORY_ID")
  private Long tniSubcategoryId;


}
