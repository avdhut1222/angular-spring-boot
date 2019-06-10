package com.verizon.dashvue.common.domain.dashvue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "CUST_ACCT_SVC_CATG", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class CustAcctSvcCatg implements Serializable {

  @Id
  @Column(name = "CUST_ACCT_ID")
  @EqualsAndHashCode.Include
  private Long custAcctId;

  @ManyToOne(targetEntity = SvcCatg.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "SVC_CATG_ID")
  private SvcCatg svcCatg;

  @Column(name = "SUB_ACCT_IND")
  private String subAcctInd;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;


}
