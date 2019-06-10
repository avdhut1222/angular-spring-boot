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
@Table(name = "JEOPARDY_TYPE", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class JeopardyType implements Serializable {

  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class JeopardyTypePK implements Serializable {

    @Column(name = "JEOPARDY_REASON_CODE")
    private String jeopardyReasonCode;

    @Column(name = "JEOPARDY_TYPE_CD")
    private String jeopardyTypeCd;
  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private JeopardyTypePK jeopardyTypePK;

  @Column(name = "JEOPARDY_REASON_DESCRIPTION")
  private String jeopardyReasonDescription;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private LocalDate lastModifiedDate;

  @Column(name = "TRANSACTION_ORIGIN")
  private String transactionOrigin;


  @Column(name = "ACTIVE_IND")
  private String activeInd;

}
