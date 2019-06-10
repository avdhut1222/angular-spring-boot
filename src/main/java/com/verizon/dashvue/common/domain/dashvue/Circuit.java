package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "CIRCUIT", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
@NamedStoredProcedureQueries({
  @NamedStoredProcedureQuery(
    name = "topCktQuery",
    procedureName = "ASAP.PKG_XO_DASHVUE.TOP_CKT_QUERY",
    parameters = {
      @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "iCktType"),
      @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "iLocA"),
      @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "iLocZ"),
      @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "iDesgn"),
      @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "iRateCode"),
      @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oRetVal"),
      @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oRetTxt"),
      @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oRetCsr"),
    }
  ),
  @NamedStoredProcedureQuery(
    name = "locationQuery",
    procedureName = "ASAP.PKG_XO_DASHVUE.LOCATION_QUERY",
    parameters = {
      @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "iDocNbr"),
      @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oRetVal"),
      @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oRetTxt"),
      @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oRetCsr"),
    }
  )
})
public class Circuit implements Serializable {

  @Id
  @Column(name = "CIRCUIT_DESIGN_ID")
  @EqualsAndHashCode.Include
  private Long circuitDesignId;

  @Column(name = "EXCHANGE_CARRIER_CIRCUIT_ID")
  private String exchangeCarrierCircuitId;

  @Column(name = "ACCESS_CUSTOMER_CKT_REF")
  private String accessCustomerCktRef;

  @Column(name = "TYPE")
  private String type;

  @Column(name = "TOTAL_CIRCUIT_MILES")
  private Long totalCircuitMiles;

  @Column(name = "STATUS")
  private String status;

  @Column(name = "CLR_NOTES")
  private String clrNotes;

  @Column(name = "SETTLEMENT_INDICATOR")
  private String settlementIndicator;

  @Column(name = "ENTRANCE_FAC_INTRA_INTER_USE")
  private Long entranceFacIntraInterUse;

  @Column(name = "ENTRANCE_FAC_INTER_INTER_USE")
  private Long entranceFacInterInterUse;

  @Column(name = "MONTHLY_DAILY_INDICATOR")
  private String monthlyDailyIndicator;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "SERVICE_TYPE_CATEGORY")
  private String serviceTypeCategory;

  @Column(name = "SERVICE_TYPE_CODE")
  private String serviceTypeCode;

  @Column(name = "LOCATION_ID")
  private Long locationId;

  @Column(name = "LOCATION_ID_2")
  private Long locationId2;

  @Column(name = "LOCATION_ID_3")
  private Long locationId3;

  @Column(name = "LOCATION_ID_4")
  private Long locationId4;

  @Column(name = "JURISDICTION_CODE")
  private String jurisdictionCode;

  @Column(name = "ALLTEL_BILLING_NUMBER")
  private String alltelBillingNumber;

  @Column(name = "ECCKT_TYPE")
  private String eccktType;

  @Column(name = "LOOP_COUNT_A")
  private Long loopCountA;

  @Column(name = "LOOP_COUNT_B")
  private Long loopCountB;

  @Column(name = "GROUP_BILL_NUMBER")
  private String groupBillNumber;

  @Column(name = "GROUP_BILL_INDICATOR")
  private String groupBillIndicator;

  @Column(name = "ASSOCIATED_BILLING_NUMBER")
  private String associatedBillingNumber;

  @Column(name = "NUMBER_OPEN_ORDERS")
  private Long numberOpenOrders;

  @Column(name = "A_PLT_OFC_END_SECTION")
  private Long aPltOfcEndSection;

  @Column(name = "Z_PLT_OFC_END_SECTION")
  private Long zPltOfcEndSection;

  @Column(name = "A_PLT_FIELD_END_SECTION")
  private Long aPltFieldEndSection;

  @Column(name = "Z_PLT_FIELD_END_SECTION")
  private Long zPltFieldEndSection;

  @Column(name = "FOREIGN_OWNED_MILES")
  private Long foreignOwnedMiles;

  @Column(name = "OFFICIAL_CIRCUIT_INDICATOR")
  private String officialCircuitIndicator;

  @Column(name = "OFFICIAL_COMPANY_IND")
  private String officialCompanyInd;

  @Column(name = "SVC_TYPE_EXT_CD")
  private String svcTypeExtCd;

  @Column(name = "CUST_CKT_DESC")
  private String custCktDesc;

  @Column(name = "LINE_CODING")
  private String lineCoding;

  @Column(name = "FRAMING")
  private String framing;

  @Column(name = "FRAMING_ANSI_IND")
  private String framingAnsiInd;

  @Column(name = "NETWORK_CHANNEL_SERVICE_CODE")
  private String networkChannelServiceCode;

  @Column(name = "NETWORK_CHANNEL_OPTION_CODE")
  private String networkChannelOptionCode;

  @Column(name = "OWNED_LEASED_CD")
  private String ownedLeasedCd;

  @Column(name = "CHANNELIZED_IND")
  private String channelizedInd;

  @Column(name = "PROTECTED_CKT_IND")
  private String protectedCktInd;

  @Column(name = "INTERLEAVING")
  private String interleaving;

  @Column(name = "LOCATION_ID_LSO_A")
  private Long locationIdLsoA;

  @Column(name = "LOCATION_ID_LSO_Z")
  private Long locationIdLsoZ;

  @Column(name = "RATE_CODE")
  private String rateCode;

  @Column(name = "DS_DIVERSITY_IND")
  private String dsDiversityInd;

  @Column(name = "SPECIAL_ROUTING_CODE_TYPE")
  private String specialRoutingCodeType;

  @Column(name = "SPECIAL_ROUTING_CODE_IO_FAC")
  private String specialRoutingCodeIoFac;

  @Column(name = "SPECIAL_ROUTING_CODE_SECLOC")
  private String specialRoutingCodeSecloc;

  @Column(name = "NST_CON_TYPE")
  private Long nstConType;

  @Column(name = "NST_CON_CATEGORY_CD")
  private Long nstConCategoryCd;

  @Column(name = "NST_BW_TDM_CD")
  private Long nstBwTdmCd;

  @Column(name = "NGN_CONVERTED_IND_TRI")
  private String ngnConvertedIndTri;

  @Column(name = "CON_REDESIGN_CANDIDATE_TRI")
  private String conRedesignCandidateTri;

  @Column(name = "CON_REDESIGN_REASON_CD")
  private Long conRedesignReasonCd;

  @Column(name = "ALLOW_LOWER_RATES_IND")
  private String allowLowerRatesInd;

  @Column(name = "NONNGN_NSCON_CODE")
  private String nonngnNsconCode;

  @Column(name = "PARTITION_GROUP_ID")
  private Long partitionGroupId;

}
