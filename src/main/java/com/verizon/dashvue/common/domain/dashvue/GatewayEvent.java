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
@Table(name = "GATEWAY_EVENT", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class GatewayEvent implements Serializable {

  @Id
  @Column(name = "GATEWAY_EVENT_ID")
  @EqualsAndHashCode.Include
  private Long gatewayEventId;

  @Column(name = "GATEWAY_ID")
  private Long gatewayId;

  @Column(name = "GATEWAY_EVENT_NM")
  private String gatewayEventNm;

  @Column(name = "GATEWAY_EVENT_FORCE_REOPEN_IND")
  private String gatewayEventForceReopenInd;

  @Column(name = "GATEWAY_EVENT_LEVEL_CD")
  private String gatewayEventLevelCd;

  @Column(name = "GATEWAY_EVENT_DESCRIPTION")
  private String gatewayEventDescription;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "GATEWAY_EVENT_ACTIVE_DT")
  private Date gatewayEventActiveDt;

  @Column(name = "GATEWAY_EVENT_INACTIVE_DT")
  private Date gatewayEventInactiveDt;

  @Column(name = "IN_OUT_CD")
  private String inOutCd;

}
