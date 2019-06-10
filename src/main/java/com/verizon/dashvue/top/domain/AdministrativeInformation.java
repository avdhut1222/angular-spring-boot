package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministrativeInformation {
    private String companyName;
    private String pon;
    private String version;
    private String ecInitiatedActivityInd;
    private String icCircuitReference;
    private Long issueNumber;
    private String issueStatusText;
    private String ecCompanyCode;
    private String orderNumber;
    private String referenceNumber;
    private String ecCircuit;
    private String twoSixCode;
    private String trunkGroupId;
    private String circuitLayoutOrderNumber;
    private String telecomServicePriority;
    private String designEngineeringContact;
    private String designContactTelephoneNumber;
    private String ecMaintenanceControlOffice;
    private String ecOperationsControlOffice;
    private String dlrdTask;
    private String cdlrdTask;
    private String ptdTask;
    private String ddTask;
    private String ecDesignerContact;
    private String ecTelephoneNumber;
    private String remarksLine1;
    private String remarksLine2;
    private String remarksLine3;
}
