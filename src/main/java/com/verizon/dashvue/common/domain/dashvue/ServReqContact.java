package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "SERV_REQ_CONTACT", schema = "ASAP")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class ServReqContact implements Serializable {

  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class ServReqContactPK implements Serializable {

    @Column(name = "DOCUMENT_NUMBER")
    private Long documentNumber;

    @Column(name = "SR_CONTACT_SEQ")
    private String srContactSeq;

  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private ServReqContactPK servReqContactPK;

  @Column(name = "SR_CONTACT_TYPE")
  private String srContactType;

  @Column(name = "NM_TITLE_ABBREV")
  private String nameTitleAbbrev;

  @Column(name = "FIRST_NM")
  private String firstName;

  @Column(name = "MIDDLE_INITIAL")
  private String middleInitial;

  @Column(name = "LAST_NM")
  private String lastName;

  @Column(name = "NM_SUFFIX_ABBREV")
  private String nameSuffixAbbrev;

  @Column(name = "TEL_NBR")
  private String telNbr;

  @Column(name = "FAX_NBR")
  private String faxNbr;

  @Column(name = "CELL_TEL_NBR")
  private String cellTelNbr;

  @Column(name = "PAGER_PIN")
  private String pagerPin;

  @Column(name = "PAGER_NBR")
  private String pagerNbr;

  @Column(name = "EMAIL_ADDR")
  private String emailAddr;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "NIC_HANDLE")
  private String nicHandle;

  @Column(name = "ADDR_LN1")
  private String addrLine1;

  @Column(name = "ADDR_LN2")
  private String addrLine2;

  @Column(name = "ADDR_LN3")
  private String addrLine3;

  @Column(name = "ADDR_LN4")
  private String addrLine4;

  @Column(name = "GA_INSTANCE_ID_CITY")
  private Long gaInstanceIdCity;

  @Column(name = "GA_INSTANCE_ID_STATE")
  private Long gaInstanceIdState;

  @Column(name = "GA_INSTANCE_ID_COUNTRY")
  private Long gaInstanceIdCountry;

  @Column(name = "POSTAL_CODE")
  private String postalCode;

}
