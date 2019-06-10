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
@Table(name = "TASK_TYPE", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class TaskType implements Serializable {

    @Id
    @Column(name = "TASK_TYPE")
    @EqualsAndHashCode.Include
    private String taskType;

    @Column(name = "ORDERED_FACILITY_INDICATOR")
    private String orderedFacilityIndicator;

    @Column(name = "TASK_TYPE_DESCRIPTION")
    private String taskTypeDescription;

    @Column(name = "TASK_CRITICAL_DATE_INDICATOR")
    private String taskCriticalDateIndicator;

    @Column(name = "LAST_MODIFIED_USERID")
    private String lastModifiedUserid;

    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDate lastModifiedDate;

    @Column(name = "TRANSACTION_ORIGIN")
    private String transactionOrigin;

    @Column(name = "CUSTOMER_VIEWABLE")
    private String customerViewable;

    @Column(name = "RELATED_AREA")
    private String relatedArea;

    @Column(name = "APPOINTMENT_TASK")
    private String appointmentTask;

    @Column(name = "GRACE_DAYS")
    private Long graceDays;

    @Column(name = "EXE_FILE_NM")
    private String exeFileNm;

    @Column(name = "GRACE_MINUTES")
    private Long graceMinutes;

    @Column(name = "GRACE_HOURS")
    private Long graceHours;

    @Column(name = "POTENTIALLY_LATE_DAYS")
    private Long potentiallyLateDays;

    @Column(name = "POTENTIALLY_LATE_HOURS")
    private Long potentiallyLateHours;

    @Column(name = "POTENTIALLY_LATE_MINUTES")
    private Long potentiallyLateMinutes;

    @Column(name = "SYSTEM_TASK_IND")
    private String systemTaskInd;

    @Column(name = "SMART_TASK_IND")
    private String smartTaskInd;

    @Column(name = "EXECUTION_POINT")
    private String executionPoint;

    @Column(name = "VALIDATION_REQ_TRI")
    private String validationReqTri;

    @Column(name = "WINDOW_NM")
    private String windowNm;

    @Column(name = "COMBIN_SMARTSYS_IND")
    private String combinSmartsysInd;

    @Column(name = "TOOL_NM")
    private String toolNm;

    @Column(name = "MS_BB_ID")
    private Long msBbId;

}
