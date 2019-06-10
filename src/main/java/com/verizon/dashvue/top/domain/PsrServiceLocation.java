package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mankavale, Avdhut
 * Created: 10/24/2018 3:16 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PsrServiceLocation {

  private String lineCoding;
  private String framing;
}
