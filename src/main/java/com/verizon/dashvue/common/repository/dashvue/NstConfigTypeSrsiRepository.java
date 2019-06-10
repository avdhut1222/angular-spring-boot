package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.NstConfigTypeSrsi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * @author Mankavale, Avdhut
 * Created: 9/24/2018 2:29 PM
 */
public interface NstConfigTypeSrsiRepository extends JpaRepository<NstConfigTypeSrsi, NstConfigTypeSrsi.NstConfigTypeSrsiPK> {

  @Query("select ncts from NstConfigTypeSrsi ncts where ncts.nstConfigTypeSrsiPK.documentNumber = :documentNumber")
  List<NstConfigTypeSrsi> findNstConfigTypeSrsiByDocNum(@Param("documentNumber") Long documentNumber);


}
