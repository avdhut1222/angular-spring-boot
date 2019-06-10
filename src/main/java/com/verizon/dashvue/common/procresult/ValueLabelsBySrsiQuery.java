package com.verizon.dashvue.common.procresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mankavale, Avdhut
 * Created: 3/15/2019 2:20 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValueLabelsBySrsiQuery {
  private String valueLabel;
  private String srsiValueSeq;
  private String validValue;
  private String activityCd;
  private String prevValue;
}
