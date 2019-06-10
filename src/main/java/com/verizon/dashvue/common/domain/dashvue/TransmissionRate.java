package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "TRANSMISSION_RATE", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class TransmissionRate {

  @Id
  @Column(name = "RATE_CODE")
  @EqualsAndHashCode.Include
  private String rateCode;

  @Column(name = "TRANSMISSION_RATE_QUANTITY")
  private Long transmissionRateQuantity;

  @Column(name = "TRANS_RATE_UNIT_OF_MEASURE")
  private String transRateUnitOfMeasure;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "SYSTEM_CODE")
  private String systemCode;

  @Column(name = "TRANSACTION_ORIGIN")
  private String transactionOrigin;

  @Column(name = "GROUPS_OF_QUANTITY")
  private Long groupsOfQuantity;

  @Column(name = "ASYNC_SYNC_CD")
  private String asyncSyncCd;
}
