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
@Table(name = "SVCREQ_PROVPLAN", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class ServReqProvplan implements Serializable {

  @Id
  @Column(name = "REQ_PLAN_ID")
  @EqualsAndHashCode.Include
  private Long reqPlanId;

  @Column(name = "DOCUMENT_NUMBER")
  private Long documentNumber;

  @ManyToOne(targetEntity = ProvisioningPlan.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "PLAN_ID")
  private ProvisioningPlan provisioningPlan;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "DISPLAY_SEQUENCE")
  private Long displaySequence;

}
