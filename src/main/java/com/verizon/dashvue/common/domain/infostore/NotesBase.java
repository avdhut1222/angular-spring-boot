package com.verizon.dashvue.common.domain.infostore;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "NOTES_BASE", schema = "TBS")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotesBase implements Serializable {

  @Id
  @Column(name = "NOTES_ID")
  @EqualsAndHashCode.Include
  private Long notesId;

  @Column(name = "DOCUMENT_NUMBER")
  private Long documentNumber;

  @Column(name = "NOTES_SEQUENCE")
  private Long notesSequence;

  @Column(name = "NOTE_TEXT")
  private String noteText;

  @Column(name = "USER_ID")
  private String userId;

  @Column(name = "DATE_ENTERED")
  private LocalDate dateEntered;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private LocalDate lastModifiedDate;

  @Column(name = "CIRCUIT_DESIGN_ID")
  private Long circuitDesignId;

  @Column(name = "DOCUMENT_NUMBER_SRC")
  private Long documentNumberSrc;

  @Column(name = "SYSTEM_GEN_IND")
  private String systemGenInd;

  @Column(name = "CIRCUIT_NOTE_IND")
  private String circuitNoteInd;

  @Column(name = "EXCHANGE_CARRIER_CIRCUIT_ID")
  private String exchangeCarrierCircuitId;

  @Column(name = "TASK_TYPE")
  private String taskType;

  @Column(name = "DELAY_REASON_DESC")
  private String delayReasonDesc;

  @Column(name = "DELAY_TYPE_CD")
  private String delayTypeCd;

  @Column(name = "RECORD_LOAD_DATE")
  private LocalDate recordLoadDate;

  @Column(name = "RECORD_ID")
  private Long recordId;

  @Column(name = "HATTERAS")
  private Long hatteras;

  @Column(name = "CNR_TEMPLATE")
  private Long cnrTemplate;

  @Column(name = "EXPEDITE_INDICATOR")
  private Long expediteIndicator;

  @Column(name = "NETTEST")
  private Long nettest;

  @Column(name = "TEST_CALL_PLACED")
  private Long testCallPlaced;

  @Column(name = "NETTEST_PASS_FAIL")
  private String nettestPassFail;

  @Column(name = "IP_FLAG")
  private Long ipFlag;

  @Column(name = "PTD_TEMPLATE")
  private Long ptdTemplate;

  @Column(name = "NAC_FOLLOWUP")
  private Long nacFollowup;

  @Column(name = "SDCSCHED")
  private Long sdcsched;

  @Column(name = "MGRREV")
  private Long mgrrev;

}
