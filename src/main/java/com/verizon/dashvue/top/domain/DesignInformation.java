package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignInformation {
    private String accessCustTerminalLocation;
    private String linkType;
    private String additionalPointOfTermination;
    private String signallingLinkCode;
    private String trunkCircuitIdCode;
    private String circuitBridgingLocation;
    private String customerSignallingPointCode;
    private String primaryLocation;
    private String secondaryPointOfTermPriloc;
    private String ecSignalingPointCode;
    private String secondaryLocation;
    private String secondaryPointOfTermSecloc;
    private String networkChannelCode;
    private String networkChannelOptionCode;
    private String networkChannelInterfaceCode;
    private String transmissionLevelPoint;
    private String machineInterfaceCode;
    private String connectingFacilityAssignment;
    private String secNetworkChannelInterface;
    private String secondaryTransmitLevelPoint;
}
