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
@Table(name = "USER_DATA_CATEGORY_VALUES", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDataCategoryValues implements Serializable {

  @Column(name = "USER_DATA_CATEGORY")
  private String userDataCategory;

  @Id
  @Column(name = "USER_DATA_CATEGORY_VALUE_ID")
  @EqualsAndHashCode.Include
  private Long userDataCategoryValueId;

  @Column(name = "DISPLAY_VALUE")
  private String displayValue;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

}
