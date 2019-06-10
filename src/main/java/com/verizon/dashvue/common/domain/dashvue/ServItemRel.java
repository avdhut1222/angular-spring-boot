package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SERV_ITEM_REL", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServItemRel implements Serializable {

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonSerialize
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ServItemRelPK implements Serializable {

        @Column(name = "SERV_ITEM_ID")
        private Long servItemId;

        @Column(name = "SERV_ITEM_ID_REL")
        private Long servItemIdRel;
    }

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ServItemRelPK servItemRelPK;

    @Column(name = "LAST_MODIFIED_DATE")
    private java.sql.Date lastModifiedDate;

    @Column(name = "LAST_MODIFIED_USERID")
    private String lastModifiedUserid;

    @Column(name = "SI_REL_TYPE_CD")
    private String siRelTypeCd;

    @Column(name = "ACTIVE_IND")
    private String activeInd;
}
