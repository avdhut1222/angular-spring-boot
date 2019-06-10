package com.verizon.dashvue.common.domain.dashvue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author Mankavale, Avdhut
 * Created: 10/2/2018 11:19 AM
 */

@Entity
@Table(name = "SI_GRP_SRSI", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class SiGroupSrsi implements Serializable {

  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class SiGroupSrsiPK implements Serializable {

    @Column(name = "SERV_ITEM_ID")
    private Long servItemId;

    @Column(name = "DOCUMENT_NUMBER")
    private Long documentNumber;

    @Column(name = "GRP_NM")
    private String groupName;

    @Column(name = "GRP_TYPE")
    private String groupType;
  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private SiGroupSrsiPK siGroupSrsiPK;

  @Column(name = "ACTIVITY_CD")
  private String activityCode;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;


//  public String getGroupName(){
//    return getGroupName();
//  }
}
