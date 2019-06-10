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
@Table(name = "DLR_CIRCUIT_DESIGN_LINE", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class DlrCircuitDesignLine implements Serializable {

    public DlrCircuitDesignLine(Long rowSequenceNbr, String noteInd, String location, String equipmentTypeFacilityDesig,
                                String relayRackFacilityType, String unitChannel, String signalVoicePathType, String zToATlp,
                                String aToZTlp, String incrementalMileage, String miscellaneousInformation, Long issueNbr) {
        this.setRowSequenceNbr(rowSequenceNbr);
        this.setNoteInd(noteInd);
        this.setLocation(location);
        this.setEquipmentTypeFacilityDesig(equipmentTypeFacilityDesig);
        this.setRelayRackFacilityType(relayRackFacilityType);
        this.setUnitChannel(unitChannel);
        this.setSignalVoicePathType(signalVoicePathType);
        this.setZToATlp(zToATlp);
        this.setAToZTlp(aToZTlp);
        this.setIncrementalMileage(incrementalMileage);
        this.setMiscellaneousInformation(miscellaneousInformation);
        DlrCircuitDesignLinePK dlrCircuitDesignLinePK = new DlrCircuitDesignLinePK();
        dlrCircuitDesignLinePK.setIssueNbr(issueNbr);
        this.setDlrCircuitDesignLinePK(dlrCircuitDesignLinePK);
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonSerialize
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DlrCircuitDesignLinePK implements Serializable {

        @Column(name = "CIRCUIT_DESIGN_ID")
        private Long circuitDesignId;

        @Column(name = "ISSUE_NBR")
        private Long issueNbr;

        @Column(name = "SEQUENCE_NUMBER")
        private Long sequenceNumber;
    }

    @EmbeddedId
    @EqualsAndHashCode.Include
    private DlrCircuitDesignLinePK dlrCircuitDesignLinePK;

    @Column(name = "ROW_SEQUENCE_NBR")
    private Long rowSequenceNbr;

    @Column(name = "NOTE_IND")
    private String noteInd;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "EQUIPMENT_TYPE_FACILITY_DESIG")
    private String equipmentTypeFacilityDesig;

    @Column(name = "RELAY_RACK_FACILITY_TYPE")
    private String relayRackFacilityType;

    @Column(name = "UNIT_CHANNEL")
    private String unitChannel;

    @Column(name = "SIGNAL_VOICE_PATH_TYPE")
    private String signalVoicePathType;

    @Column(name = "Z_TO_A_TLP")
    private String zToATlp;

    @Column(name = "A_TO_Z_TLP")
    private String aToZTlp;

    @Column(name = "INCREMENTAL_MILEAGE")
    private String incrementalMileage;

    @Column(name = "MISCELLANEOUS_INFORMATION")
    private String miscellaneousInformation;

    @Column(name = "LAST_MODIFIED_USERID")
    private String lastModifiedUserid;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @Column(name = "PRINT_THIS_LINE_ON_DLR_IND")
    private String printThisLineOnDlrInd;

    @Column(name = "DISCONNECT_IND")
    private String disconnectInd;

    @Column(name = "END_USER_LOCATION_ID")
    private String endUserLocationId;

    @Column(name = "END_USER_LOCATION_TYPE")
    private String endUserLocationType;

    @Column(name = "LOCATION_ID")
    private Long locationId;

    @Column(name = "CIRCUIT_DESIGN_ID_2")
    private Long circuitDesignId2;

    @Column(name = "CABLE_PAIR_SEQUENCE_NUMBER")
    private Long cablePairSequenceNumber;

    @Column(name = "A_Z_IND")
    private String aZInd;

    @Column(name = "CIRCUIT_DESIGN_ID_3")
    private Long circuitDesignId3;

    @Column(name = "CIRCUIT_POSITION_NUMBER")
    private Long circuitPositionNumber;

    @Column(name = "EQUIPMENT_ID")
    private Long equipmentId;

    @Column(name = "MOUNTING_POSITION_NUMBER")
    private String mountingPositionNumber;

    @Column(name = "BLOCK_IND")
    private String blockInd;

    @Column(name = "TFC_NETWORK_ID")
    private Long tfcNetworkId;

    @Column(name = "DROP_NODE_INDICATOR")
    private String dropNodeIndicator;

    @Column(name = "PORTADDR_SEQ")
    private Long portaddrSeq;

    @Column(name = "CABLE_ID")
    private Long cableId;

    @Column(name = "PAIR_OR_FIBER_NUMBER")
    private Long pairOrFiberNumber;

    @Column(name = "EQUIPMENT_SPEC_ID")
    private Long equipmentSpecId;

    @Column(name = "NETWORK_ROUTE_ID")
    private Long networkRouteId;

    @Column(name = "CIRCUIT_XREF_SEQ")
    private Long circuitXrefSeq;

    @Column(name = "DESIGN_ID_DLR_ISI")
    private Long designIdDlrIsi;

}
