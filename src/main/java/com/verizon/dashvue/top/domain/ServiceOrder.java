package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Mankavale, Avdhut
 * Created: 10/30/2018 3:24 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOrder {

  private String orderedBy;
  private LocalDate serviceOrderDate;
  private String orderedByTelNumber;
}


