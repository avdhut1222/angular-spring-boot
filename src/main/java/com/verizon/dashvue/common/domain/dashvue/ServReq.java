package com.verizon.dashvue.common.domain.dashvue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.verizon.dashvue.common.procresult.TopTnFeatQueryResult;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "SERV_REQ", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "topPicQuery",
        procedureName = "ASAP.PKG_XO_DASHVUE.TOP_PIC_QUERY",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "iDocNbr"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oRetVal"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oRetTxt"),
            @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oRetCsr"),
        }
    ),
    @NamedStoredProcedureQuery(
        name = "getLineCodingFramingBySR",
        procedureName = "ASAP.PKG_XO_PSR_INFO.GET_LINE_CODING_FRAMING_BY_SR",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "aDocNbr"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oReturnVal"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oReturnTxt"),
            @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oResultSet"),
        }
//    , resultSetMappings = "getLineCodingFramingBySRMapping"
    ),
    @NamedStoredProcedureQuery(
        name = "topQuery",
        procedureName = "ASAP.PKG_XO_DASHVUE.TOP_QUERY",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "iCriteria"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "iCritValue"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oRetVal"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oRetTxt"),
            @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oRetCsr"),
        }
    ),
    @NamedStoredProcedureQuery(
        name = "topChildSrQuery",
        procedureName = "ASAP.PKG_XO_DASHVUE.TOP_CHILD_SR_QUERY",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "iDocNbr"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "iChildType"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oRetVal"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oRetTxt"),
            @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oRetCsr"),
        }
    ),
    @NamedStoredProcedureQuery(
        name = "topPartyAddressQuery",
        procedureName = "ASAP.PKG_XO_DASHVUE.TOP_PARTY_ADDRESS_QUERY",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "iDocNbr"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "iLimit"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oRetVal"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oRetTxt"),
            @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oRetCsr"),
        }
    ),
    @NamedStoredProcedureQuery(
        name = "topTrunkGroupQuery",
        procedureName = "ASAP.PKG_XO_DASHVUE.TOP_TRUNK_GROUP_QUERY",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "iDocNbr"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oRetVal"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oRetTxt"),
            @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oRetCsr"),
        }
    ),
    @NamedStoredProcedureQuery(
        name = "topTnFeatQuery",
        procedureName = "ASAP.PKG_XO_DASHVUE.TOP_TN_FEAT_QUERY",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "iDocNbr"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oRetVal"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oRetTxt"),
            @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oRetCsr"),
        }
    ),
    @NamedStoredProcedureQuery(
        name = "topHuntGrpQuery",
        procedureName = "ASAP.PKG_XO_DASHVUE.TOP_HUNT_GRP_QUERY",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "iDocNbr"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oRetVal"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oRetTxt"),
            @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oRetCsr"),
        }
    ),
    @NamedStoredProcedureQuery(
        name = "topHuntGrpDetailQuery",
        procedureName = "ASAP.PKG_XO_DASHVUE.TOP_HUNT_GRP_DETAIL_QUERY",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "iDocNbr"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "iHuntId"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oRetVal"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oRetTxt"),
            @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oRetCsr"),
        }
    ),
    @NamedStoredProcedureQuery(
        name = "getSrHierarchy",
        procedureName = "ASAP.PKG_XO_DASHVUE.GET_SR_HIERARCHY",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "iDocNbr"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oRetVal"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oRetTxt"),
            @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oRetCsr"),
        }
    )
})
//@SqlResultSetMappings({
//        @SqlResultSetMapping(
//                name = "topTnFeatQueryMapping",
//                classes = {
//                        @ConstructorResult(
//                                targetClass = TopTnFeatQueryResult.class,
//                                columns = {
//                                        @ColumnResult(name = "FEATURES", type = String.class),
//                                        @ColumnResult(name = "ACTIVITY", type = String.class),
//                                        @ColumnResult(name = "TEL_NUM", type = String.class),
//                                        @ColumnResult(name = "V_LABEL", type = String.class),
//                                        @ColumnResult(name = "V_VALUE", type = String.class),
//                                        @ColumnResult(name = "V_ACT", type = String.class)
//                                }
//                        )
//                }
//        )
//
//})
@NoArgsConstructor
public class ServReq implements Serializable {

    public ServReq( Long documentNumber, String typeOfSr, CustAcct custAcctInfo, String pon, String supplementType,
                   String responsibleParty, String projectIdentification, Long serviceRequestStatus,
                   LocalDateTime desiredDueDate, String expediteTri, String activityInd, String relatedPon,
                   Organization organization, String orderNumber ) {
        this.documentNumber = documentNumber;
        this.typeOfSr = typeOfSr;
        this.orderNumber = orderNumber;
        this.custAcctInfo = custAcctInfo;
        this.pon = pon;
        this.projectIdentification = projectIdentification;
        this.desiredDueDate = desiredDueDate;
        this.activityInd = activityInd;
        this.supplementType = supplementType;
        this.relatedPon = relatedPon;
        this.responsibleParty = responsibleParty;
        this.serviceRequestStatus = serviceRequestStatus;
        this.organization = organization;
        this.expediteTri = expediteTri;
    }

    @Id
    @Column(name = "DOCUMENT_NUMBER")
    @EqualsAndHashCode.Include
    private Long documentNumber;

    @Column(name = "ORDER_COMPL_DT")
    private LocalDateTime orderComplDt;

    @Column(name = "TYPE_OF_SR")
    private String typeOfSr;

    @Column(name = "LAST_MODIFIED_USERID")
    private String lastModifiedUserid;

    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDateTime lastModifiedDate;

    @Column(name = "REQ_HEADER_ID")
    private Long reqHeaderId;

    @Column(name = "SERVICE_REQ_SEQ")
    private Long serviceReqSeq;

    @Column(name = "FIRST_ECCKT_ID")
    private String firstEccktId;

    @Column(name = "ORDER_NUMBER")
    private String orderNumber;

    @ManyToOne(targetEntity = CustAcct.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CUST_ACCT_ID")
    private CustAcct custAcctInfo;

    @Column(name = "INTERIM_BILL_IND")
    private String interimBillInd;

    @Column(name = "BILL_ACT_DT")
    private LocalDateTime billActDt;

    @Column(name = "CCNA")
    private String ccna;

    @Column(name = "PON")
    private String pon;

    @Column(name = "PROJECT_IDENTIFICATION")
    private String projectIdentification;

    @Column(name = "VERSION_IDENTIFICATION")
    private String versionIdentification;

    @Column(name = "DESIRED_DUE_DATE")
    private LocalDateTime desiredDueDate;

    @Column(name = "REQUEST_TYPE")
    private String requestType;

    @Column(name = "REQUEST_TYPE_STATUS")
    private String requestTypeStatus;

    @Column(name = "ACTIVITY_IND")
    private String activityInd;

    @Column(name = "SUPPLEMENT_TYPE")
    private String supplementType;

    @Column(name = "RELATED_PON")
    private String relatedPon;

    @Column(name = "ACNA")
    private String acna;

    @Column(name = "ORDER_ENTERED_CONTACT_NAME")
    private String orderEnteredContactName;

    @Column(name = "PROV_ORDER_ID")
    private Long provOrderId;

    @Column(name = "SERVICE_REQUEST_SEQ")
    private Long serviceRequestSeq;

    @Column(name = "SENT_RECV_CD")
    private String sentRecvCd;

    @Column(name = "RESPONSIBLE_PARTY")
    private String responsibleParty;

    @Column(name = "SERVICE_REQUEST_STATUS")
    private Long serviceRequestStatus;

    @Column(name = "CASE_NUMBER")
    private String caseNumber;

    @Column(name = "NEG_RATE_IND")
    private String negRateInd;

    @ManyToOne(targetEntity = Organization.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    private Organization organization;

    @Column(name = "CCNA_NAME")
    private String ccnaName;

    @Column(name = "ACNA_NAME")
    private String acnaName;

    @Column(name = "SOURCE_CODE")
    private Long sourceCode;

    @Column(name = "WEB_CONFIRMATION_ID")
    private Long webConfirmationId;

    @Column(name = "GMT_DT_TM_RECEIVED")
    private LocalDateTime gmtDateTimeReceived;

    @Column(name = "SERV_REQ_SENT_TRI")
    private String servReqSentTri;

    @Column(name = "EXPERT_MODE_SF_TYPE_NM")
    private String expertModeSfTypeNm;

    @Column(name = "EXPERT_MODEL_SF_STUC_FORMAT_NM")
    private String expertModelSfStucFormatNm;

    @Column(name = "TEMPLATE_IND")
    private String templateInd;

    @Column(name = "TEMPLATE_SHORT_DESC")
    private String templateShortDesc;

    @Column(name = "EXTERNAL_ORDER_NBR")
    private String externalOrderNbr;

    @Column(name = "EXPEDITE_TRI")
    private String expediteTri;

    @Column(name = "SUPP_CANCEL_REASON_CD")
    private String suppCancelReasonCd;

    @Column(name = "OLD_CCNA")
    private String oldCcna;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "PROJECT_DESCRIPTION")
    private String projectDescription;

    @Column(name = "DATE_CREATED")
    private LocalDateTime dateCreated;

    @Column(name = "PROJECT_STATUS")
    private String projectStatus;

    @Column(name = "IS_AUTO_EWO")
    private String isAutoEwo;

    @Column(name = "NPA")
    private String npa;

    @Column(name = "NXX")
    private String nxx;

    @Column(name = "SR_AUDIT_IND")
    private String srAuditInd;

    @OneToMany(targetEntity = ServReqProvplan.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_NUMBER", referencedColumnName = "DOCUMENT_NUMBER")
    @OrderBy("lastModifiedDate DESC")
    @BatchSize(size = 1)
    private List<ServReqProvplan> provPlans;

    @OneToMany(targetEntity = SiGroupSrsi.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_NUMBER", referencedColumnName = "DOCUMENT_NUMBER")
    private List<SiGroupSrsi> siGroupSrsiList;

    @OneToOne(targetEntity = ServOrd.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_NUMBER", referencedColumnName = "DOCUMENT_NUMBER")
    private ServOrd serviceOrder;

    @OneToMany(targetEntity = ServReqContact.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_NUMBER", referencedColumnName = "DOCUMENT_NUMBER")
    @OrderBy("servReqContactPK.srContactSeq")
    private List<ServReqContact> servReqContacts;

    @OneToMany(targetEntity = ServReqSi.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_NUMBER", referencedColumnName = "DOCUMENT_NUMBER")
    private List<ServReqSi> servReqSiList;

//    @OneToMany(targetEntity = ServReqSi.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "DOCUMENT_NUMBER", referencedColumnName = "DOCUMENT_NUMBER")
//    @MapKey(name = "servReqSiPK.servItemId")
//    private Map<Long, ServReqSi> servReqSiMap;

}
