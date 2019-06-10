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
@Table(name = "NS_CON_REL", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class NsConRel implements Serializable {

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonSerialize
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class NsConRelPK implements Serializable {
        @Column(name = "CIRCUIT_DESIGN_ID_PARENT")
        private Long circuitDesignIdParent;

        @Column(name = "CIRCUIT_DESIGN_ID_CHILD")
        private Long circuitDesignIdChild;
    }

    @EmbeddedId
    @EqualsAndHashCode.Include
    private NsConRelPK nsConRelPK;

    @Column(name = "NS_CON_REL_STATUS_CD")
    private String nsConRelStatusCd;

    @Column(name = "NS_COMP_ID")
    private Long nsCompId;

    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDate lastModifiedDate;

    @Column(name = "LAST_MODIFIED_USERID")
    private String lastModifiedUserid;

    @Column(name = "NS_CON_REL_TYPE_CD")
    private Long nsConRelTypeCd;

    @Column(name = "NS_CR_SEND_PERSPECTIVE_CD")
    private String nsCrSendPerspectiveCd;

    @Column(name = "PENDING_DT")
    private LocalDate pendingDt;

    @Column(name = "DOCUMENT_NUMBER")
    private Long documentNumber;

}
