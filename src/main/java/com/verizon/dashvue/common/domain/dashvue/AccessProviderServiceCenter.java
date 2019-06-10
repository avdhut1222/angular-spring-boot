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
@Table(name = "ACCESS_PROVIDER_SERVICE_CENTER", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessProviderServiceCenter implements Serializable {

  @Id
  @Column(name = "ACCESS_PROVIDER_SERV_CTR_CODE")
  @EqualsAndHashCode.Include
  private String accessProviderServCtrCode;

  @Column(name = "ACCESS_PROVIDER_SERV_CTR_NAME")
  private String accessProviderServCtrName;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "TELCO_ID")
  private String telcoId;

  @Column(name = "TBS_OWNER_IND")
  private String tbsOwnerInd;

  @Column(name = "OPERATING_COMPANY_NUMBER")
  private String operatingCompanyNumber;

  @Column(name = "USE_TASK_DATE_RELS_IND")
  private String useTaskDateRelsInd;

  @Column(name = "VER_IDENT_SCHEME")
  private String verIdentScheme;

  @Column(name = "VER_IDENT_START")
  private String verIdentStart;


}
