package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.SrsiCaVal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/6/2019 5:03 PM
 */
public interface SrsiCaValRepository extends JpaRepository<SrsiCaVal, Long> {

  @Query("select scv from SrsiCaVal scv where scv.documentNumber = :documentNumber " +
    "and scv.caValueLabel = :caValueLabel and scv.caValue = :caValue")
  List<SrsiCaVal> findScvByCaValue(@Param("documentNumber") Long documentNumber, @Param("caValueLabel") String caValueLabel, @Param("caValue") String caValue);

}
