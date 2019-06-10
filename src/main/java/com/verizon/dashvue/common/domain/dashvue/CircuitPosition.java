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
@Table(name = "CIRCUIT_POSITION", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class CircuitPosition implements Serializable {

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonSerialize
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CircuitPositionPK implements Serializable {
        @Column(name = "CIRCUIT_DESIGN_ID")
        private Long circuitDesignId;

        @Column(name = "CIRCUIT_POSITION_NUMBER")
        private Long circuitPositionNumber;
    }

    @EmbeddedId
    @EqualsAndHashCode.Include
    private CircuitPositionPK circuitPositionPK;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "CIRCUIT_NODE_STATUS")
    private String circuitNodeStatus;

    @Column(name = "LAST_MODIFIED_USERID")
    private String lastModifiedUserid;

    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDate lastModifiedDate;

    @Column(name = "RATE_CODE")
    private String rateCode;

    @Column(name = "CIRCUIT_DESIGN_ID_3")
    private Long circuitDesignId3;

    @Column(name = "DOCUMENT_NUMBER")
    private Long documentNumber;

    @Column(name = "PENDING_DT")
    private LocalDate pendingDt;

    @Column(name = "CIRCUIT_DESIGN_ID_PREV")
    private Long circuitDesignIdPrev;

    @Column(name = "STS_CHAN_NBR")
    private Long stsChanNbr;

    @Column(name = "VTG_CHAN_NBR")
    private Long vtgChanNbr;

    @Column(name = "VT_CHAN_NBR")
    private Long vtChanNbr;

    @Column(name = "EQUIV_CHAN")
    private Long equivChan;

    @Column(name = "ADDITIONAL_ASSIGNMENT_SEQ_NBR")
    private Long additionalAssignmentSeqNbr;

    @Column(name = "NS_COMP_ID")
    private Long nsCompId;

    @Column(name = "NS_ID")
    private Long nsId;

    @Column(name = "PROTECTED_PATH_TRI")
    private String protectedPathTri;


}
