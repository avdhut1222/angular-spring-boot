package com.verizon.dashvue.common.domain.dashvue;


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
@Table(name = "NOTES", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notes implements Serializable {

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

  @Column(name = "LOCATION_ID")
  private Long locationId;

  @Column(name = "LOCATION_ID_2")
  private Long locationId2;


}
