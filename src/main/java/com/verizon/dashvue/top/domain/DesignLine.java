package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignLine {
    private Long rowSequenceNumber;
    private String noteInd;
    private String location;
    private String equipmentTypeFacilityDesign;
    private String relayRackFacilityType;
    private String unitChannel;
    private String signalVoicePathType;
    private String zToATlp;
    private String aToZTlp;
    private String incrementalMileage;
    private String miscellaneousInformation;
}
