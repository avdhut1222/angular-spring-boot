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
@Table(name = "ORGANIZATION", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class Organization implements Serializable {

  @Id
  @Column(name = "ORGANIZATION_ID")
  @EqualsAndHashCode.Include
  private String organizationId;

  @Column(name = "ORGANIZATION_NAME")
  private String organizationName;

  @Column(name = "ORGANIZATION_ADDRESS")
  private String organizationAddress;

  @Column(name = "ORGANIZATION_PHONE_NUMBER")
  private String organizationPhoneNumber;

  @Column(name = "ORGANIZATION_TYPE")
  private String organizationType;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @ManyToOne(targetEntity = Organization.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "ORGANIZATION_ID_2")
  private Organization parentOrganization;

  @Column(name = "DEFAULT_PREFIX")
  private String defaultPrefix;

  @Column(name = "PARTY_ID")
  private Long partyId;

  @Column(name = "PARTY_ROLE_SEQ")
  private Long partyRoleSeq;

}
