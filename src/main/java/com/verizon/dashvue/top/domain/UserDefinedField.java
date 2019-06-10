package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Mankavale, Avdhut
 * Created: 10/16/2018 10:44 AM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDefinedField {

  @EqualsAndHashCode.Include
  private String udfName;

  @EqualsAndHashCode.Include
  private String udfValue;

  private String udfStyle;
  private String udfLabel;
  private String udfOrder;
  private String udfDisplayValue;
  private String udfForeignKeyInd;
  private String udfUserName;

  private String udfKey;
  private String udfTable;


}
