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
@Table(name = "END_USER_LOCATION", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class EndUserLocation implements Serializable {

  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class EndUserLocationPK implements Serializable {

    @Column(name = "END_USER_LOCATION_ID")
    private String endUserLocationId;

    @Column(name = "END_USER_LOCATION_TYPE")
    private String endUserLocationType;
  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private EndUserLocationPK endUserLocationPK;

  @Column(name = "END_USER_NAME")
  private String endUserName;

  @Column(name = "END_USER_LOCATION_NAME")
  private String endUserLocationName;

  @Column(name = "STREET")
  private String street;

  @Column(name = "BUILDING")
  private String building;

  @Column(name = "FLOOR")
  private String floor;

  @Column(name = "ROOM")
  private String room;

  @Column(name = "ZIP_CODE")
  private String zipCode;

  @Column(name = "ACCESS_TEL_NUMBER")
  private String accessTelNumber;

  @Column(name = "SECONDARY_CONNECT_FAC")
  private String secondaryConnectFac;

  @Column(name = "SECONDARY_POINT_OF_TERMINATION")
  private String secondaryPointOfTermination;

  @Column(name = "JACK_CODE")
  private String jackCode;

  @Column(name = "JACK_NUMBER")
  private String jackNumber;

  @Column(name = "JACK_POSITION")
  private Long jackPosition;

  @Column(name = "JACK_STATUS")
  private String jackStatus;

  @Column(name = "PROTECTIVE_CONN_ARRANGEMENT")
  private String protectiveConnArrangement;

  @Column(name = "GEN_EXCH_TARIFF_OPT_EUL")
  private String genExchTariffOptEul;

  @Column(name = "GEN_EXCH_TAR_OPT_BILL_TEL_NMBR")
  private String genExchTarOptBillTelNmbr;

  @Column(name = "ACCESS_INFORMATION")
  private String accessInformation;

  @Column(name = "ADDITIONAL_LOCATION_DETAILS")
  private String additionalLocationDetails;

  @Column(name = "EXEMPT_REASON_CODE")
  private String exemptReasonCode;

  @Column(name = "SURCHARGE_STATUS")
  private String surchargeStatus;

  @Column(name = "SURCHARGE_STATUS_QUANTITY")
  private Long surchargeStatusQuantity;

  @Column(name = "TRANSMIT_TLV")
  private Long transmitTlv;

  @Column(name = "RECEIVE_TLV")
  private Long receiveTlv;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "NETWORK_CHANNEL_INTERFACE_CODE")
  private String networkChannelInterfaceCode;

  @Column(name = "CITY_NAME")
  private String cityName;

  @Column(name = "STATE_CODE")
  private String stateCode;

  @Column(name = "LOCATION_ID")
  private Long locationId;

  @Column(name = "DOCUMENT_NUMBER")
  private Long documentNumber;

  @Column(name = "DOCUMENT_NUMBER_2")
  private Long documentNumber2;

  @Column(name = "REFERENCE_NUMBER")
  private String referenceNumber;

  @Column(name = "SEC_CONNECTING_FAC_ASSIGN_USE")
  private String secConnectingFacAssignUse;

  @Column(name = "RINGER_EQUIVALENCE")
  private String ringerEquivalence;

  @Column(name = "CENTREX_TELEPHONE_NUMBER")
  private String centrexTelephoneNumber;

  @Column(name = "CENTREX_LISTED_NAME")
  private String centrexListedName;

  @Column(name = "SECONDARY_TRANSMIT_TLV")
  private Long secondaryTransmitTlv;

  @Column(name = "SECONDARY_RECEIVE_TLV")
  private Long secondaryReceiveTlv;

  @Column(name = "ACCESS_PROVIDER_SERV_CTR_CODE")
  private String accessProviderServCtrCode;

  @Column(name = "SPOT_INDICATOR")
  private String spotIndicator;

  @Column(name = "LOCAL_SERVING_OFFICE")
  private String localServingOffice;

  @Column(name = "WORKING_TELEPHONE_NUMBER")
  private String workingTelephoneNumber;

  @Column(name = "ENDUSER_CONTACT_NAME")
  private String enduserContactName;

  @Column(name = "ENDUSER_CONTACT_TELEPHONE_NUM")
  private String enduserContactTelephoneNum;

  @Column(name = "LOCAL_CONTACT_NAME")
  private String localContactName;

  @Column(name = "DOCUMENT_NUMBER_AR")
  private Long documentNumberAr;

  @Column(name = "REFERENCE_NUMBER_AR")
  private String referenceNumberAr;

  @Column(name = "LOCATION_ID_EQUIP")
  private Long locationIdEquip;

  @Column(name = "HOUSE_NBR")
  private String houseNbr;

  @Column(name = "HOUSE_NBR_SUF")
  private String houseNbrSuf;

  @Column(name = "PRE_DIRECTIONAL")
  private String preDirectional;

  @Column(name = "STREET_NM")
  private String streetNm;

  @Column(name = "STREET_SUF")
  private String streetSuf;

  @Column(name = "POST_DIRECTIONAL")
  private String postDirectional;

  @Column(name = "REMARK")
  private String remark;

  @Column(name = "PULSING_TYPE")
  private String pulsingType;

  @Column(name = "SIGNALING_TYPE")
  private String signalingType;

  @Column(name = "START_SIGNALING_TYPE")
  private String startSignalingType;

  @Column(name = "NBR_OF_TRANSMISSION_WIRES")
  private String nbrOfTransmissionWires;

  @Column(name = "HOUSE_NBR_PRE")
  private String houseNbrPre;

  @Column(name = "LOCATION_ID_SR")
  private Long locationIdSr;

  @Column(name = "SMART_JACK_CD")
  private String smartJackCd;

  @Column(name = "E911_PAYABLE_ENTITY")
  private String e911PayableEntity;

  @Column(name = "GEN_EXCH_TARIFF_OPT_CONTACT_NM")
  private String genExchTariffOptContactNm;

  @Column(name = "GEN_EXCH_TARIFF_OPT_TEL_NBR")
  private String genExchTariffOptTelNbr;

  @Column(name = "SEC_CROSS_CONNECT_EQ_ASSIGN")
  private String secCrossConnectEqAssign;

  @Column(name = "ALT_ACC_TEL_NBR")
  private String altAccTelNbr;

  @Column(name = "ACC_PGR_NBR")
  private String accPgrNbr;

  @Column(name = "ACC_PAGR_PIN_NBR")
  private String accPagrPinNbr;

  @Column(name = "RESALE_CD")
  private String resaleCd;

  @Column(name = "INCORPORATED_CD")
  private String incorporatedCd;

  @Column(name = "ESN")
  private String esn;

  @Column(name = "TAR_CODE")
  private String tarCode;

  @Column(name = "PSAP_ID")
  private String psapId;

  @Column(name = "LANDMARK_ADDRESS")
  private String landmarkAddress;

  @Column(name = "EXCHANGE_AREA_NUMBER")
  private String exchangeAreaNumber;

  @Column(name = "COUNTY_ID")
  private String countyId;

  @Column(name = "PARTY_ID")
  private Long partyId;

  @Column(name = "PARTY_ROLE_SEQ")
  private Long partyRoleSeq;


}
