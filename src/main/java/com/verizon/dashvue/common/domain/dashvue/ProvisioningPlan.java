package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "PROVISIONING_PLAN", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProvisioningPlan implements Serializable {

  @Id
  @Column(name = "PLAN_ID")
  @EqualsAndHashCode.Include
  private Long planId;

  @Column(name = "PLAN_NAME")
  private String planName;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "ORGANIZATION_ID")
  private String organizationId;

  @Column(name = "JURISDICTION_CODE")
  private String jurisdictionCode;

  @Column(name = "SERVICE_TYPE_GROUP_FUNCTION")
  private String serviceTypeGroupFunction;

  @Column(name = "SERVICE_TYPE_GROUP_NAME")
  private String serviceTypeGroupName;

  @Column(name = "ACTIVE_IND")
  private String activeInd;

  @Column(name = "PROV_PLAN_TYPE_CD")
  private Long provPlanTypeCd;

  @Column(name = "PROV_PLAN_DEFAULT_IND")
  private String provPlanDefaultInd;

}
