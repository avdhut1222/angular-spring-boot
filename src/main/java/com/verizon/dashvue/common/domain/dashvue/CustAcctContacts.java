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
@Table(name = "CUST_ACCOUNT_CONTACTS", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class CustAcctContacts implements Serializable {

  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class CustAcctContactsPK implements Serializable {

    @Column(name = "CUST_ACCT_ID")
    private Long custAcctId;

    @Column(name = "CA_CONTACT_SEQ")
    private String caContactSeq;
  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private CustAcctContactsPK custAcctContactsPK;

  @Column(name = "NM_TITLE_ABBREV")
  private String nmTitleAbbrev;

  @Column(name = "FIRST_NM")
  private String firstNm;

  @Column(name = "MIDDLE_INITIAL")
  private String middleInitial;

  @Column(name = "LAST_NM")
  private String lastNm;

  @Column(name = "NM_SUFFIX_ABBREV")
  private String nmSuffixAbbrev;

  @Column(name = "TEL_NBR")
  private String telNbr;

  @Column(name = "CUST_CONTACT_TYPE")
  private String custContactType;

  @Column(name = "FROM_EFF_DT")
  private Date fromEffDt;

  @Column(name = "TO_EFF_DT")
  private Date toEffDt;

  @Column(name = "SEND_TO_BILLING_IND")
  private String sendToBillingInd;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "FAX_NBR")
  private String faxNbr;

  @Column(name = "EMAIL_ADDR")
  private String emailAddr;

  @Column(name = "CELL_TEL_NBR")
  private String cellTelNbr;

  @Column(name = "PAGER_NBR")
  private String pagerNbr;

  @Column(name = "PAGER_PIN")
  private String pagerPin;

  @Column(name = "HOUSE_NBR")
  private String houseNbr;

  @Column(name = "NIC_HANDLE")
  private String nicHandle;

  @Column(name = "ADDR_LN1")
  private String addrLn1;

  @Column(name = "ADDR_LN2")
  private String addrLn2;

  @Column(name = "ADDR_LN3")
  private String addrLn3;

  @Column(name = "ADDR_LN4")
  private String addrLn4;

  @Column(name = "GA_INSTANCE_ID_CITY")
  private Long gaInstanceIdCity;

  @Column(name = "GA_INSTANCE_ID_STATE")
  private Long gaInstanceIdState;

  @Column(name = "GA_INSTANCE_ID_COUNTRY")
  private Long gaInstanceIdCountry;

  @Column(name = "POSTAL_CODE")
  private String postalCode;

}
