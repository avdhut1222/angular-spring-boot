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
@Table(name = "DLR_NOTES", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class DlrNotes implements Serializable {

  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class DlrNotesPK implements Serializable {

    @Column(name = "CIRCUIT_DESIGN_ID")
    private Long circuitDesignId;

    @Column(name = "ISSUE_NBR")
    private Long issueNbr;

    @Column(name = "DLR_NOTES_SEQUENCE_NBR")
    private Long dlrNotesSequenceNbr;

    @Column(name = "NOTE_IND")
    private String noteInd;
  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private DlrNotesPK dlrNotesPK;

  @Column(name = "DLR_NOTES_TEXT")
  private String dlrNotesText;

  @Column(name = "PRINT_THIS_LINE_ON_DLR_IND")
  private String printThisLineOnDlrInd;

}
