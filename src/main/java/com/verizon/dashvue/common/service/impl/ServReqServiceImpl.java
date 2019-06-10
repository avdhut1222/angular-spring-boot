package com.verizon.dashvue.common.service.impl;

import com.google.common.collect.Lists;
import com.verizon.dashvue.common.domain.dashvue.*;
import com.verizon.dashvue.common.domain.infostore.NotesBase;
import com.verizon.dashvue.common.procresult.*;
import com.verizon.dashvue.common.repository.dashvue.*;
import com.verizon.dashvue.common.service.*;
import com.verizon.dashvue.util.DashvueUtils;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mankavale, Avdhut
 * Created: 10/29/2018 1:17 PM
 */

@Service
//@Transactional
public class ServReqServiceImpl extends AbstractService<ServReq, Long> implements ServReqService {

    @Qualifier("dashvueEntityManager")
    @Autowired
    EntityManager dashvueEntityManager;

    @Autowired
    ServReqRepository repository;

    @Autowired
    CustAcctService custAcctService;

    @Autowired
    ServReqSiValueRepository servReqSiValueRepository;

    @Autowired
    ServReqSiRepository servReqSiRepository;

    @Autowired
    SrsiCaValRepository srsiCaValRepository;

    @Autowired
    ServItemRepository servItemRepository;

    @Autowired
    CircuitRepository circuitRepository;

    @Autowired
    AssignedTelNumService assignedTelNumService;

    @Autowired
    ServItemService servItemService;

    @Autowired
    CircuitService circuitService;

    @Autowired
    TaskService taskService;

    @Autowired
    ServItemRelService servItemRelService;

    @Autowired
    NotesService notesService;

    @Autowired
    NotesBaseService notesBaseService;

    public static final String VALUE_LABEL_FOR_LD = "Telephone Number";
    public static final List<Long> SPEC_GRP_IDS_FOR_LD = Arrays.asList(1021L, 1385L, 1384L);
    public static final String VALUE_LABEL_FOR_NDN = "Network Data Name";

    @Override
    protected PagingAndSortingRepository<ServReq, Long> getRepository() {
        return repository;
    }

    @Override
    public ServReq getServReqForPsr(Long documentNumber) {
        return repository.findSingleOrderDetails(documentNumber);
    }

    @Override
    public ServReq getServReqByDocNum(Long documentNumber){
        return repository.findById(documentNumber).orElse(null);
    }

    @Override
    public String getActivityIndText(ServReq servReq) {
        switch (servReq.getActivityInd()) {
            case "C":
                return "Change";
            case "D":
                return "Disconnect";
            case "I":
                return "Inservice";
            case "N":
                return "New";
            default:
                return null;
        }
    }

    @Override
    public String getBtnText(ServReq servReq) {
        return (!CollectionUtils.isEmpty(servReq.getSiGroupSrsiList()) && servReq.getSiGroupSrsiList().size() > 0) ?
            servReq.getSiGroupSrsiList().get(0).getSiGroupSrsiPK().getGroupName() : null;
    }

    @Override
    public String getServiceRequestStatusText(ServReq servReq) {
        if (servReq.getServiceRequestStatus() != null) {
            int serviceRequestStatus = servReq.getServiceRequestStatus().intValue();
            switch (serviceRequestStatus) {
                case 801:
                    return "Installed";
                case 901:
                    return "Finished";
                default:
                    return (serviceRequestStatus >= 0 && serviceRequestStatus <= 800) ? "Pending" : null;
            }
        }
        return null;
    }

    @Override
    public String getSupplementTypeText(ServReq servReq) {
        if (StringUtils.hasText(servReq.getSupplementType())) {
            switch (servReq.getSupplementType()) {
                case "1":
                    return "Cancelled";
                case "2":
                    return "New Due Date";
                case "3":
                    return "UNK";
                case "4":
                    return "Correction";
                default:
                    return null;
            }
        }
        return null;
    }

    @Override
    public String getLastProvPlan(ServReq servReq) {
        if (!CollectionUtils.isEmpty(servReq.getProvPlans())) {
            return servReq.getProvPlans().get(0).getProvisioningPlan().getPlanName();
        }
        return null;
    }

    @Override
    public String getCurrentProvPlan(ServReq servReq) {
        if (!CollectionUtils.isEmpty(servReq.getProvPlans())) {
            for (ServReqProvplan servReqProvplan : servReq.getProvPlans()) {
                if (!servReqProvplan.getProvisioningPlan().getProvPlanTypeCd().equals(2L)) {
                    return servReqProvplan.getProvisioningPlan().getPlanName();
                }
            }
        }
        return null;
    }

    @Override
    public String getPrimaryBillingAddress(ServReq servReq) {
        for (CustAcctAddr addr : servReq.getCustAcctInfo().getCustomerAddresses()) {
            if (addr.getCustAcctAddrPK().getCustAddrFunctionCd().equals("PBILL")) {
                Address address = addr.getCustAcctAddrPK().getAddress();
                return (StringUtils.hasText(address.getAddrLine1()) ? address.getAddrLine1() : "") + " "
                        + (StringUtils.hasText(address.getAddrLine2()) ? address.getAddrLine2() : "") + "<br>"
                        + (StringUtils.hasText(address.getAddrLine3()) ? address.getAddrLine3() : "") + " "
                        + (StringUtils.hasText(address.getAddrLine4()) ? address.getAddrLine4() : "") + "<br>"
                        + (StringUtils.hasText(address.getAddrLine5()) ? address.getAddrLine5() : "");
            }
        }
        return null;
    }

    @Override
//  @Transactional
    public List<Object[]> getLineCodingFramingBySR(Long docNum) {
        StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("getLineCodingFramingBySR");
        query.setParameter("aDocNbr", docNum);
        try {
            List<Object[]> results = query.getResultList();
            return results;
        } catch (Exception e) {
            return null;
        } finally {
            query.unwrap(ProcedureOutputs.class).release();
        }

    }

    @Override
//  @Transactional
    public List<TopPicQueryResult> topPicQuery(Long docNum) {
        StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("topPicQuery");
        query.setParameter("iDocNbr", docNum);
        try {
            List<Object[]> results = query.getResultList();
            List<TopPicQueryResult> picQueryResults = new ArrayList<>();
            for (Object[] result : results) {
                TopPicQueryResult picQueryResult = new TopPicQueryResult();
                picQueryResult.setTrunkGroupDesignId(DashvueUtils.objectToString(result[0]));
                picQueryResult.setServItemId(DashvueUtils.objectToString(result[1]));
                picQueryResult.setTelNbr(DashvueUtils.objectToString(result[2]));
                picQueryResult.setItemAlias(DashvueUtils.objectToString(result[3]));
                picQueryResult.setDescription100(DashvueUtils.objectToString(result[4]));
                picQueryResult.setPic(DashvueUtils.objectToString(result[5]));
                picQueryResult.setCustomerNameAbbreviation(DashvueUtils.objectToString(result[6]));
                picQueryResult.setFreezePic(DashvueUtils.objectToString(result[7]));
                picQueryResult.setSortOrder(DashvueUtils.objectToString(result[8]));
                picQueryResults.add(picQueryResult);
            }
            return picQueryResults;
        } catch (Exception e) {
            return null;
        } finally {
            query.unwrap(ProcedureOutputs.class).release();
        }
    }

    @Override
    public List<ServReq> getPsrSearchResults(String searchCriteria, String searchValue) {
        List<ServReq> servReqList = new ArrayList<>();
        List<Long> docNums = getDocNumsBySearchCrit(searchCriteria, searchValue);
        if (!CollectionUtils.isEmpty(docNums)) {
            servReqList = repository.findServReqsByDocNums(docNums);
        }
        return servReqList;
    }

    @Override
//  @Transactional
    public List<Long> getDocNumsBySearchCrit(String searchCriteria, String searchValue) {
        List<Long> documentNumbers = new ArrayList<>();
        StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("topQuery");
        query.setParameter("iCriteria", searchCriteria);
        query.setParameter("iCritValue", searchValue);
        try {
            List<Object> results = query.getResultList();
            for (Object obj : results) {
                documentNumbers.add(Long.parseLong(obj.toString()));
            }
            return documentNumbers;
        } catch (Exception e) {
            return null;
        } finally {
            query.unwrap(ProcedureOutputs.class).release();
        }
    }

    @Override
    public String getServItemForLDOnly(Long docNum, String searchValue) {
        String productName = null;
        List<ServReqSiValue> servReqSiValues =
                servReqSiValueRepository.getSrsiValForValue(docNum, searchValue, VALUE_LABEL_FOR_LD);
        if (!CollectionUtils.isEmpty(servReqSiValues)) {
            List<Long> itemIds = servReqSiValues
                    .stream()
                    .map(servReqSiValue -> servReqSiValue.getServReqSiValuePK().getServItemId())
                    .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(itemIds)) {
                List<ServReqSi> servReqSiList = servReqSiRepository.getServItemForLDOnly(docNum, itemIds, SPEC_GRP_IDS_FOR_LD);
                if (!CollectionUtils.isEmpty(servReqSiList)) {
                    productName = servReqSiList.get(0).getItemAlias();
                }
            }
        }
        return productName;
    }

    @Override
    public String getCircuitIdForNDN(Long docNum, String searchValue) {
        List<SrsiCaVal> srsiCaValList = srsiCaValRepository.findScvByCaValue(docNum, VALUE_LABEL_FOR_NDN, searchValue);
        List<Circuit> circuitList1 = new ArrayList<>();
        if (!CollectionUtils.isEmpty(srsiCaValList)) {
            List<Long> servItemIds1 = srsiCaValList
                    .stream()
                    .map(srsiCaVal -> srsiCaVal.getServItemId())
                    .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(servItemIds1)) {
                circuitList1 = getCircuitsByServItems(servItemIds1);
            }
        }

        List<ServReqSiValue> servReqSiValues =
                servReqSiValueRepository.getSrsiValForValue(docNum, searchValue, VALUE_LABEL_FOR_NDN);
        List<Circuit> circuitList2 = new ArrayList<>();
        if (!CollectionUtils.isEmpty(servReqSiValues)) {
            List<Long> servItemIds2 = servReqSiValues
                    .stream()
                    .map(servReqSiValue -> servReqSiValue.getServReqSiValuePK().getServItemId())
                    .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(servItemIds2)) {
                circuitList2 = getCircuitsByServItems(servItemIds2);
            }
        }

        List<Circuit> circuitList = Stream.concat(circuitList1.stream(), circuitList2.stream())
                .collect(Collectors.toList());
        return circuitList.get(0).getExchangeCarrierCircuitId();
    }

    private List<Circuit> getCircuitsByServItems(List<Long> servItemIds) {
        List<Circuit> circuitList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(servItemIds)) {
            List<ServItem> servItemList = servItemRepository.findSiByServItemIds(servItemIds);
            if (!CollectionUtils.isEmpty(servItemList)) {
                List<Long> circuitDesignIds = servItemList.stream().map(servItem -> servItem.getCircuitDesignId())
                        .collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(circuitDesignIds)) {
                    circuitList = circuitRepository.findCircuitsByDesignId(circuitDesignIds);
                }
            }
        }
        return circuitList;
    }

    @Override
//  @Transactional
    public List<TopChildSrQueryResult> getChildOrders(Long docNum, String childType) {
        List<TopChildSrQueryResult> topChildSrQueryResults = new ArrayList<>();
        StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("topChildSrQuery");
        query.setParameter("iDocNbr", docNum);
        query.setParameter("iChildType", childType);
        try {
            List<Object[]> results = query.getResultList();
            for (Object[] obj : results) {
                if (null != obj) {
                    TopChildSrQueryResult srQueryResult = new TopChildSrQueryResult();
                    srQueryResult.setDocumentNumber(DashvueUtils.objectToLong(obj[0]));
                    srQueryResult.setTypeOfSr(DashvueUtils.objectToString(obj[1]));
                    srQueryResult.setPon(DashvueUtils.objectToString(obj[2]));
                    srQueryResult.setOrderNumber(DashvueUtils.objectToString(obj[3]));
                    srQueryResult.setBan(DashvueUtils.objectToString(obj[4]));
                    srQueryResult.setFocDate(DashvueUtils.objectToLocalDate(obj[5]));
                    if (srQueryResult.getTypeOfSr().equals("ASR") || srQueryResult.getTypeOfSr().equals("LSR")) {
                        srQueryResult.setAddress(getPartyAddress(srQueryResult.getDocumentNumber()));
                    }
                    topChildSrQueryResults.add(srQueryResult);
                }
            }
            return topChildSrQueryResults;
        } catch (Exception e) {
            return null;
        } finally {
            query.unwrap(ProcedureOutputs.class).release();
        }
    }

    @Override
//  @Transactional
    public TopPartyAddressQueryResult getPartyAddress(Long docNum) {
        TopPartyAddressQueryResult topPartyAddressQuery = new TopPartyAddressQueryResult();
        Long iLimit = 1L;
        StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("topPartyAddressQuery");
        query.setParameter("iDocNbr", docNum);
        query.setParameter("iLimit", iLimit);
        try {
            List<Object[]> results = query.getResultList();
            for (Object[] record : results) {
                if (null != record) {
                    topPartyAddressQuery.setName(DashvueUtils.objectToString(record[0]));
                    topPartyAddressQuery.setSapr(DashvueUtils.objectToString(record[1]));
                    topPartyAddressQuery.setSano(DashvueUtils.objectToString(record[2]));
                    topPartyAddressQuery.setSasf(DashvueUtils.objectToString(record[3]));
                    topPartyAddressQuery.setSasd(DashvueUtils.objectToString(record[4]));
                    topPartyAddressQuery.setSasn(DashvueUtils.objectToString(record[5]));
                    topPartyAddressQuery.setSath(DashvueUtils.objectToString(record[6]));
                    topPartyAddressQuery.setSass(DashvueUtils.objectToString(record[7]));
                    topPartyAddressQuery.setLd1(DashvueUtils.objectToString(record[8]));
                    topPartyAddressQuery.setLv1(DashvueUtils.objectToString(record[9]));
                    topPartyAddressQuery.setLd2(DashvueUtils.objectToString(record[10]));
                    topPartyAddressQuery.setLv2(DashvueUtils.objectToString(record[11]));
                    topPartyAddressQuery.setCity(DashvueUtils.objectToString(record[12]));
                    topPartyAddressQuery.setState(DashvueUtils.objectToString(record[13]));
                    topPartyAddressQuery.setZip(DashvueUtils.objectToString(record[14]));
                    break;
                }
            }
            return topPartyAddressQuery;
        } catch (Exception e) {
            return null;
        } finally {
            query.unwrap(ProcedureOutputs.class).release();
        }
    }
    
    @Override
    public List<ServReqSi> getIncludedServReqSiList(ServReq servReq) {
        List<Long> excludedServItemsIds = getAssignedTelNum(servReq)
                .stream()
                .map(assignedTelNum -> assignedTelNum.getServItemId())
                .collect(Collectors.toList());
        List<ServReqSi> servReqSiList = servReq.getServReqSiList();
//        Map<Long, ServReqSi> servReqSiMap = servReq.getServReqSiMap();
        List<Long> includedServItemsIds = servReqSiList
                .stream()
                .map(servReqSi -> servReqSi.getServReqSiPK().getServItemId())
                .collect(Collectors.toList());
        includedServItemsIds.removeAll(excludedServItemsIds);
        List<Long> prunedServItemIds = pruneServItemIds(includedServItemsIds, excludedServItemsIds);
        List<Long> productSequence = getServItemRelationships(prunedServItemIds);
        List<ServReqSi> retServReqSiList = getProductSequence(servReqSiList, productSequence);
        return retServReqSiList;
    }

    private List<Long> pruneServItemIds(List<Long> includedServItemIds, List<Long> excludedServItemIds){
        Set<Long> servItemIds = new HashSet<>();
        servItemIds.addAll(includedServItemIds);
        servItemIds.addAll(excludedServItemIds);
        return Lists.newArrayList(servItemIds);
    }

    private List<Long> getServItemRelationships(List<Long> servItemIds){
        List<ServItemRel> servItemRelList = servItemRelService.getRootProducts(servItemIds);
        if(!CollectionUtils.isEmpty(servItemRelList)){
            List<Long> globalProductArray = new ArrayList<>();
            List<Long> productArray = new ArrayList<>();
            List<ServItemRel> tempArray = new ArrayList<>();
            for(ServItemRel rel : servItemRelList){
                Long relServItemId = rel.getServItemRelPK().getServItemId();
                Long relServItemIdRel = rel.getServItemRelPK().getServItemIdRel();
                if(relServItemId.equals(relServItemIdRel)){
                    globalProductArray.add(relServItemId);
                    productArray.add(relServItemId);
                } else {
                    tempArray.add(rel);
                }
            }

            for(ServItemRel tempRel : tempArray){
                Long parentId = tempRel.getServItemRelPK().getServItemId();
                Long childId = tempRel.getServItemRelPK().getServItemIdRel();
                if(globalProductArray.contains(parentId)){
                    int globalKeyLength = globalProductArray.size();
                    int globalKeyPosition = globalProductArray.indexOf(parentId);
                    if(globalKeyPosition < (globalKeyLength - 1)){
                        int nextGlobalItem = productArray.indexOf(globalProductArray.get(globalKeyPosition + 1));
                        productArray.add(nextGlobalItem, childId);
                    } else {
                        productArray.add(childId);
                    }
                } else {
                    int insertId = productArray.indexOf(parentId);
                    productArray.add(insertId + 1, childId);
                }
            }

            return productArray;
        }
        return null;
    }

    private List<ServReqSi> getProductSequence(List<ServReqSi> servReqSiList, List<Long> productSequence)
    {
        //$productSequenceResult = $productSequence->getProductSequence($this->DOCUMENT_NUMBER);
        //$this->productSequence = $productSequenceResult;
        List<ServReqSi> retList = new ArrayList<>();
        Map<Long, ServReqSi> servReqSiMap = servReqSiList
                .stream()
                .collect(Collectors.toMap(x -> x.getServReqSiPK().getServItemId(), x -> x));
        if(!CollectionUtils.isEmpty(productSequence)){
            for(Long seq : productSequence){
                retList.add(servReqSiMap.get(seq));
            }
        }
        return retList;
    }

    @Override
    public List<AssignedTelNum> getAssignedTelNum(ServReq servReq) {
        List<AssignedTelNum> assignedTelNumList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(servReq.getServReqSiList())) {
            List<Long> servItemIds = servReq.getServReqSiList()
                    .stream()
                    .map(servReqSi -> servReqSi.getServReqSiPK().getServItemId())
                    .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(servItemIds)) {
                assignedTelNumList = assignedTelNumService.getByDocNumAndServItemIds(servReq.getDocumentNumber(), servItemIds);
            }
        }
        return assignedTelNumList;
    }

    @Override
//  @Transactional
    public List<LocationQuery> getLocationQueryResults(Long docNum) {
        StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("locationQuery");
        query.setParameter("iDocNbr", docNum);
        try {
            List<Object[]> results = query.getResultList();
            List<LocationQuery> locationQueryList = new ArrayList<>();
            for (Object[] result : results) {
                if (null != result) {
                    LocationQuery locationQuery = new LocationQuery();
                    locationQuery.setServItemId(DashvueUtils.objectToLong(result[0]));
                    locationQuery.setItemAlias(DashvueUtils.objectToString(result[1]));
                    locationQuery.setActivityCd(DashvueUtils.objectToString(result[2]));
                    locationQuery.setSslServLocUse(DashvueUtils.objectToString(result[3]));
                    locationQuery.setLocationId(DashvueUtils.objectToString(result[4]));
                    locationQuery.setLocationName(DashvueUtils.objectToString(result[5]));
                    locationQuery.setCustClli(DashvueUtils.objectToString(result[6]));
                    locationQuery.setAddrLn1(DashvueUtils.objectToString(result[7]));
                    locationQuery.setAddrLn2(DashvueUtils.objectToString(result[8]));
                    locationQuery.setAddrLn3(DashvueUtils.objectToString(result[9]));
                    locationQuery.setAddrLn4(DashvueUtils.objectToString(result[10]));
                    locationQuery.setAddrLn5(DashvueUtils.objectToString(result[11]));
                    locationQuery.setSuite(DashvueUtils.objectToString(result[12]));
                    locationQuery.setFloor(DashvueUtils.objectToString(result[13]));
                    locationQuery.setRoom(DashvueUtils.objectToString(result[14]));
                    locationQuery.setAdditionalAddressInfo(DashvueUtils.objectToString(result[15]));
                    locationQuery.setLocDescr(DashvueUtils.objectToString(result[16]));
                    locationQuery.setCustDemarc(DashvueUtils.objectToString(result[17]));
                    locationQuery.setTnSwitch(DashvueUtils.objectToString(result[18]));
                    locationQuery.setConnectingFacility(DashvueUtils.objectToString(result[19]));
                    locationQuery.setFromChanAssignment(DashvueUtils.objectToString(result[20]));
                    locationQuery.setToChanAssignment(DashvueUtils.objectToString(result[21]));
                    locationQueryList.add(locationQuery);
                }
            }
            return locationQueryList;
        } catch (Exception e) {
            return null;
        } finally {
            query.unwrap(ProcedureOutputs.class).release();
        }
    }

    @Override
    public List<TopTrunkGroupQueryResult> getTopTrunkGroupQueryResults(Long docNum) {
        StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("topTrunkGroupQuery");
        query.setParameter("iDocNbr", docNum);
        try {
            List<Object[]> results = query.getResultList();
            List<TopTrunkGroupQueryResult> trunkGroups = new ArrayList<>();
            for (Object[] result : results) {
                TopTrunkGroupQueryResult trunkGroup = new TopTrunkGroupQueryResult();
                trunkGroup.setGlareAction(DashvueUtils.objectToString(result[0]));
                trunkGroup.setTwoSixCode(DashvueUtils.objectToString(result[1]));
                trunkGroup.setSelectionHuntSequence(DashvueUtils.objectToString(result[2]));
                trunkGroup.setDigitsIncomingQty(DashvueUtils.objectToString(result[3]));
                trunkGroup.setOutpulseType(DashvueUtils.objectToString(result[4]));
                trunkGroup.setStartSignallingTypeIn(DashvueUtils.objectToString(result[5]));
                trunkGroup.setStartSignallingTypeOut(DashvueUtils.objectToString(result[6]));
                trunkGroup.setDigitsOutpulsedQty(DashvueUtils.objectToString(result[7]));
                trunkGroups.add(trunkGroup);
            }
            return trunkGroups;
        } catch (Exception e) {
            return null;
        } finally {
            query.unwrap(ProcedureOutputs.class).release();
        }
    }

    @Override
    public List<TopTnFeatQueryResult> getTnFeatQueryResults(Long docNum) {
        StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("topTnFeatQuery");
//    StoredProcedureQuery query = this.dashvueEntityManager.createStoredProcedureQuery("topTnFeatQuery", TopTnFeatQueryResult.class);
        query.setParameter("iDocNbr", docNum);
        try {
            List<Object[]> results = query.getResultList();
            List<TopTnFeatQueryResult> tnFeatures = new ArrayList<>();
//      List<TopTnFeatQueryResult> tnFeatures = Collections.checkedList(query.getResultList(), TopTnFeatQueryResult.class);

            for (Object[] result : results) {
                TopTnFeatQueryResult tnFeature = new TopTnFeatQueryResult();
                tnFeature.setFeatures(DashvueUtils.objectToString(result[0]));
                tnFeature.setActivityCd(DashvueUtils.objectToString(result[1]));
                tnFeature.setTelNbr(DashvueUtils.objectToString(result[2]));
                tnFeature.setValueLabel(DashvueUtils.objectToString(result[3]));
                tnFeature.setValidValue(DashvueUtils.objectToString(result[4]));
                tnFeature.setVAct(DashvueUtils.objectToString(result[5]));

                tnFeatures.add(tnFeature);
            }
            return tnFeatures;
        } catch (Exception e) {
            return null;
        } finally {
            query.unwrap(ProcedureOutputs.class).release();
        }
    }

    @Override
    public List<TopHuntGrpQueryResult> getHuntGrpQueryResults(Long docNum) {
        StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("topHuntGrpQuery");
        query.setParameter("iDocNbr", docNum);
        try {
            List<Object[]> results = query.getResultList();
            List<TopHuntGrpQueryResult> huntGroups = new ArrayList<>();
            for (Object[] result : results) {
                TopHuntGrpQueryResult huntGroup = new TopHuntGrpQueryResult();
                huntGroup.setSerItemId(DashvueUtils.objectToString(result[0]));
                huntGroup.setHuntType(DashvueUtils.objectToString(result[1]));
                huntGroup.setHuntNumber(DashvueUtils.objectToString(result[2]));
                huntGroup.setHuntName(DashvueUtils.objectToString(result[3]));
                huntGroup.setHuntStatus(DashvueUtils.objectToString(result[4]));
                huntGroup.setHuntId(DashvueUtils.objectToString(result[5]));
                huntGroup.setHuntTypeCd(DashvueUtils.objectToString(result[6]));
                huntGroup.setHuntGroupDetails(getHuntGrpDetailsQueryResults(docNum, DashvueUtils.objectToLong(huntGroup.getHuntId())));

                huntGroups.add(huntGroup);
            }
            return huntGroups;
        } catch (Exception e) {
            return null;
        } finally {
            query.unwrap(ProcedureOutputs.class).release();
        }
    }

    @Override
    public List<TopHuntGrpDetailQueryResult> getHuntGrpDetailsQueryResults(Long docNum, Long huntId) {
        StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("topHuntGrpDetailQuery");
        query.setParameter("iDocNbr", docNum);
        query.setParameter("iHuntId", huntId);
        try {
            List<Object[]> results = query.getResultList();
            List<TopHuntGrpDetailQueryResult> huntGroupDetails = new ArrayList<>();
            for (Object[] result : results) {
                TopHuntGrpDetailQueryResult huntGroupDetail = new TopHuntGrpDetailQueryResult();
                huntGroupDetail.setServItemId(DashvueUtils.objectToString(result[0]));
                huntGroupDetail.setLastModifiedDate(DashvueUtils.objectToString(result[1]));
                huntGroupDetail.setLastModifiedUserId(DashvueUtils.objectToString(result[2]));
                huntGroupDetail.setServItemIdHuntTo(DashvueUtils.objectToString(result[3]));
                huntGroupDetail.setHuntMbr(DashvueUtils.objectToString(result[4]));
                huntGroupDetail.setHuntTo(DashvueUtils.objectToString(result[5]));
                huntGroupDetail.setHuntActivity(DashvueUtils.objectToString(result[6]));
                huntGroupDetail.setTnAssocItemCd(DashvueUtils.objectToString(result[7]));

                huntGroupDetails.add(huntGroupDetail);
            }
            return huntGroupDetails;
        } catch (Exception e) {
            return null;
        } finally {
            query.unwrap(ProcedureOutputs.class).release();
        }
    }

    @Override
    public List<Notes> getNotesForSr(ServReq servReq){
        return notesService.getNotesByDocumentNumber(servReq.getDocumentNumber());
    }

    @Override
    public List<NotesBase> getArchivedNotesForSr(ServReq servReq){
        return notesBaseService.getNotesBaseByDocumentNumber(servReq.getDocumentNumber());
    }

    @Override
    public List<SrHierarchyProcResult> getSrHierarchyForSR(Long docNum){
        StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("getSrHierarchy");
        query.setParameter("iDocNbr", docNum);
        try {
            List<Object[]> results = query.getResultList();
            List<SrHierarchyProcResult> srHierarchyProcResults = new ArrayList<>();
            for (Object[] result : results) {
                SrHierarchyProcResult srHierarchyProcResult = new SrHierarchyProcResult();
                srHierarchyProcResult.setParentSr(DashvueUtils.objectToString(result[0]));
                srHierarchyProcResult.setParentType(DashvueUtils.objectToString(result[1]));
                srHierarchyProcResult.setChildSr(DashvueUtils.objectToString(result[2]));
                srHierarchyProcResult.setChildType(DashvueUtils.objectToString(result[3]));
                srHierarchyProcResult.setChildPon(DashvueUtils.objectToString(result[4]));
                srHierarchyProcResult.setChildOrdNbr(DashvueUtils.objectToString(result[5]));
                srHierarchyProcResult.setLevel(DashvueUtils.objectToString(result[6]));

                srHierarchyProcResults.add(srHierarchyProcResult);
            }
            return srHierarchyProcResults;
        } catch (Exception e) {
            return null;
        } finally {
            query.unwrap(ProcedureOutputs.class).release();
        }

    }

    @Override
    public List<Task> getTasks(Long docNum, List<String> statusTypes, List<String> taskTypes){
        List<Task> taskList = taskService.findTasksForSR(docNum, statusTypes, taskTypes);
        if(!CollectionUtils.isEmpty(taskList)) return taskList;
        return null;
    }

}
