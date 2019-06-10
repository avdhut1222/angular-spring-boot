package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Embeddable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "SRSI_ORDER_SUPPLEMENT", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class SrsiOrderSupplement implements Serializable {

  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  public static class SrsiOrderSupplementPK implements Serializable {

    @Column(name = "DOCUMENT_NUMBER")
    private Long documentNumber;

    @Column(name = "SERV_ITEM_ID")
    private Long servItemId;
  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private SrsiOrderSupplementPK srsiOrderSupplementPK;

  @Column(name = "TYPE_OF_SR")
  private String typeOfSr;

  @Column(name = "RATE_CODE")
  private String rateCode;

  @Column(name = "ADDITIONAL_POINT_OF_TERM")
  private String additionalPointOfTerm;

  @Column(name = "APOT_INDICATOR")
  private String apotIndicator;

  @Column(name = "CONNECTING_FACILITY_ASSIGNMENT")
  private String connectingFacilityAssignment;

  @Column(name = "SERVICE_PROVIDER")
  private String serviceProvider;

  @Column(name = "FRAMING")
  private String framing;

  @Column(name = "FRAMING_ANSI_IND")
  private String framingAnsiInd;

  @Column(name = "LINE_CODING")
  private String lineCoding;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "OWNED_LEASED_CD")
  private String ownedLeasedCd;

  @Column(name = "PON")
  private String pon;

  @Column(name = "DESIRED_DUE_DATE")
  private Date desiredDueDate;

  @Column(name = "NETWORK_CHANNEL_SERVICE_CODE")
  private String networkChannelServiceCode;

  @Column(name = "NETWORK_CHANNEL_OPTION_CODE")
  private String networkChannelOptionCode;

  @Column(name = "SVC_TYPE_EXT_CD")
  private String svcTypeExtCd;

  @Column(name = "SERVICE_TYPE_CODE")
  private String serviceTypeCode;

  @Column(name = "SERVICE_TYPE_CATEGORY")
  private String serviceTypeCategory;

  @Column(name = "CUST_CKT_DESC")
  private String custCktDesc;

  @Column(name = "JURISDICTION_CODE")
  private String jurisdictionCode;

  @Column(name = "NNI_UNI_CD")
  private String nniUniCd;

  @Column(name = "BIT_RATE_QUANTITY")
  private Long bitRateQuantity;

  @Column(name = "BIT_RATE_UOM")
  private String bitRateUom;

  @Column(name = "CLOCK_SRC")
  private Long clockSrc;

}
