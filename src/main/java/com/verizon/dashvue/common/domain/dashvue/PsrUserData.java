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
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "PSR_USER_DATA", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class PsrUserData implements Serializable {

  @Id
  @Column(name = "DOCUMENT_NUMBER")
  @EqualsAndHashCode.Include
  private Long documentNumber;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LINXORDERVERSIONNUMBER")
  private String linxOrderVersionNumber;

  @Column(name = "SALESCHANNEL")
  private String salesChannel;

  @Column(name = "OCN")
  private String ocn;

  @Column(name = "TCSI")
  private String tcsi;

  @Column(name = "PROVPLANNAME")
  private String provPlanName;

  @Column(name = "SALESORDERNUMBER")
  private String salesOrderNumber;

  @Column(name = "WORKORDERNUMBER")
  private String workOrderNumber;

  @Column(name = "MARKET_AREA")
  private Long marketArea;

  @Column(name = "VENDOR_ID")
  private Long vendorId;

  @Column(name = "CLEC_PROVIDER")
  private Long clecProvider;

  @Column(name = "PRE_QUALIFICATION")
  private Long preQualification;

  @Column(name = "HDSL_LOOP_QUALIFICATION")
  private Long hdslLoopQualification;

  @Column(name = "DISTANCE")
  private String distance;

  @Column(name = "CIRCUIT_TYPE")
  private Long circuitType;

  @Column(name = "LOOP_QUALIFICATION_FAILED")
  private Long loopQualificationFailed;

  @Column(name = "FAILURE_REMARKS")
  private String failureRemarks;

  @Column(name = "PROJECT_ID")
  private Long projectId;

  @Column(name = "PROJECTID")
  private Long projectId1;

  @Column(name = "SUB_HOME_GATEWAY")
  private String subHomeGateway;

  @Column(name = "PORTED_TN")
  private Long portedTn;

  @Column(name = "RESPONSIBLE_ORG")
  private String responsibleOrg;

  @Column(name = "TECHNICAL_ICB")
  private String technicalIcb;

  @Column(name = "FEDERAL")
  private Long federal;

  @Column(name = "SERVICE_LABOR")
  private String serviceLabor;

  @Column(name = "DUE_DATE_CATEGORY")
  private Long dueDateCategory;

  @Column(name = "TAX_ID_LOCA")
  private Long taxIdLocation;

  @Column(name = "TAXID_LOCA")
  private Long taxIdLocation1;

  @Column(name = "TAXID_A")
  private String taxIdA;

  @Column(name = "TAXID_LOCZ")
  private Long taxIdLocZ;

  @Column(name = "TAXID_B")
  private String taxIdB;

  @Column(name = "LSR_RECEIVED")
  private String lsrReceived;

  @Column(name = "CUSTOMER_SITE_ID")
  private String customerSiteId;

  @Column(name = "EQP_GTH_INSTRUCTIONS")
  private String eqpGthInstructions;

  @Column(name = "ISRDLY_ORDERS")
  private String isrdlyOrders;

  @Column(name = "PART_ACCT_NAME")
  private String partAcctName;

  @Column(name = "AGENT_CODE")
  private String agentCode;

  @Column(name = "PART_TIER")
  private Long partTier;

  @Column(name = "VENDOR")
  private String vendor;

  @Column(name = "VENDOR_HAND")
  private String vendorHand;

  @Column(name = "NAC_PRECUT")
  private Long nacPrecut;

  @Column(name = "BUNDLE_BREAK")
  private Long bundleBreak;

  @Column(name = "MANDATORY_SITE_SURVEY")
  private Long mandatorySiteSurvey;

  @Column(name = "AFTER_HOURS_CUT")
  private Long afterHoursCut;

  @Column(name = "AFTER_HOURS_CUT_INTERVAL")
  private String afterHoursCutInterval;

  @Column(name = "OUT_OF_MARKET")
  private Long outOfMarket;

  @Column(name = "OUT_OFMARKET")
  private Long outOfMarket1;

  @Column(name = "PM_ORDER_ROUTING")
  private Long pmOrderRouting;

  @Column(name = "LEC_DEMARC")
  private String lecDemarc;

  @Column(name = "TN_INTERNAL_MOVE_INSTALL")
  private Long tnInternalMoveInstall;

  @Column(name = "TN_INTERNAL_MOVE_DISCO")
  private Long tnInternalMoveDisco;

  @Column(name = "CANCELLED_REPLACED_PSR_NUM")
  private String cancelledReplacedPsrNum;

  @Column(name = "LEC_DEMARC_A")
  private String lecDemarcA;

  @Column(name = "LEC_DEMARC_Z")
  private String lecDemarcZ;

  @Column(name = "SERVICE_EXTENSION_INSTRUCTIONS")
  private String serviceExtensionInstructions;

  @Column(name = "CC_RELATED_BRANCH")
  private String ccRelatedBranch;

  @Column(name = "PSR_CONTACT_CENTER")
  private Long psrContactCenter;

  @Column(name = "LOA_CFA_REQUIRED")
  private Long loaCfaRequired;

  @Column(name = "RELATED_HPBX_BRANCH_PSR")
  private Long relatedHpbxBranchPsr;

  @Column(name = "CHANGE_SUP")
  private Long changeSup;

  @Column(name = "PTD_ELIGIBLE")
  private Long ptdEligible;

  @Column(name = "ASR_CCNA")
  private Long asrCcna;

  @Column(name = "ASR_ICSC")
  private Long asrIcsc;

  @Column(name = "ASR_DDD")
  private Date asrDdd;

  @Column(name = "ASR_QTY")
  private Long asrQty;

  @Column(name = "ASR_ACTL")
  private String asrActl;

  @Column(name = "ASR_REMARKS")
  private String asrRemarks;

  @Column(name = "ASR_VTA")
  private String asrVta;

  @Column(name = "ASR_CFA")
  private String asrCfa;

  @Column(name = "ASR_CFA2")
  private String asrCfa2;

  @Column(name = "ASR_CFA3")
  private String asrCfa3;

  @Column(name = "ASR_CFA4")
  private String asrCfa4;

  @Column(name = "ASR_CFA5")
  private String asrCfa5;

  @Column(name = "ASR_CFA6")
  private String asrCfa6;

  @Column(name = "ASR_CFA7")
  private String asrCfa7;

  @Column(name = "ASR_MUXLOC")
  private String asrMuxloc;

  @Column(name = "ASR_CCEA")
  private String asrCcea;

  @Column(name = "ASR_CCEA2")
  private String asrCcea2;

  @Column(name = "ASR_CCEA3")
  private String asrCcea3;

  @Column(name = "ASR_CCEA4")
  private String asrCcea4;

  @Column(name = "ASR_CCEA5")
  private String asrCcea5;

  @Column(name = "ASR_CCEA6")
  private String asrCcea6;

  @Column(name = "ASR_CCEA7")
  private String asrCcea7;

  @Column(name = "LEC_DEMARC_EXT")
  private Long lecDemarcExt;

  @Column(name = "ASR_EUNAME")
  private String asrEuname;

  @Column(name = "ASR_AFT")
  private Long asrAft;

  @Column(name = "ASR_SAPR")
  private String asrSapr;

  @Column(name = "ASR_SANO")
  private String asrSano;

  @Column(name = "ASR_SASF")
  private String asrSasf;

  @Column(name = "ASR_SASD2")
  private String asrSasd2;

  @Column(name = "ASR_SASN")
  private String asrSasn;

  @Column(name = "ASR_SATH")
  private String asrSath;

  @Column(name = "ASR_SASS2")
  private String asrSass2;

  @Column(name = "ASR_LD1")
  private String asrLd1;

  @Column(name = "ASR_LV1")
  private String asrLv1;

  @Column(name = "ASR_LD2")
  private String asrLd2;

  @Column(name = "ASR_LV2")
  private String asrLv2;

  @Column(name = "ASR_LD3")
  private String asrLd3;

  @Column(name = "ASR_LV3")
  private String asrLv3;

  @Column(name = "ASR_CITY")
  private String asrCity;

  @Column(name = "ASR_STATE")
  private String asrState;

  @Column(name = "ASR_ZIP")
  private String asrZip;

  @Column(name = "LINXSALESREP_CHANNELMANAGER")
  private String linxsalesrepChannelmanager;

  @Column(name = "LINX_CONTRACT_TERM")
  private String linxContractTerm;

  @Column(name = "LINX_CIRCUIT_MRC")
  private String linxCircuitMrc;

  @Column(name = "LINX_CIRCUIT_NRC")
  private String linxCircuitNrc;

  @Column(name = "DMARC_NRC")
  private String dmarcNrc;

  @Column(name = "EXPEDITE_FEE")
  private String expediteFee;

  @Column(name = "ICB_CODES_APPROVAL")
  private String icbCodesApproval;

  @Column(name = "NAPT_NUMBER")
  private String naptNumber;

  @Column(name = "EQUIPMENT_ADD_ON_1")
  private Long equipmentAddOn1;

  @Column(name = "EQUIPMENT_ADD_ON_2")
  private Long equipmentAddOn2;

  @Column(name = "EQUIPMENT_ADD_ON_3")
  private Long equipmentAddOn3;

  @Column(name = "CUT_FS_NEEDED")
  private Long cutFsNeeded;

  @Column(name = "ASR_AAI")
  private String asrAai;

  @Column(name = "IPT_SS")
  private Long iptSs;

  @Column(name = "REMOVE_CNR")
  private Long removeCnr;

  @Column(name = "REMOVECNR")
  private Long removeCnr1;

  @Column(name = "REMOVECNR2")
  private Long removeCnr2;

  @Column(name = "NETWORK_EQUIPMENT")
  private Long networkEquipment;

  @Column(name = "EQUIPMENT_ADD_ON_1A")
  private String equipmentAddOn1A;

  @Column(name = "EQUIPMENT_ADD_ON_2A")
  private String equipmentAddOn2A;

  @Column(name = "EQUIPMENT_ADD_ON_3A")
  private String equipmentAddOn3A;

  @Column(name = "LSR_NCON")
  private Long lsrNcon;

  @Column(name = "LSR_LSO")
  private String lsrLso;

  @Column(name = "VENDOR_COST")
  private String vendorCost;

  @Column(name = "UNLINKED_ISRS")
  private String unlinkedIsrs;

  @Column(name = "SEGMENT")
  private Long segment;

  @Column(name = "INSTALL_MARKET")
  private String installMarket;

  @Column(name = "SOURCE_SYSTEM")
  private String sourceSystem;

  @Column(name = "HPBX_TEMP_BYOB")
  private String hpbxTempByob;

  @Column(name = "HPBX_TRAINING_RESCHEDULES")
  private String hpbxTrainingReschedules;

  @Column(name = "SUPP_CUSTOMER_REQUIREMENTS")
  private String suppCustomerRequirements;

  @Column(name = "CNR_EXCLUDED")
  private String cnrExcluded;

  @Column(name = "TF_OE")
  private String tfOe;

  @Column(name = "PRICING_SOURCE")
  private String pricingSource;

  @Column(name = "CONTRACT_SIGNED_DATE")
  private Date contractSignedDate;

  @Column(name = "QUOTE_NUMBER")
  private String quoteNumber;

  @Column(name = "XOMACD_ORDER")
  private String xomacdOrder;

  @Column(name = "XOMACD_CREATOR")
  private String xomacdCreator;

  @Column(name = "TC_TECHNICAL_COORDINATOR")
  private String tcTechnicalCoordinator;

  @Column(name = "ADDITIONAL_CPE_EQUIPMENT")
  private String additionalCpeEquipment;

  @Column(name = "ADDITIONAL_CPE_CONFIG")
  private String additionalCpeConfig;

  @Column(name = "ADDITIONAL_CPE_CONFIG_2")
  private String additionalCpeConfig2;

  @Column(name = "ADDITIONAL_CPE_CONFIG_3")
  private String additionalCpeConfig3;

  @Column(name = "ADDITIONAL_CPE_CONFIG_4")
  private String additionalCpeConfig4;

  @Column(name = "SITE_SURVEY_EXCEPTION_REASON")
  private String siteSurveyExceptionReason;

  @Column(name = "DELAY_RELATED_ORDER")
  private String delayRelatedOrder;

  @Column(name = "ETHERNET_CHANGE_TYPE")
  private Long ethernetChangeType;

  @Column(name = "GROOM_COST_OF_SAVINGS")
  private String groomCostOfSavings;

  @Column(name = "GROOM_PROJECT_NAME")
  private String groomProjectName;

  @Column(name = "DMARC_MRC")
  private String dmarcMrc;

  @Column(name = "LEC_BUILD_A")
  private Long lecBuildA;

  @Column(name = "LEC_BUILD_Z")
  private Long lecBuildZ;

  @Column(name = "MARKET_SEGMENT")
  private Long marketSegment;

  @Column(name = "ONNET_BUILD_TYPE")
  private Long onNetBuildType;

  @Column(name = "NETPROV_CANCELLED")
  private Long netProvCancelled;

  public Map<String, String> getPsrUserDataMap(){
    Map<String, String> psrUserDataMap = new HashMap<>();
    psrUserDataMap.put( "DOCUMENT_NUMBER", this.documentNumber != null ? this.documentNumber.toString() : null );
    psrUserDataMap.put( "LAST_MODIFIED_USERID", this.lastModifiedUserid );
    psrUserDataMap.put( "LAST_MODIFIED_DATE", this.lastModifiedDate != null ? this.lastModifiedDate.toString() : null );
    psrUserDataMap.put( "LINXORDERVERSIONNUMBER", this.linxOrderVersionNumber );
    psrUserDataMap.put( "SALESCHANNEL", this.salesChannel );
    psrUserDataMap.put( "OCN", this.ocn );
    psrUserDataMap.put( "TCSI", this.tcsi );
    psrUserDataMap.put( "PROVPLANNAME", this.provPlanName );
    psrUserDataMap.put( "SALESORDERNUMBER", this.salesOrderNumber );
    psrUserDataMap.put( "WORKORDERNUMBER", this.workOrderNumber );
    psrUserDataMap.put( "MARKET_AREA", this.marketArea != null ? this.marketArea.toString() : null );
    psrUserDataMap.put( "VENDOR_ID", this.vendorId != null ? this.vendorId.toString() : null );
    psrUserDataMap.put( "CLEC_PROVIDER", this.clecProvider != null ? this.clecProvider.toString() : null );
    psrUserDataMap.put( "PRE_QUALIFICATION", this.preQualification != null ? this.preQualification.toString() : null );
    psrUserDataMap.put( "HDSL_LOOP_QUALIFICATION", this.hdslLoopQualification != null ? this.hdslLoopQualification.toString() : null );
    psrUserDataMap.put( "DISTANCE", this.distance );
    psrUserDataMap.put( "CIRCUIT_TYPE", this.circuitType != null ? this.circuitType.toString() : null );
    psrUserDataMap.put( "LOOP_QUALIFICATION_FAILED", this.loopQualificationFailed != null ? this.loopQualificationFailed.toString() : null );
    psrUserDataMap.put( "FAILURE_REMARKS", this.failureRemarks );
    psrUserDataMap.put( "PROJECT_ID", this.projectId != null ? this.projectId.toString() : null );
    psrUserDataMap.put( "PROJECTID", this.projectId1 != null ? this.projectId1.toString() : null );
    psrUserDataMap.put( "SUB_HOME_GATEWAY", this.subHomeGateway );
    psrUserDataMap.put( "PORTED_TN", this.portedTn != null ? this.portedTn.toString() : null );
    psrUserDataMap.put( "RESPONSIBLE_ORG", this.responsibleOrg );
    psrUserDataMap.put( "TECHNICAL_ICB", this.technicalIcb );
    psrUserDataMap.put( "FEDERAL", this.federal != null ? this.federal.toString() : null );
    psrUserDataMap.put( "SERVICE_LABOR", this.serviceLabor );
    psrUserDataMap.put( "DUE_DATE_CATEGORY", this.dueDateCategory != null ? this.dueDateCategory.toString() : null );
    psrUserDataMap.put( "TAX_ID_LOCA", this.taxIdLocation != null ? this.taxIdLocation.toString() : null );
    psrUserDataMap.put( "TAXID_LOCA", this.taxIdLocation1 != null ? this.taxIdLocation1.toString() : null );
    psrUserDataMap.put( "TAXID_A", this.taxIdA );
    psrUserDataMap.put( "TAXID_LOCZ", this.taxIdLocZ != null ? this.taxIdLocZ.toString() : null );
    psrUserDataMap.put( "TAXID_B", this.taxIdB );
    psrUserDataMap.put( "LSR_RECEIVED", this.lsrReceived );
    psrUserDataMap.put( "CUSTOMER_SITE_ID", this.customerSiteId );
    psrUserDataMap.put( "EQP_GTH_INSTRUCTIONS", this.eqpGthInstructions );
    psrUserDataMap.put( "ISRDLY_ORDERS", this.isrdlyOrders );
    psrUserDataMap.put( "PART_ACCT_NAME", this.partAcctName );
    psrUserDataMap.put( "AGENT_CODE", this.agentCode );
    psrUserDataMap.put( "PART_TIER", this.partTier != null ? this.partTier.toString() : null );
    psrUserDataMap.put( "VENDOR", this.vendor );
    psrUserDataMap.put( "VENDOR_HAND", this.vendorHand );
    psrUserDataMap.put( "NAC_PRECUT", this.nacPrecut != null ? this.nacPrecut.toString() : null );
    psrUserDataMap.put( "BUNDLE_BREAK", this.bundleBreak != null ? this.bundleBreak.toString() : null );
    psrUserDataMap.put( "MANDATORY_SITE_SURVEY", this.mandatorySiteSurvey != null ? this.mandatorySiteSurvey.toString() : null );
    psrUserDataMap.put( "AFTER_HOURS_CUT", this.afterHoursCut != null ? this.afterHoursCut.toString() : null );
    psrUserDataMap.put( "AFTER_HOURS_CUT_INTERVAL", this.afterHoursCutInterval );
    psrUserDataMap.put( "OUT_OF_MARKET", this.outOfMarket != null ? this.outOfMarket.toString() : null );
    psrUserDataMap.put( "OUT_OFMARKET", this.outOfMarket1 != null ? this.outOfMarket1.toString() : null );
    psrUserDataMap.put( "PM_ORDER_ROUTING", this.pmOrderRouting != null ? this.pmOrderRouting.toString() : null );
    psrUserDataMap.put( "LEC_DEMARC", this.lecDemarc );
    psrUserDataMap.put( "TN_INTERNAL_MOVE_INSTALL", this.tnInternalMoveInstall != null ? this.tnInternalMoveInstall.toString() : null );
    psrUserDataMap.put( "TN_INTERNAL_MOVE_DISCO", this.tnInternalMoveDisco != null ? this.tnInternalMoveDisco.toString() : null );
    psrUserDataMap.put( "CANCELLED_REPLACED_PSR_NUM", this.cancelledReplacedPsrNum );
    psrUserDataMap.put( "LEC_DEMARC_A", this.lecDemarcA );
    psrUserDataMap.put( "LEC_DEMARC_Z", this.lecDemarcZ );
    psrUserDataMap.put( "SERVICE_EXTENSION_INSTRUCTIONS", this.serviceExtensionInstructions );
    psrUserDataMap.put( "CC_RELATED_BRANCH", this.ccRelatedBranch );
    psrUserDataMap.put( "PSR_CONTACT_CENTER", this.psrContactCenter != null ? this.psrContactCenter.toString() : null );
    psrUserDataMap.put( "LOA_CFA_REQUIRED", this.loaCfaRequired != null ? this.loaCfaRequired.toString() : null );
    psrUserDataMap.put( "RELATED_HPBX_BRANCH_PSR", this.relatedHpbxBranchPsr != null ? this.relatedHpbxBranchPsr.toString() : null );
    psrUserDataMap.put( "CHANGE_SUP", this.changeSup != null ? this.changeSup.toString() : null );
    psrUserDataMap.put( "PTD_ELIGIBLE", this.ptdEligible != null ? this.ptdEligible.toString() : null );
    psrUserDataMap.put( "ASR_CCNA", this.asrCcna != null ? this.asrCcna.toString() : null );
    psrUserDataMap.put( "ASR_ICSC", this.asrIcsc != null ? this.asrIcsc.toString() : null );
    psrUserDataMap.put( "ASR_DDD", this.asrDdd != null ? this.asrDdd.toString() : null );
    psrUserDataMap.put( "ASR_QTY", this.asrQty != null ? this.asrQty.toString() : null );
    psrUserDataMap.put( "ASR_ACTL", this.asrActl );
    psrUserDataMap.put( "ASR_REMARKS", this.asrRemarks );
    psrUserDataMap.put( "ASR_VTA", this.asrVta );
    psrUserDataMap.put( "ASR_CFA", this.asrCfa );
    psrUserDataMap.put( "ASR_CFA2", this.asrCfa2 );
    psrUserDataMap.put( "ASR_CFA3", this.asrCfa3 );
    psrUserDataMap.put( "ASR_CFA4", this.asrCfa4 );
    psrUserDataMap.put( "ASR_CFA5", this.asrCfa5 );
    psrUserDataMap.put( "ASR_CFA6", this.asrCfa6 );
    psrUserDataMap.put( "ASR_CFA7", this.asrCfa7 );
    psrUserDataMap.put( "ASR_MUXLOC", this.asrMuxloc );
    psrUserDataMap.put( "ASR_CCEA", this.asrCcea );
    psrUserDataMap.put( "ASR_CCEA2", this.asrCcea2 );
    psrUserDataMap.put( "ASR_CCEA3", this.asrCcea3 );
    psrUserDataMap.put( "ASR_CCEA4", this.asrCcea4 );
    psrUserDataMap.put( "ASR_CCEA5", this.asrCcea5 );
    psrUserDataMap.put( "ASR_CCEA6", this.asrCcea6 );
    psrUserDataMap.put( "ASR_CCEA7", this.asrCcea7 );
    psrUserDataMap.put( "LEC_DEMARC_EXT", this.lecDemarcExt != null ? this.lecDemarcExt.toString() : null );
    psrUserDataMap.put( "ASR_EUNAME", this.asrEuname );
    psrUserDataMap.put( "ASR_AFT", this.asrAft != null ? this.asrAft.toString() : null );
    psrUserDataMap.put( "ASR_SAPR", this.asrSapr );
    psrUserDataMap.put( "ASR_SANO", this.asrSano );
    psrUserDataMap.put( "ASR_SASF", this.asrSasf );
    psrUserDataMap.put( "ASR_SASD2", this.asrSasd2 );
    psrUserDataMap.put( "ASR_SASN", this.asrSasn );
    psrUserDataMap.put( "ASR_SATH", this.asrSath );
    psrUserDataMap.put( "ASR_SASS2", this.asrSass2 );
    psrUserDataMap.put( "ASR_LD1", this.asrLd1 );
    psrUserDataMap.put( "ASR_LV1", this.asrLv1 );
    psrUserDataMap.put( "ASR_LD2", this.asrLd2 );
    psrUserDataMap.put( "ASR_LV2", this.asrLv2 );
    psrUserDataMap.put( "ASR_LD3", this.asrLd3 );
    psrUserDataMap.put( "ASR_LV3", this.asrLv3 );
    psrUserDataMap.put( "ASR_CITY", this.asrCity );
    psrUserDataMap.put( "ASR_STATE", this.asrState );
    psrUserDataMap.put( "ASR_ZIP", this.asrZip );
    psrUserDataMap.put( "LINXSALESREP_CHANNELMANAGER", this.linxsalesrepChannelmanager );
    psrUserDataMap.put( "LINX_CONTRACT_TERM", this.linxContractTerm );
    psrUserDataMap.put( "LINX_CIRCUIT_MRC", this.linxCircuitMrc );
    psrUserDataMap.put( "LINX_CIRCUIT_NRC", this.linxCircuitNrc );
    psrUserDataMap.put( "DMARC_NRC", this.dmarcNrc );
    psrUserDataMap.put( "EXPEDITE_FEE", this.expediteFee );
    psrUserDataMap.put( "ICB_CODES_APPROVAL", this.icbCodesApproval );
    psrUserDataMap.put( "NAPT_NUMBER", this.naptNumber );
    psrUserDataMap.put( "EQUIPMENT_ADD_ON_1", this.equipmentAddOn1 != null ? this.equipmentAddOn1.toString() : null );
    psrUserDataMap.put( "EQUIPMENT_ADD_ON_2", this.equipmentAddOn2 != null ? this.equipmentAddOn2.toString() : null );
    psrUserDataMap.put( "EQUIPMENT_ADD_ON_3", this.equipmentAddOn3 != null ? this.equipmentAddOn3.toString() : null );
    psrUserDataMap.put( "CUT_FS_NEEDED", this.cutFsNeeded != null ? this.cutFsNeeded.toString() : null );
    psrUserDataMap.put( "ASR_AAI", this.asrAai );
    psrUserDataMap.put( "IPT_SS", this.iptSs != null ? this.iptSs.toString() : null );
    psrUserDataMap.put( "REMOVE_CNR", this.removeCnr != null ? this.removeCnr.toString() : null );
    psrUserDataMap.put( "REMOVECNR", this.removeCnr1 != null ? this.removeCnr1.toString() : null );
    psrUserDataMap.put( "REMOVECNR2", this.removeCnr2 != null ? this.removeCnr2.toString() : null );
    psrUserDataMap.put( "NETWORK_EQUIPMENT", this.networkEquipment != null ? this.networkEquipment.toString() : null );
    psrUserDataMap.put( "EQUIPMENT_ADD_ON_1A", this.equipmentAddOn1A );
    psrUserDataMap.put( "EQUIPMENT_ADD_ON_2A", this.equipmentAddOn2A );
    psrUserDataMap.put( "EQUIPMENT_ADD_ON_3A", this.equipmentAddOn3A );
    psrUserDataMap.put( "LSR_NCON", this.lsrNcon != null ? this.lsrNcon.toString() : null );
    psrUserDataMap.put( "LSR_LSO", this.lsrLso );
    psrUserDataMap.put( "VENDOR_COST", this.vendorCost );
    psrUserDataMap.put( "UNLINKED_ISRS", this.unlinkedIsrs );
    psrUserDataMap.put( "SEGMENT", this.segment != null ? this.segment.toString() : null );
    psrUserDataMap.put( "INSTALL_MARKET", this.installMarket );
    psrUserDataMap.put( "SOURCE_SYSTEM", this.sourceSystem );
    psrUserDataMap.put( "HPBX_TEMP_BYOB", this.hpbxTempByob );
    psrUserDataMap.put( "HPBX_TRAINING_RESCHEDULES", this.hpbxTrainingReschedules );
    psrUserDataMap.put( "SUPP_CUSTOMER_REQUIREMENTS", this.suppCustomerRequirements );
    psrUserDataMap.put( "CNR_EXCLUDED", this.cnrExcluded );
    psrUserDataMap.put( "TF_OE", this.tfOe );
    psrUserDataMap.put( "PRICING_SOURCE", this.pricingSource );
    psrUserDataMap.put( "CONTRACT_SIGNED_DATE", this.contractSignedDate != null ? this.contractSignedDate.toString() : null );
    psrUserDataMap.put( "QUOTE_NUMBER", this.quoteNumber );
    psrUserDataMap.put( "XOMACD_ORDER", this.xomacdOrder );
    psrUserDataMap.put( "XOMACD_CREATOR", this.xomacdCreator );
    psrUserDataMap.put( "TC_TECHNICAL_COORDINATOR", this.tcTechnicalCoordinator );
    psrUserDataMap.put( "ADDITIONAL_CPE_EQUIPMENT", this.additionalCpeEquipment );
    psrUserDataMap.put( "ADDITIONAL_CPE_CONFIG", this.additionalCpeConfig );
    psrUserDataMap.put( "ADDITIONAL_CPE_CONFIG_2", this.additionalCpeConfig2 );
    psrUserDataMap.put( "ADDITIONAL_CPE_CONFIG_3", this.additionalCpeConfig3 );
    psrUserDataMap.put( "ADDITIONAL_CPE_CONFIG_4", this.additionalCpeConfig4 );
    psrUserDataMap.put( "SITE_SURVEY_EXCEPTION_REASON", this.siteSurveyExceptionReason );
    psrUserDataMap.put( "DELAY_RELATED_ORDER", this.delayRelatedOrder );
    psrUserDataMap.put( "ETHERNET_CHANGE_TYPE", this.ethernetChangeType != null ? this.ethernetChangeType.toString() : null );
    psrUserDataMap.put( "GROOM_COST_OF_SAVINGS", this.groomCostOfSavings );
    psrUserDataMap.put( "GROOM_PROJECT_NAME", this.groomProjectName );
    psrUserDataMap.put( "DMARC_MRC", this.dmarcMrc );
    psrUserDataMap.put( "LEC_BUILD_A", this.lecBuildA != null ? this.lecBuildA.toString() : null );
    psrUserDataMap.put( "LEC_BUILD_Z", this.lecBuildZ != null ? this.lecBuildZ.toString() : null );
    psrUserDataMap.put( "MARKET_SEGMENT", this.marketSegment != null ? this.marketSegment.toString() : null );
    psrUserDataMap.put( "ONNET_BUILD_TYPE", this.onNetBuildType != null ? this.onNetBuildType.toString() : null );
    psrUserDataMap.put( "NETPROV_CANCELLED", this.netProvCancelled != null ? this.netProvCancelled.toString() : null );
    return psrUserDataMap;
  }

}
