package com.verizon.dashvue.top.domain;

import com.verizon.dashvue.common.procresult.LocationQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/18/2019 5:15 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalServiceLocationProduct {
  private String itemAlias;
  private Long itemAliasSuf;
  private String activityCdText;
  private String servItemDesc;
  private List<ValueLabelModel> valueLabels;
  private List<LocationQuery> primaryLocations;
  private List<LocationQuery> secondaryLocations;
  private List<LocationQuery> orderServiceLocations;
}
