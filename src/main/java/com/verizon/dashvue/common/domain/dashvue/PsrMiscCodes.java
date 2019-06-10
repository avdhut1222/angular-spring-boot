package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Embeddable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "PSR_MISC_CODES", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class PsrMiscCodes implements Serializable {

  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class PsrMiscCodesPK implements Serializable {
    @Column(name = "MISCELLANEOUS_CODE_CATEGORY")
    private String miscellaneousCodeCategory;

    @Column(name = "MISCELLANEOUS_CODE_VALUE")
    private String miscellaneousCodeValue;
  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private PsrMiscCodesPK psrMiscCodesPK;

  @Column(name = "SHORT_DESCRIPTION")
  private String shortDescription;

  @Column(name = "DEFAULT_VALUE_IND")
  private String defaultValueInd;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "SYSTEM_DEF_CD")
  private String systemDefCd;

}
