package com.verizon.dashvue.common.domain.dashvue;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sun.util.resources.ko.LocaleNames_ko;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "NETWORK_LOCATION", schema = "ASAP")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class NetworkLocation implements Serializable {

  @Id
  @Column(name = "LOCATION_ID")
  @EqualsAndHashCode.Include
  private Long locationId;

  @Column(name = "CLLI_CODE")
  private String clliCode;

  @Column(name = "LOCATION_NAME")
  private String locationName;

  @Column(name = "TELEPHONE_NUMBER")
  private String telephoneNumber;

  @Column(name = "FAX")
  private String fax;

  @Column(name = "TTY_NUMBER")
  private String ttyNumber;

  @Column(name = "TEST_PHONE_NUMBER")
  private String testPhoneNumber;

  @Column(name = "H_COORDINATE")
  private Long hCoordinate;

  @Column(name = "V_COORDINATE")
  private Long vCoordinate;

  @Column(name = "LONGITUDE")
  private String longitude;

  @Column(name = "LATITUDE")
  private String latitude;

  @Column(name = "OWNERSHIP_INDICATOR")
  private String ownershipIndicator;

  @Column(name = "SWITCHING_OFFICE_CLASS")
  private String switchingOfficeClass;

  @Column(name = "LOCATION_EFFECTIVE_DATE")
  private Date locationEffectiveDate;

  @Column(name = "REPAIR_SERVICE_DAY_NUMBER")
  private String repairServiceDayNumber;

  @Column(name = "REPAIR_SERVICE_NIGHT_NUMBER")
  private String repairServiceNightNumber;

  @Column(name = "LAST_MODIFIED_USERID")
  private String lastModifiedUserid;

  @Column(name = "LAST_MODIFIED_DATE")
  private Date lastModifiedDate;

  @Column(name = "LOC_DESCR")
  private String locDescr;

  @Column(name = "EXCHANGE_AREA_CLLI")
  private String exchangeAreaClli;

  @Column(name = "OPERATING_COMPANY_NUMBER")
  private String operatingCompanyNumber;

  @Column(name = "NETLOC_TYPE_CD")
  private String netlocTypeCd;

  @Column(name = "LAT_NBR")
  private Long latNbr;

  @Column(name = "LON_NBR")
  private Long lonNbr;

  @Column(name = "INDUSTRY_FORMAT_CD")
  private Long industryFormatCd;

  @Column(name = "TO_EFF_DT")
  private Date toEffDt;

  @Column(name = "NET_LOC_TYPE_ID")
  private Long netLocTypeId;


}
