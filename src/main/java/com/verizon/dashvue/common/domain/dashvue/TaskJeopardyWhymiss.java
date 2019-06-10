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
import java.time.LocalDate;


@Entity
@Table(name = "TASK_JEOPARDY_WHYMISS", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class TaskJeopardyWhymiss implements Serializable {

    @Id
    @Column(name = "JEOPARDY_ID")
    @EqualsAndHashCode.Include
    private Long jeopardyId;

    @Column(name = "DOCUMENT_NUMBER")
    private Long documentNumber;

    @Column(name = "TASK_NUMBER")
    private Long taskNumber;

    @Column(name = "JEOPARDY_REASON_CODE")
    private String jeopardyReasonCode;

    @Column(name = "JEOPARDY_TYPE_CD")
    private String jeopardyTypeCd;

    @Column(name = "JEOP_FOLLOWUP_DT")
    private LocalDate jeopFollowupDt;

    @Column(name = "CLOSED_BY")
    private String closedBy;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "DATE_CLOSED")
    private LocalDate dateClosed;

    @Column(name = "LAST_MODIFIED_USERID")
    private String lastModifiedUserid;

    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDate lastModifiedDate;

    @Column(name = "CIRCUIT_DESIGN_ID")
    private Long circuitDesignId;

    @Column(name = "ORGANIZATION_ID")
    private String organizationId;

    @Column(name = "XREF_TASK_ID")
    private Long xrefTaskId;

    @Column(name = "WORK_ORDER_NUM_1")
    private String workOrderNum1;

    @Column(name = "WORK_ORDER_NUM_2")
    private String workOrderNum2;

    @Column(name = "IN_SERVICE_DATE_1")
    private LocalDate inServiceDate1;

    @Column(name = "IN_SERVICE_DATE_2")
    private LocalDate inServiceDate2;

    @Column(name = "ORDER_JEOP_DOC_NUM")
    private Long orderJeopDocNum;


}
