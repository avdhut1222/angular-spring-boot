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
@Table(name = "GATEWAY_EVENT_ERROR", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class GatewayEventError implements Serializable {

  @Id
  @Column(name = "GATEWAY_EVENT_ERR_ID")
  @EqualsAndHashCode.Include
  private Long gatewayEventErrId;

  @Column(name = "GATEWAY_EVENT_ID")
  private Long gatewayEventId;

  @Column(name = "DOCUMENT_NUMBER")
  private Long documentNumber;

  @Column(name = "TASK_NUMBER")
  private Long taskNumber;

  @Column(name = "SERV_ITEM_ID")
  private Long servItemId;

  @Column(name = "GATEWAY_EVENT_ERR_BLOCK_NBR")
  private Long gatewayEventErrBlockNbr;

  @Column(name = "GATEWAY_EVENT_ERR_CD")
  private Long gatewayEventErrCd;

  @Column(name = "GATEWAY_EVENT_ERR_MSG")
  private String gatewayEventErrMsg;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "DOCUMENT_NUMBER_SRGE")
  private Long documentNumberSrge;

  @Column(name = "GATEWAY_EVENT_ID_SRGE")
  private Long gatewayEventIdSrge;

  @Column(name = "TASK_NUMBER_SRGE")
  private Long taskNumberSrge;


}
