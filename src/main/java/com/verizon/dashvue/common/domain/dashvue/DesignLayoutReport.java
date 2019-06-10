package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "DESIGN_LAYOUT_REPORT", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class DesignLayoutReport implements Serializable {

    public DesignLayoutReport(Long circuitDesignId, Long issueNbr, Long documentNumber, String interexchangeCarrierName, LocalDate issueDate, String orderNbr, String ecckt, String issueStatus) {

        this.designLayoutReportPK = new DesignLayoutReportPK(circuitDesignId, issueNbr);
        this.documentNumber = documentNumber;
        this.interexchangeCarrierName = interexchangeCarrierName;
        this.issueDate = issueDate;
        this.orderNbr = orderNbr;
        this.ecckt = ecckt;
        this.issueStatus = issueStatus;
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonSerialize
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DesignLayoutReportPK implements Serializable {

        @Column(name = "CIRCUIT_DESIGN_ID")
        private Long circuitDesignId;

        @Column(name = "ISSUE_NBR")
        private Long issueNbr;
    }

    @EmbeddedId
    @EqualsAndHashCode.Include
    private DesignLayoutReportPK designLayoutReportPK;

    @Column(name = "DOCUMENT_NUMBER")
    private Long documentNumber;

    @Column(name = "INTEREXCHANGE_CARRIER_NAME")
    private String interexchangeCarrierName;

    @Column(name = "ISSUE_DATE")
    private LocalDate issueDate;

    @Column(name = "ORDER_NBR")
    private String orderNbr;

    @Column(name = "ECCKT")
    private String ecckt;

    @Column(name = "ISSUE_STATUS")
    private String issueStatus;

    @Column(name = "PURCHASE_ORDER_NUMBER")
    private String purchaseOrderNumber;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "EC_INITIATED_ACTIVITY_IND")
    private String ecInitiatedActivityInd;

    @Column(name = "IC_CIRCUIT_REFERENCE")
    private String icCircuitReference;

    @Column(name = "EC_COMPANY_CODE")
    private String ecCompanyCode;

//    @Column(name = "ALLTEL_BILLING_NUMBER")
//    private String alltelBillingNumber;
//
//    @Column(name = "SERVICE_TYPE_ACRONYM")
//    private String serviceTypeAcronym;

    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;

    @Column(name = "TWO_SIX_CODE")
    private String twoSixCode;

    @Column(name = "TRUNK_GROUP_ID")
    private String trunkGroupId;

    @Column(name = "CIRCUIT_LAYOUT_ORDER_NBR")
    private String circuitLayoutOrderNbr;

    @Column(name = "TELECOM_SERVICE_PRIORITY")
    private String telecomServicePriority;

    @Column(name = "DESIGN_ENGINEERING_CONTACT")
    private String designEngineeringContact;

    @Column(name = "DESIGN_CONTACT_TELEPHONE_NBR")
    private String designContactTelephoneNbr;

    @Column(name = "EC_DESIGNER_CONTACT")
    private String ecDesignerContact;

    @Column(name = "EC_TELEPHONE_NBR")
    private String ecTelephoneNbr;

    @Column(name = "EC_MAINTENANCE_CONTROL_OFFICE")
    private String ecMaintenanceControlOffice;

    @Column(name = "EC_OPERATIONS_CONTROL_OFFICE")
    private String ecOperationsControlOffice;

//    @Column(name = "DESIGN_LAYOUT_REPORT_DATE")
//    private LocalDate designLayoutReportDate;
//
//    @Column(name = "CONFIRMING_DESIGN_LAYOUT_DATE")
//    private LocalDate confirmingDesignLayoutDate;
//
//    @Column(name = "PLANT_TEST_DATE")
//    private LocalDate plantTestDate;
//
//    @Column(name = "DUE_DATE")
//    private LocalDate dueDate;

    @Column(name = "REMARKS_LINE_1")
    private String remarksLine1;

    @Column(name = "REMARKS_LINE_2")
    private String remarksLine2;

    @Column(name = "REMARKS_LINE_3")
    private String remarksLine3;

    @Column(name = "ACCESS_CUST_TERMINAL_LOCATION")
    private String accessCustTerminalLocation;

    @Column(name = "LINK_TYPE")
    private String linkType;

    @Column(name = "ADDITIONAL_POINT_OF_TERMINATIO")
    private String additionalPointOfTerminatio;

    @Column(name = "SIGNALLING_LINK_CODE")
    private String signallingLinkCode;

    @Column(name = "TRUNK_CKT_ID_CODE")
    private String trunkCktIdCode;

    @Column(name = "CIRCUIT_BRIDGING_LOCATION")
    private String circuitBridgingLocation;

    @Column(name = "CUSTOMER_SIGNALLING_POINT_CODE")
    private String customerSignallingPointCode;

    @Column(name = "PRIMARY_LOCATION")
    private String primaryLocation;

//    @Column(name = "IMPLEMENTATION_CONTACT")
//    private String implementationContact;
//
//    @Column(name = "IMPLEMENTATION_TELEPHONE_NBR")
//    private String implementationTelephoneNbr;

    @Column(name = "SECONDARY_POINT_OF_TERM_PRILOC")
    private String secondaryPointOfTermPriloc;

    @Column(name = "EC_SIGNALING_POINT_CODE")
    private String ecSignalingPointCode;

    @Column(name = "SECONDARY_LOCATION")
    private String secondaryLocation;

    @Column(name = "SECONDARY_POINT_OF_TERM_SECLOC")
    private String secondaryPointOfTermSecloc;

    @Column(name = "NETWORK_CHANNEL_CODE")
    private String networkChannelCode;

    @Column(name = "NETWORK_CHANNEL_OPTION_CODE")
    private String networkChannelOptionCode;

    @Column(name = "NETWORK_CHANNEL_INTERFACE_CODE")
    private String networkChannelInterfaceCode;

    @Column(name = "TRANSMISSION_LEVEL_POINT")
    private String transmissionLevelPoint;

    @Column(name = "MACHINE_INTERFACE_CODE")
    private String machineInterfaceCode;

    @Column(name = "CONNECTING_FACILITY_ASSIGNMENT")
    private String connectingFacilityAssignment;

    @Column(name = "SEC_NETWORK_CHANNEL_INTERFACE")
    private String secNetworkChannelInterface;

    @Column(name = "SECONDARY_TRANSMIT_LEVEL_POINT")
    private String secondaryTransmitLevelPoint;

    @Column(name = "PRILOC_END_USER_STREET_ADDRESS")
    private String prilocEndUserStreetAddress;

    @Column(name = "PRILOC_BUILDING")
    private String prilocBuilding;

    @Column(name = "PRILOC_FLOOR")
    private String prilocFloor;

    @Column(name = "PRILOC_ROOM")
    private String prilocRoom;

    @Column(name = "PRILOC_CITY")
    private String prilocCity;

    @Column(name = "PRILOC_STATE")
    private String prilocState;

    @Column(name = "PRILOC_ACCESS_TEL_NUMBER")
    private String prilocAccessTelNumber;

    @Column(name = "PRILOC_END_USER_TERMINATION")
    private String prilocEndUserTermination;

//    @Column(name = "PRILOC_EU_SIGNAL_VOICE_PATH_TY")
//    private String prilocEuSignalVoicePathTy;

    @Column(name = "PRILOC_END_USER_RECEIVE_LEVEL")
    private Long prilocEndUserReceiveLevel;

    @Column(name = "PRILOC_END_USER_TRANSMIT_LEVEL")
    private Long prilocEndUserTransmitLevel;

    @Column(name = "PRILOC_END_USER_TERMINATION_4W")
    private String prilocEndUserTermination4W;

    @Column(name = "PRILOC_END_USER_TRANSMIT_4W")
    private Long prilocEndUserTransmit4W;

//    @Column(name = "PRILOC_LOCAL_CONTACT")
//    private String prilocLocalContact;
//
//    @Column(name = "PRILOC_ENDUSER_CONTACT")
//    private String prilocEnduserContact;
//
//    @Column(name = "PRILOC_ENDUSER_TELEPHONE_NBR")
//    private String prilocEnduserTelephoneNbr;

    @Column(name = "SECLOC_END_USER_STREET_ADDRESS")
    private String seclocEndUserStreetAddress;

    @Column(name = "SECLOC_BUILDING")
    private String seclocBuilding;

    @Column(name = "SECLOC_FLOOR")
    private String seclocFloor;

    @Column(name = "SECLOC_ROOM")
    private String seclocRoom;

    @Column(name = "SECLOC_CITY")
    private String seclocCity;

    @Column(name = "SECLOC_STATE")
    private String seclocState;

    @Column(name = "SECLOC_ACCESS_TEL_NUMBER")
    private String seclocAccessTelNumber;

    @Column(name = "SECLOC_END_USER_TERMINATION")
    private String seclocEndUserTermination;

//    @Column(name = "SECLOC_EU_SIGNAL_VOICE_PATH_TY")
//    private String seclocEuSignalVoicePathTy;

    @Column(name = "SECLOC_END_USER_TRANSMIT_LEVEL")
    private Long seclocEndUserTransmitLevel;

    @Column(name = "SECLOC_END_USER_RECEIVE_LEVEL")
    private Long seclocEndUserReceiveLevel;

    @Column(name = "SECLOC_END_USER_TERMINATION_4W")
    private String seclocEndUserTermination4W;

    @Column(name = "SECLOC_END_USER_RECEIVE_4W")
    private Long seclocEndUserReceive4W;

//    @Column(name = "SECLOC_LOCAL_CONTACT")
//    private String seclocLocalContact;
//
//    @Column(name = "SECLOC_ENDUSER_CONTACT")
//    private String seclocEnduserContact;
//
//    @Column(name = "SECLOC_ENDUSER_TELEPHONE_NBR")
//    private String seclocEnduserTelephoneNbr;
//
//    @Column(name = "LAST_MODIFIED_USERID")
//    private String lastModifiedUserid;
//
//    @Column(name = "LAST_MODIFIED_DATE")
//    private LocalDate lastModifiedDate;

//    @Column(name = "MUX_LOCATION")
//    private String muxLocation;
//
//    @Column(name = "SECONDARY_CONNECT_FAC")
//    private String secondaryConnectFac;
//
//    @Column(name = "ACTIVITY_INDICATOR")
//    private String activityIndicator;
//
//    @Column(name = "SECLOC_GEN_EXCH_TARIFF_OPT_EUL")
//    private String seclocGenExchTariffOptEul;
//
//    @Column(name = "PRILOC_GEN_EXCH_TARIFF_OPT_EUL")
//    private String prilocGenExchTariffOptEul;
//
//    @Column(name = "WIRED_AND_OFFICE_TESTED_DATE")
//    private LocalDate wiredAndOfficeTestedDate;
//
//    @Column(name = "RELATED_PON")
//    private String relatedPon;
//
//    @Column(name = "PROJECT_IDENTIFICATION")
//    private String projectIdentification;
//
//    @Column(name = "ACNA")
//    private String acna;
//
//    @Column(name = "ACCESS_CUSTOMER_NAME")
//    private String accessCustomerName;
//
//    @Column(name = "CCNA")
//    private String ccna;
//
//    @Column(name = "A_CLLI_TRUNK_GROUP_NBR")
//    private String aClliTrunkGroupNbr;
//
//    @Column(name = "Z_CLLI_TRUNK_GROUP_NBR")
//    private String zClliTrunkGroupNbr;
//
//    @Column(name = "A_CLLI_MEMBER")
//    private String aClliMember;
//
//    @Column(name = "Z_CLLI_MEMBER")
//    private String zClliMember;
//
//    @Column(name = "POINT_CD_A_OWNER")
//    private String pointCdAOwner;
//
//    @Column(name = "POINT_CD_Z_OWNER")
//    private String pointCdZOwner;
//
//    @Column(name = "POINT_CODE_A")
//    private String pointCodeA;
//
//    @Column(name = "POINT_CODE_Z")
//    private String pointCodeZ;
//
//    @Column(name = "PRILOC_PULSING_TYPE")
//    private String prilocPulsingType;
//
//    @Column(name = "PRILOC_SIGNALING_TYPE")
//    private String prilocSignalingType;
//
//    @Column(name = "PRILOC_START_SIGNALING_TYPE")
//    private String prilocStartSignalingType;
//
//    @Column(name = "PRILOC_NBR_TRANSMISSION_WIRES")
//    private String prilocNbrTransmissionWires;
//
//    @Column(name = "SECLOC_PULSING_TYPE")
//    private String seclocPulsingType;
//
//    @Column(name = "SECLOC_SIGNALING_TYPE")
//    private String seclocSignalingType;
//
//    @Column(name = "SECLOC_START_SIGNALING_TYPE")
//    private String seclocStartSignalingType;
//
//    @Column(name = "SECLOC_NBR_TRANSMISSION_WIRES")
//    private String seclocNbrTransmissionWires;
//
//    @Column(name = "CLR_PRI_NL_LOCNAME")
//    private String clrPriNlLocname;
//
//    @Column(name = "CLR_PRI_NL_ADDRESS")
//    private String clrPriNlAddress;
//
//    @Column(name = "CLR_PRI_NL_CITY")
//    private String clrPriNlCity;
//
//    @Column(name = "CLR_PRI_NL_STATE")
//    private String clrPriNlState;
//
//    @Column(name = "CLR_PRI_NL_ZIPCODE")
//    private String clrPriNlZipcode;
//
//    @Column(name = "CLR_SEC_NL_LOCNAME")
//    private String clrSecNlLocname;
//
//    @Column(name = "CLR_SEC_NL_ADDRESS")
//    private String clrSecNlAddress;
//
//    @Column(name = "CLR_SEC_NL_CITY")
//    private String clrSecNlCity;
//
//    @Column(name = "CLR_SEC_NL_STATE")
//    private String clrSecNlState;
//
//    @Column(name = "CLR_SEC_NL_ZIPCODE")
//    private String clrSecNlZipcode;
//
//    @Column(name = "CLR_PRI_EU_ALOC")
//    private String clrPriEuAloc;
//
//    @Column(name = "CLR_SEC_EU_ALOC")
//    private String clrSecEuAloc;
//
//    @Column(name = "CLR_ASSOCIATED_LEC_ORDER_ID")
//    private String clrAssociatedLecOrderId;
//
//    @Column(name = "MAINT_CONTACT_NM")
//    private String maintContactNm;
//
//    @Column(name = "MAINT_CONTACT_NBR")
//    private String maintContactNbr;
//
//    @Column(name = "OLD_ECCKT")
//    private String oldEcckt;


    public String getIssueStatusText() {
        int issueStatus = Integer.parseInt(this.getIssueStatus());
        if (issueStatus > 0 && issueStatus < 6) {
            switch (issueStatus) {
                case 1:
                    return "Pending";
                case 2:
                    return "Current";
                case 3:
                    return "Previous";
                case 4:
                    return "Overridden";
                case 5:
                    return "Cancelled";
            }
        }
        return null;
    }

}
