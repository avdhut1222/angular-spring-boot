package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.NsConRel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NsConRelRepository extends JpaRepository<NsConRel, NsConRel.NsConRelPK> {

    @Query("select ncr from NsConRel ncr where ncr.nsConRelPK.circuitDesignIdParent = :circuitDesignIdParent")
    List<NsConRel> findChildrenByParentId(@Param("circuitDesignIdParent") Long circuitDesignIdParent);

    @Query("select ncr from NsConRel ncr where ncr.nsConRelPK.circuitDesignIdChild = :circuitDesignIdChild")
    List<NsConRel> findParentByChildId(@Param("circuitDesignIdChild") Long circuitDesignIdChild);
}
