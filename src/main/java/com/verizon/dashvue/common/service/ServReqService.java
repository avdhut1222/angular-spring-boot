package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.*;
import com.verizon.dashvue.common.domain.infostore.NotesBase;
import com.verizon.dashvue.common.procresult.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Mankavale, Avdhut
 * Created: 10/29/2018 1:17 PM
 */
public interface ServReqService extends IOService<ServReq, Long> {
    ServReq getServReqForPsr(Long documentNumber);

    ServReq getServReqByDocNum(Long documentNumber);

    String getActivityIndText(ServReq servReq);

    String getBtnText(ServReq servReq);

    String getServiceRequestStatusText(ServReq servReq);

    String getSupplementTypeText(ServReq servReq);

    String getLastProvPlan(ServReq servReq);

    String getCurrentProvPlan(ServReq servReq);

    String getPrimaryBillingAddress(ServReq servReq);

    List<Object[]> getLineCodingFramingBySR(Long docNum);

    List<TopPicQueryResult> topPicQuery(Long docNum);

    List<ServReq> getPsrSearchResults(String searchCriteria, String searchValue);

//    @Transactional
    List<Long> getDocNumsBySearchCrit(String searchCriteria, String searchValue);

    String getServItemForLDOnly(Long docNum, String searchValue);

    String getCircuitIdForNDN(Long docNum, String searchValue);
    
//    @Transactional
    List<TopChildSrQueryResult> getChildOrders(Long docNum, String childType);

//    @Transactional
    TopPartyAddressQueryResult getPartyAddress(Long docNum);

    List<ServReqSi> getIncludedServReqSiList(ServReq servReq);

    List<AssignedTelNum> getAssignedTelNum(ServReq servReq);

    List<LocationQuery> getLocationQueryResults(Long docNum);

    List<TopTrunkGroupQueryResult> getTopTrunkGroupQueryResults(Long docNum);

    List<TopTnFeatQueryResult> getTnFeatQueryResults(Long docNum);

    List<TopHuntGrpQueryResult> getHuntGrpQueryResults(Long docNum);

    List<TopHuntGrpDetailQueryResult> getHuntGrpDetailsQueryResults(Long docNum, Long huntId);

    List<Notes> getNotesForSr(ServReq servReq);

    List<NotesBase> getArchivedNotesForSr(ServReq servReq);

    List<SrHierarchyProcResult> getSrHierarchyForSR(Long docNum);

    List<Task> getTasks(Long docNum, List<String> statusTypes, List<String> taskTypes);
}
