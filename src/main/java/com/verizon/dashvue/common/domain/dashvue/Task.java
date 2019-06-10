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
@Table(name = "TASK", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task implements Serializable {

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonSerialize
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TaskPK implements Serializable {

        @Column(name = "DOCUMENT_NUMBER")
        private Long documentNumber;

        @Column(name = "TASK_NUMBER")
        private Long taskNumber;
    }

    @EmbeddedId
    @EqualsAndHashCode.Include
    private TaskPK taskPK;

    @Column(name = "TASK_STATUS")
    private String taskStatus;

    @Column(name = "TASK_PRIORITY")
    private Long taskPriority;

    @Column(name = "SCHEDULED_COMPLETION_DATE")
    private LocalDate scheduledCompletionDate;

    @Column(name = "ACTUAL_COMPLETION_DATE")
    private LocalDate actualCompletionDate;

    @Column(name = "ESTIMATED_COMPLETION_DATE")
    private LocalDate estimatedCompletionDate;

    @Column(name = "LAST_MODIFIED_USERID")
    private String lastModifiedUserid;

    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDate lastModifiedDate;

    @Column(name = "TASK_TYPE")
    private String taskType;

    @Column(name = "CIRCUIT_DESIGN_ID")
    private Long circuitDesignId;

    @Column(name = "WORK_QUEUE_ID")
    private String workQueueId;

    @Column(name = "WORK_QUEUE_PRIORITY")
    private Long workQueuePriority;

    @Column(name = "ASSIGNED_FROM_WORK_QUEUE")
    private String assignedFromWorkQueue;

    @Column(name = "ASSIGNED_FROM_DATE")
    private LocalDate assignedFromDate;

    @Column(name = "TASK_STATUS_DATE")
    private LocalDate taskStatusDate;

    @Column(name = "QUEUE_STATUS")
    private String queueStatus;

    @Column(name = "REVISED_COMPLETION_DATE")
    private LocalDate revisedCompletionDate;

    @Column(name = "ACTUAL_RELEASE_DATE")
    private LocalDate actualReleaseDate;

    @Column(name = "BILLING_STATUS")
    private String billingStatus;

    @Column(name = "SCHEDULED_RELEASE_DATE")
    private LocalDate scheduledReleaseDate;

    @Column(name = "SORT_PRIORITY")
    private String sortPriority;

    @Column(name = "REQUIRED_IND")
    private String requiredInd;

    @Column(name = "SYSTEM_GEN_IND")
    private String systemGenInd;

    @Column(name = "REQ_PLAN_ID")
    private Long reqPlanId;

    @Column(name = "TASK_OPEN_IND")
    private String taskOpenInd;

    @Column(name = "JOB_ID")
    private Long jobId;

    @Column(name = "AUTO_COMP_IND")
    private String autoCompInd;

    @Column(name = "FIRST_JEOPARDY_ID")
    private Long firstJeopardyId;

    @Column(name = "SEQUENCE")
    private Long sequence;

    @Column(name = "REJECT_STATUS")
    private String rejectStatus;

    @Column(name = "TASK_PROMPT")
    private String taskPrompt;

    @Column(name = "ASSIGN_DT_CD")
    private String assignDtCd;

    @Column(name = "SERV_ITEM_ID")
    private Long servItemId;

    @Column(name = "COMPLETION_DAYS")
    private Long completionDays;

    @Column(name = "COMPLETION_HOURS")
    private Long completionHours;

    @Column(name = "COMPLETION_MINUTES")
    private Long completionMinutes;

    @Column(name = "POTENTIALLY_LATE_DAYS")
    private Long potentiallyLateDays;

    @Column(name = "POTENTIALLY_LATE_HOURS")
    private Long potentiallyLateHours;

    @Column(name = "POTENTIALLY_LATE_MINUTES")
    private Long potentiallyLateMinutes;

    @Column(name = "CLOSE_OF_BUSINESS_IND")
    private String closeOfBusinessInd;

    @Column(name = "LATE_PROMPT_IND")
    private String latePromptInd;

    @Column(name = "SYSTEM_TASK_IND")
    private String systemTaskInd;

    @Column(name = "TASK_LABEL")
    private String taskLabel;

    @Column(name = "EXECUTION_POINT")
    private String executionPoint;

    @Column(name = "DISPOSITION_DAYS")
    private Long dispositionDays;

    @Column(name = "DISPOSITION_LOCK_IND")
    private String dispositionLockInd;

    @Column(name = "PREV_WORK_QUEUE_ID")
    private String prevWorkQueueId;

    @Column(name = "TASK_OPENED_IND")
    private String taskOpenedInd;

    @Column(name = "LATE_EXTENSION_IND")
    private String lateExtensionInd;

    @Column(name = "POTENTIAL_LATE_EXTENSION_IND")
    private String potentialLateExtensionInd;

    @Column(name = "TASK_LABEL_2")
    private String taskLabel2;

    @Column(name = "TASK_LABEL_3")
    private String taskLabel3;

    @Column(name = "TASK_LABEL_4")
    private String taskLabel4;

    @Column(name = "TASK_LABEL_5")
    private String taskLabel5;

    @Column(name = "TASK_LABEL_6")
    private String taskLabel6;

    @Column(name = "TASK_LABEL_7")
    private String taskLabel7;

    @Column(name = "TASK_LABEL_8")
    private String taskLabel8;

    @Column(name = "TASK_LABEL_9")
    private String taskLabel9;

    @Column(name = "TASK_LABEL_10")
    private String taskLabel10;

    @Column(name = "TASK_LABEL_11")
    private String taskLabel11;

    @Column(name = "TASK_LABEL_12")
    private String taskLabel12;

    @Column(name = "TASK_LABEL_13")
    private String taskLabel13;

    @Column(name = "TASK_LABEL_14")
    private String taskLabel14;

    @Column(name = "TASK_LABEL_15")
    private String taskLabel15;

    @Column(name = "TASK_LABEL_16")
    private LocalDate taskLabel16;

    @Column(name = "TASK_LABEL_17")
    private LocalDate taskLabel17;

    @Column(name = "TASK_LABEL_18")
    private LocalDate taskLabel18;

    @Column(name = "TASK_LABEL_19")
    private LocalDate taskLabel19;

    @Column(name = "TASK_LABEL_20")
    private LocalDate taskLabel20;

    @Column(name = "EXPEDITED_COMPLETION_DAYS")
    private Long expeditedCompletionDays;

    @Column(name = "EXPEDITED_COMPLETION_HOURS")
    private Long expeditedCompletionHours;

    @Column(name = "EXPEDITED_COMPLETION_MINUTES")
    private Long expeditedCompletionMinutes;

}
