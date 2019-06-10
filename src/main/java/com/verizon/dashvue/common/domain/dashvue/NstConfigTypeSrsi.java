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
@Table(name = "NST_CONFIG_TYPE_SRSI", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
@NamedStoredProcedureQueries({
  @NamedStoredProcedureQuery(
    name = "getSpecificValueLabel",
    procedureName = "ASAP.PKG_XO_VALUE_LABELS.GET_SPECIFIC_VL",
    parameters = {
      @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "aDocNum"),
      @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "aServItem"),
      @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "aValueLabel"),
      @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "oReturnVal"),
      @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "oReturnCd"),
      @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "oResultSet"),
    }
  )
})
public class NstConfigTypeSrsi implements Serializable {

  @Embeddable
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonSerialize
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class NstConfigTypeSrsiPK implements Serializable {

    @Column(name = "SERV_ITEM_ID")
    private Long servItemId;

    @Column(name = "DOCUMENT_NUMBER")
    private Long documentNumber;
  }

  @EmbeddedId
  @EqualsAndHashCode.Include
  private NstConfigTypeSrsiPK nstConfigTypeSrsiPK;

  @Column(name = "NS_NM_SHORT")
  private String nsNmShort;

  @Column(name = "NS_NM_LONG")
  private String nsNmLong;

  @Column(name = "DESC_100")
  private String desc100;

  @Column(name = "NST_CONFIG_TYPE_ID")
  private Long nstConfigTypeId;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "NS_PROVIDER_SYS_ID")
  private String nsProviderSysId;

  @Column(name = "NS_CUSTOMER_SYS_ID")
  private String nsCustomerSysId;

}
