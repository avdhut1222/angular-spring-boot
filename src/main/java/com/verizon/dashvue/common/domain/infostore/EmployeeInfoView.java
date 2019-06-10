package com.verizon.dashvue.common.domain.infostore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_INFO_VW",schema = "ORAFIN")
@Immutable
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class EmployeeInfoView implements Serializable {

  @Id
  @Column(name = "NETWORK_ID")
  @EqualsAndHashCode.Include
  private String networkId;

  @Column(name = "PERSON_ID")
  @EqualsAndHashCode.Include
  private String personId;

  @Column(name = "LAST_NAME")
  private String lastName;
  
  @Column(name = "FIRST_NAME")
  private String firstName;
  
  @Column(name = "MIDDLE_NAMES")
  private String middleNames;
  
  @Column(name = "EMPLOYEE_NUMBER")
  private String employeeNumber;
  
  @Column(name = "HIREDATE")
  private Date hiredate;

  @Column(name = "TERMINATEDATE")
  private Date terminatedate;

  @Column(name = "JOB_ID")
  private String jobId;

  @Column(name = "JOB_TITLE")
  private String jobTitle;

  @Column(name = "JOBCODE")
  private String jobcode;

  @Column(name = "CURRENT_POSITION_STARTDATE")
  private Date currentPositionStartdate;

  @Column(name = "EMAIL_ADDRESS")
  private String emailAddress;

  @Column(name = "SUPERVISOR_ORG_ID")
  private String supervisorOrgId;

  @Column(name = "SUPERVISOR_ORG_NAME")
  private String supervisorOrgName;

  @Column(name = "TIER3_COSTCENTER_ID")
  private String tier3CostcenterId;

  @Column(name = "TIER3_COSTCENTER_NAME")
  private String tier3CostcenterName;

  @Column(name = "SUPERVISOR_EMPNUM")
  private String supervisorEmpnum;

  @Column(name = "SUPERVISOR_NAME")
  private String supervisorName;

  @Column(name = "TIER2_DETAIL_BUSINESS_UNIT")
  private String tier2DetailBusinessUnit;

  @Column(name = "TIER1_BUSINESS_UNIT")
  private String tier1BusinessUnit;

  @Column(name = "WORK_LOCATION")
  private String workLocation;

  @Column(name = "OFFICE_PHONE_NUMBER")
  private String officePhoneNumber;

  @Column(name = "FTE_PERCENT")
  private String ftePercent;

  @Column(name = "TIER3_PARENT_COSTCENTER_ID")
  private String tier3ParentCostcenterId;

  @Column(name = "TIER3_PARENT_COSTCENTER_NAME")
  private String tier3ParentCostcenterName;

  @Column(name = "TIER4_TEAM")
  private String tier4Team;

  @Column(name = "RECORD_LOAD_DATE")
  private Date recordLoadDate;

  @Column(name = "SUFFIX")
  private String suffix;

  @Column(name = "OFFICE")
  private String office;

  @Column(name = "MOBILE_PHONE")
  private String mobilePhone;

  @Column(name = "HOME_PHONE")
  private String homePhone;

  @Column(name = "COMM_FLAG")
  private String commFlag;

  @Column(name = "WORK_LOCATION_STREET1")
  private String workLocationStreet1;

  @Column(name = "WORK_LOCATION_STREET2")
  private String workLocationStreet2;

  @Column(name = "WORK_LOCATION_CITY")
  private String workLocationCity;

  @Column(name = "WORK_LOCATION_ZIP")
  private String workLocationZip;

//  @Column(name = "CERIDIAN_JOBCODE")
//  private String ceridianJobcode;

  @Column(name = "VZ_JOBCODE")
  private String vzJobcode;

  @Column(name = "FULL_NAME_LFM")
  private String fullNameLfm;

  @Column(name = "FULL_NAME_FML")
  private String fullNameFml;

  @Column(name = "SUPERVISOR_ID")
  private String supervisorId;

  @Column(name = "VZORG_ID")
  private String vzorgId;

  @Column(name = "VZORG_NAME")
  private String vzorgName;

  @Column(name = "VZ_ID")
  private String vzId;

  @Column(name = "XO_EMPLOYEE_NUMBER")
  private String xoEmployeeNumber;

  @Column(name = "WORK_LOCATION_STATE")
  private String workLocationState;

  @Column(name = "COUNTRY_CODE")
  private String countryCode;
}
