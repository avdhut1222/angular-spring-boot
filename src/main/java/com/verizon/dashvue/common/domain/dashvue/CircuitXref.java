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

@Entity
@Table(name = "CIRCUIT_XREF", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class CircuitXref implements Serializable {


  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class CircuitXrefPK implements Serializable {

    @Column(name = "CIRCUIT_DESIGN_ID")
    private Long circuitDesignId;

    @Column(name = "CIRCUIT_XREF_SEQ")
    private Long circuitXrefSeq;
  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private CircuitXrefPK circuitXrefPK;

  @Column(name = "CIRCUIT_XREF_ECCKT")
  private String circuitXrefEcckt;

  @Column(name = "CIRCUIT_XREF_TYPE")
  private String circuitXrefType;

  @Column(name = "STATUS")
  private String status;

  @Column(name = "ACCESS_PROVIDER_SERV_CTR_CODE")
  private String accessProviderServCtrCode;

  @Column(name = "CIRCUIT_XREF_PROVIDER")
  private String circuitXrefProvider;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LOCATION_ID")
  private Long locationId;

}
