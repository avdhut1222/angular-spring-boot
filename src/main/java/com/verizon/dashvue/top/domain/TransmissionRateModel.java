package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mankavale, Avdhut
 * Created: 3/12/2019 12:02 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransmissionRateModel {
  private String rateCode;
  private Long transmissionRateQuantity;
  private String transmissionRateUnitOfMeasure;
}
