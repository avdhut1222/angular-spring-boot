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
@Table(name = "EMPLOYEE", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class Employee implements Serializable {

  @Id
  @Column(name = "EMPLOYEE_NUMBER")
  @EqualsAndHashCode.Include
  private String employeeNumber;

  @Column(name = "EMPLOYEE_FIRST_NAME")
  private String employeeFirstName;

  @Column(name = "EMPLOYEE_MIDDLE_NAME")
  private String employeeMiddleName;

  @Column(name = "EMPLOYEE_LAST_NAME")
  private String employeeLastName;

  @Column(name = "ORGANIZATION_ID")
  private String organizationId;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "SYSTEM_USERID")
  private String systemUserid;

  @Column(name = "EMAIL_ADDRESS")
  private String emailAddress;

}
