package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "ASSIGNED_TEL_NUM", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignedTelNum implements Serializable {

  @Id
  @Column(name = "ATN_ID")
  @EqualsAndHashCode.Include
  private Long atnId;

  @Column(name = "SERV_ITEM_ID")
  private Long servItemId;

  @Column(name = "DOCUMENT_NUMBER")
  private Long documentNumber;

  @Column(name = "TEL_NBR_NPA")
  private String telNbrNpa;

  @Column(name = "TEL_NBR_NXX")
  private String telNbrNxx;

  @Column(name = "TEL_NBR_LINE_RANGE")
  private String telNbrLineRange;

  @Column(name = "TEL_NBR_SUF")
  private String telNbrSuf;

  @Column(name = "VANITY_IND")
  private String vanityInd;

  @Column(name = "SRSI_TN_RANGE_ID")
  private Long srsiTnRangeId;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "ACTIVITY_IND")
  private String activityInd;

  @Column(name = "FOREIGN_LIST_TYPE")
  private String foreignListType;

  @Column(name = "LOCAL_LIST_TYPE")
  private String localListType;

  @Column(name = "IDENTITY_CD")
  private String identityCd;

  @Column(name = "TERM_NBR")
  private String termNbr;

  @OneToOne(targetEntity = ServReqSi.class, fetch = FetchType.LAZY)
  @JoinColumns({
    @JoinColumn(name = "DOCUMENT_NUMBER", referencedColumnName = "DOCUMENT_NUMBER", insertable = false, updatable = false),
    @JoinColumn(name = "SERV_ITEM_ID", referencedColumnName = "SERV_ITEM_ID", insertable = false, updatable = false)
  })
  private ServReqSi servReqSi;

}
