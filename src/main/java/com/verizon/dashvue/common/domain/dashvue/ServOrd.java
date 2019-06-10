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
@Table(name = "SERV_ORD", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class ServOrd implements Serializable {

  @Id
  @Column(name = "DOCUMENT_NUMBER")
  @EqualsAndHashCode.Include
  private Long documentNumber;

  @Column(name = "SVCORDER_DT")
  private Date serviceOrderDate;

  @Column(name = "TYPE")
  private String type;

  @Column(name = "ANTICIPATED_DEL_DT")
  private Date anticipatedDelDt;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "ORDERED_BY_TEL_NBR")
  private String orderedByTelNbr;

  @Column(name = "ORDER_ACT_IND")
  private String orderActInd;

  @Column(name = "EMAIL_ADDR")
  private String emailAddr;

  @Column(name = "FAX_NBR")
  private String faxNbr;

  @Column(name = "CREATED_BY_USERID")
  private String createdByUserid;

  @Column(name = "LAST_NM")
  private String lastName;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "SERV_ORD_TYPE_CD")
  private String servOrdTypeCd;

}
