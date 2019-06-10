package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "SRSI_CA_VAL", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class SrsiCaVal implements Serializable {

  @Id
  @Column(name = "SRSI_CA_VAL_ID")
  @EqualsAndHashCode.Include
  private Long srsiCaValId;

  @Column(name = "SERV_ITEM_ID")
  private Long servItemId;

  @Column(name = "DOCUMENT_NUMBER")
  private Long documentNumber;

  @Column(name = "CA_VALUE")
  private String caValue;

  @Column(name = "CA_VALUE_LABEL")
  private String caValueLabel;

  @Column(name = "CA_VALUE_UOM")
  private String caValueUom;

  @Column(name = "CA_USAGE_ID")
  private Long caUsageId;

  @Column(name = "CA_USAGE_VV_ID")
  private Long caUsageVvId;

  @Column(name = "MS_BB_ID")
  private Long msBbId;

  @Column(name = "CA_MOVE_CD")
  private Long caMoveCd;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "CA_ID")
  private Long caId;

}
