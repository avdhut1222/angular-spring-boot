package com.verizon.dashvue.common.procresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author Mankavale, Avdhut
 * Created: 3/11/2019 3:14 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopCktQueryResult {

  private String circuitDesignId;
  private String locationId;
  private String locationId2;

}
