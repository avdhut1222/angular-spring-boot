package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.ServReqContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 10/22/2018 10:35 AM
 */
public interface ServReqContactRepository extends JpaRepository<ServReqContact, ServReqContact.ServReqContactPK> {

  @Query("select src from ServReqContact src where src.servReqContactPK.documentNumber = :docNum")
  List<ServReqContact> getServReqContactByDocNum(@Param("docNum") Long docNum);
}
