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
@Table(name = "SVC_CATG", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class SvcCatg implements Serializable {

  @Id
  @Column(name = "SVC_CATG_ID")
  @EqualsAndHashCode.Include
  private Long svcCatgId;

  @Column(name = "SVC_CATG_NM")
  private String svcCatgName;

  @Column(name = "DESCRIPTION_254")
  private String description;

  @Column(name = "FROM_EFF_DT")
  private Date fromEffDt;

  @Column(name = "TO_EFF_DT")
  private Date toEffDt;

  @Column(name = "SVC_CATG_TYPE")
  private String svcCatgType;

  @Column(name = "DISC_RESERVE_PERIOD")
  private Long discReservePeriod;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

}
