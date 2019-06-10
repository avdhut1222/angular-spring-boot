package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 10/12/2018 11:01 AM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HuntGroup {
  private String huntGroupType;
  private String status;
  private String name;
  private String number;
  private List<HuntGroupDetail> details;

}
