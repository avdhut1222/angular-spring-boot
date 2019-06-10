package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.ServItemRel;
import com.verizon.dashvue.common.domain.dashvue.ServReqContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 10/22/2018 10:35 AM
 */
public interface ServItemRelRepository extends JpaRepository<ServItemRel, ServItemRel.ServItemRelPK> {

  @Query("select sir from ServItemRel sir where sir.servItemRelPK.servItemId in :servItemIds and sir.servItemRelPK.servItemIdRel in :servItemIds")
  List<ServItemRel> getRootProducts(@Param("servItemIds") List<Long> servItemIds);

}
