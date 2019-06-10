package com.verizon.dashvue.common.domain.dashvue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

@Entity
@Table(name = "CUST_ACCT", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class CustAcct implements Serializable {

  @Id
  @Column(name = "CUST_ACCT_ID")
  @EqualsAndHashCode.Include
  private Long custAcctId;

  @Column(name = "CUST_ACCT_NBR")
  private String custAcctNbr;

  @Column(name = "CUST_ACCT_TYPE")
  private String custAcctType;

  @Column(name = "ACCOUNT_STATUS")
  private String accountStatus;

  @Column(name = "CUSTACCT_PRIORITY_CD")
  private String custacctPriorityCd;

  @Column(name = "COMPANY_NAME")
  private String companyName;

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

  @Column(name = "ACCT_SECURITY")
  private String acctSecurity;

  @Column(name = "EXTRACT_CREATION_DATE")
  private Date extractCreationDate;

  @Column(name = "DISC_REASON_CD")
  private String discReasonCd;

  @Column(name = "FROM_EFF_DT")
  private Date fromEffDt;

  @Column(name = "TO_EFF_DT")
  private Date toEffDt;

  @Column(name = "FAX_NBR")
  private String faxNbr;

  @Column(name = "EMAIL_ADDR")
  private String emailAddr;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "BILLING_INTERFACE_CD")
  private String billingInterfaceCd;

  @Column(name = "SUSPEND_NP_IND")
  private String suspendNpInd;

  @Column(name = "PARTY_ID")
  private Long partyId;

  @Column(name = "PARTY_ROLE_SEQ")
  private Long partyRoleSeq;

  @Column(name = "WEB_ACCESS_USERID")
  private String webAccessUserid;

  @Column(name = "WEB_ACCESS_PASSWORD")
  private String webAccessPassword;

  @Column(name = "CUST_CLASS_CD")
  private String custClassCd;

  @Column(name = "SIGNATURE_ON_FILE_IND")
  private String signatureOnFileInd;

  @Column(name = "DUP_PRIVATE_IP_TRI")
  private String dupPrivateIpTri;

  @Column(name = "CUST_PROV_PARTY_ID")
  private Long custProvPartyId;

  @Column(name = "CUST_PROV_PARTY_ROLE_SEQ")
  private Long custProvPartyRoleSeq;

  @OneToOne(targetEntity = CustAcctSvcCatg.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "CUST_ACCT_ID")
  private CustAcctSvcCatg custAcctSvcCatg;

  @OneToMany(targetEntity = CustAcctAddr.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "CUST_ACCT_ID", referencedColumnName = "CUST_ACCT_ID")
  private List<CustAcctAddr> customerAddresses;

  public String getServiceCategoryName(){
    return getCustAcctSvcCatg().getSvcCatg().getSvcCatgName();
  }
}
