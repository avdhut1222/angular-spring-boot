package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Mankavale, Avdhut
 * Created: 10/1/2018 11:21 AM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PsrOrderDetails {

  @EqualsAndHashCode.Include
  private Long orderNumber;

  private String customerAccountNumber;
  private String customerCompanyName;
  private String customerPriorityCode;
  private String serviceCategoryName;
  private String activityIndicator;
  private String btn;
  private String organizationName;
  private LocalDate desiredDueDate;
  private String orderedBy;
  private LocalDate serviceOrderDate;
  private String orderedByTelNumber;
  private String project;
  private String relatedPon;
  private String supplementTypeText;
  private String pon;
  private String contactType;
  private String telephoneNumber;
  private String firstName;
  private String lastName;
  private String primaryBilling;
  private String assignedProvPlan;
}
