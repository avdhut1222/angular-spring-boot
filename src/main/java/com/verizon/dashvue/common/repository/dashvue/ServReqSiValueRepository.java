package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.ServReqSi;
import com.verizon.dashvue.common.domain.dashvue.ServReqSiValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/6/2019 5:03 PM
 */
public interface ServReqSiValueRepository extends JpaRepository<ServReqSiValue, ServReqSiValue.ServReqSiValuePK> {

  @Query("select srsiv from ServReqSiValue srsiv where srsiv.servReqSiValuePK.documentNumber = :documentNumber " +
    "and srsiv.validValue = :validValue and srsiv.servReqSiValuePK.valueLabel = :valueLabel")
  List<ServReqSiValue> getSrsiValForValue(@Param("documentNumber") Long documentNumber, @Param("validValue") String validValue, @Param("valueLabel") String valueLabel);
}
