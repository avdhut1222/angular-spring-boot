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
@Table(name = "MS_ATTACHMENT_LINK", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class MsAttachmentLink implements Serializable {

  @Id
  @Column(name = "MS_ATTACHMENT_LINK_ID")
  @EqualsAndHashCode.Include
  private Long msAttachmentLinkId;

  @Column(name = "MS_TABLE_NM")
  private String msTableNm;

  @Column(name = "MS_TABLE_KEY_ID")
  private Long msTableKeyId;

  @Column(name = "MS_TABLE_KEY_VALUE")
  private String msTableKeyValue;

  @Column(name = "URL")
  private String url;

  @Column(name = "URL_DESC")
  private String urlDesc;

  @Column(name = "CREATION_DATE")
  private Date creationDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "TRANSFORM_ID")
  private Long transformId;

}
