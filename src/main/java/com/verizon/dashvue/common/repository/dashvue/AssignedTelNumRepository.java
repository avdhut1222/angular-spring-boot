package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.AssignedTelNum;
import com.verizon.dashvue.common.domain.dashvue.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/6/2019 5:03 PM
 */
public interface AssignedTelNumRepository extends JpaRepository<AssignedTelNum, Long> {

  @Query("select atn from AssignedTelNum atn where atn.documentNumber = :documentNumber and atn.servItemId in :servItemIds")
  List<AssignedTelNum> findByDocNumSerAndServItemIds(@Param("documentNumber") Long documentNumber, @Param("servItemIds") List<Long> servItemIds);

}
