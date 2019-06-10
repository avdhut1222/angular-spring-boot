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
@Table(name = "SERV_REQ_SI", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "getValuesBySrsi",
                procedureName = "ASAP.PKG_XO_VALUE_LABELS.GET_VALUES_BY_SRSI",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "aDocNum"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "aServItem"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oReturnVal"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oReturnCd"),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oResultSet"),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "getCaBySrsi",
                procedureName = "ASAP.PKG_XO_CA.GET_CA_BY_SRSI",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "aDocNum"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "aServItem"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oReturnVal"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oReturnCd"),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oResultSet"),
                }
        )
})
public class ServReqSi implements Serializable {

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonSerialize
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ServReqSiPK implements Serializable {

        @Column(name = "DOCUMENT_NUMBER")
        private Long documentNumber;

        @Column(name = "SERV_ITEM_ID")
        private Long servItemId;
    }

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ServReqSiPK servReqSiPK;

    @Column(name = "ITEM_ALIAS")
    private String itemAlias;

    @Column(name = "SPEC_GRP_ID")
    private Long specGrpId;

    @Column(name = "ACTIVITY_CD")
    private String activityCd;

    @Column(name = "QTY")
    private Long qty;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "TRUNK_SEG")
    private String trunkSeg;

    @Column(name = "ADDITIONAL_INFO")
    private String additionalInfo;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @Column(name = "LAST_MODIFIED_USERID")
    private String lastModifiedUserid;

    @Column(name = "REPORTED_ISSUE_NBR")
    private Long reportedIssueNbr;

    @Column(name = "ITEM_ALIAS_SUF")
    private Long itemAliasSuf;

    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;

    @Column(name = "SRSI_GROUP_ID")
    private Long srsiGroupId;

    @Column(name = "PRIOR_STATUS")
    private String priorStatus;

    @Column(name = "ACTIVITY_EU_CD")
    private String activityEuCd;

}
