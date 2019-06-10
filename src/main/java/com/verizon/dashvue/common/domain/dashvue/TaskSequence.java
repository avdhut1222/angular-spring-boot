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
@Table(name = "TASK_SEQUENCE", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskSequence implements Serializable {

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonSerialize
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TaskSequencePK implements Serializable {
        @Column(name = "DOCUMENT_NUMBER")
        private Long documentNumber;

        @Column(name = "TASK_NUMBER")
        private Long taskNumber;

        @Column(name = "RELATED_DOCUMENT_NUMBER")
        private Long relatedDocumentNumber;

        @Column(name = "RELATED_TASK_NUMBER")
        private Long relatedTaskNumber;
    }

    @EmbeddedId
    @EqualsAndHashCode.Include
    private TaskSequencePK taskSequencePK;

    @Column(name = "LAST_MODIFIED_USERID")
    private String lastModifiedUserid;

    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDate lastModifiedDate;


}
