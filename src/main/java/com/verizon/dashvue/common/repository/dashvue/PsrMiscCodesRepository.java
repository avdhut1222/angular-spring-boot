package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.PsrMiscCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 10/22/2018 1:50 PM
 */
public interface PsrMiscCodesRepository extends JpaRepository<PsrMiscCodes, PsrMiscCodes.PsrMiscCodesPK> {

  @Query("select pmc from PsrMiscCodes pmc where pmc.psrMiscCodesPK.miscellaneousCodeCategory = :miscCodeCategory")
  List<PsrMiscCodes> findAllByMiscellaneousCodeCategory(@Param("miscCodeCategory") String miscCodeCategory);
}
