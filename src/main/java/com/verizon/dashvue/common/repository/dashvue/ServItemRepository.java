package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.ServItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/6/2019 5:03 PM
 */
public interface ServItemRepository extends JpaRepository<ServItem, Long> {

  @Query("select si from ServItem si where si.servItemId in :servItemIds")
  List<ServItem> findSiByServItemIds(@Param("servItemIds") List<Long> servItemIds);

}
