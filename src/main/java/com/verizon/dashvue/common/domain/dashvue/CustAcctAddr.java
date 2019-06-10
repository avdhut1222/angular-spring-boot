package com.verizon.dashvue.common.domain.dashvue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "CUST_ACCT_ADDR", schema = "ASAP")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class CustAcctAddr implements Serializable {

  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class CustAcctAddrPK implements Serializable {

    @ManyToOne(targetEntity = Address.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Column(name = "CUST_ACCT_ID")
    private Long custAcctId;

    @Column(name = "CUST_ADDR_SEQ")
    private String custAddrSeq;

    @Column(name = "CUST_ADDR_FUNCTION_CD")
    private String custAddrFunctionCd;

  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private CustAcctAddrPK custAcctAddrPK;

  @Column(name = "COMPANY_NAME")
  private String companyName;

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

  @Column(name = "EMAIL_ADDR")
  private String emailAddr;

  @Column(name = "DISPATCH_METHOD_CD")
  private String dispatchMethodCd;

  @Column(name = "FROM_EFF_DT")
  private Date fromEffDt;

  @Column(name = "TO_EFF_DT")
  private Date toEffDt;

  @Column(name = "SECONDARY_BILL_NAME")
  private String secondaryBillName;

  @Column(name = "SEND_TO_BILLING_IND")
  private String sendToBillingInd;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "INCORPORATED_CD")
  private String incorporatedCd;

  @Column(name = "GENERAL_DEL_IND")
  private String generalDelInd;

}
