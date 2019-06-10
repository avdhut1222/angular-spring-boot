package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.ServReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 9/24/2018 2:29 PM
 */
public interface ServReqRepository extends JpaRepository<ServReq, Long> {

  @Query("select new ServReq(sr.documentNumber, sr.typeOfSr, sr.custAcctInfo, sr.pon, sr.supplementType, sr.responsibleParty" +
      ", sr.projectIdentification, sr.serviceRequestStatus, sr.desiredDueDate, sr.expediteTri, sr.activityInd, sr.relatedPon" +
      ", sr.organization, sr.orderNumber) from ServReq sr where sr.typeOfSr = 'SO' and sr.documentNumber = :documentNumber")
  ServReq findSingleOrderDetails(@Param("documentNumber") Long documentNumber);

  @Query("select sr from ServReq sr where sr.documentNumber in :documentNumbers")
  List<ServReq> findServReqsByDocNums(List<Long> documentNumbers);

}
