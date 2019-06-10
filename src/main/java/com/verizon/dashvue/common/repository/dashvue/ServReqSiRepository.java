package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.ServReqSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/6/2019 5:03 PM
 */
public interface ServReqSiRepository extends JpaRepository<ServReqSi, ServReqSi.ServReqSiPK> {

  @Query("select srsi from ServReqSi srsi where srsi.servReqSiPK.documentNumber = :documentNumber " +
    "and srsi.servReqSiPK.servItemId in :servItemIds and srsi.specGrpId in :specGrpIds")
  List<ServReqSi> getServItemForLDOnly(@Param("documentNumber") Long documentNumber, @Param("servItemIds") List<Long> servItemId, @Param("specGrpIds") List<Long> specGrpIds);
}
