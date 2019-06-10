package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "USER_DATA_COLUMN", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDataColumn implements Serializable {

  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class UserDataColumnPK implements Serializable {

    @Column(name = "TABLE_OWNER")
    private String tableOwner;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "COLUMN_NAME")
    private String columnName;
  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private UserDataColumnPK userDataColumnPK;

  @Column(name = "USER_DATA_CATEGORY")
  private String userDataCategory;

  @Column(name = "COLUMN_STYLE")
  private String columnStyle;

  @Column(name = "X_WINDOW_COORDINATE")
  private String xWindowCoordinate;

  @Column(name = "Y_WINDOW_COORDINATE")
  private String yWindowCoordinate;

  @Column(name = "COLUMN_LABEL")
  private String columnLabel;

  @Column(name = "ACTIVE_IND")
  private String activeInd;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "COLUMN_ORDER")
  private String columnOrder;

  @Column(name = "FOREIGN_KEY_IND")
  private String foreignKeyInd;
}
