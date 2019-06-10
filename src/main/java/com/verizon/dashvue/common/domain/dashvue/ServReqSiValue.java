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
@Table(name = "SERV_REQ_SI_VALUE", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class ServReqSiValue {


  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class ServReqSiValuePK implements Serializable {

    @Column(name = "DOCUMENT_NUMBER")
    private Long documentNumber;

    @Column(name = "SERV_ITEM_ID")
    private Long servItemId;

    @Column(name = "VALUE_LABEL")
    private String valueLabel;

    @Column(name = "SRSI_VALUE_SEQ")
    private String srsiValueSeq;
  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private ServReqSiValuePK servReqSiValuePK;

  @Column(name = "VALID_VALUE")
  private String validValue;

  @Column(name = "ACTIVITY_CD")
  private String activityCd;

  @Column(name = "PREV_VALUE")
  private String prevValue;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "VALUE_CODE")
  private String valueCode;

  @Column(name = "LABEL_CD")
  private String labelCd;

  @Column(name = "STD_ITEM_PROVIDER_DATA_ID")
  private Long stdItemProviderDataId;

}
