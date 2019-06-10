package com.verizon.dashvue.top.service.impl;

import com.verizon.dashvue.common.domain.dashvue.*;
import com.verizon.dashvue.common.domain.infostore.NotesBase;
import com.verizon.dashvue.common.procresult.*;
import com.verizon.dashvue.common.repository.dashvue.UserDataColumnRepository;
import com.verizon.dashvue.common.service.*;
import com.verizon.dashvue.top.domain.*;
import com.verizon.dashvue.top.service.PsrUdfLocatorService;
import com.verizon.dashvue.top.service.TopPsrService;
import com.verizon.dashvue.util.DashvueUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mankavale, Avdhut
 * Created: 9/26/2018 2:33 PM
 */

@Service
//@Transactional
public class TopPsrServiceImpl implements TopPsrService {

    @Autowired
    protected ServReqService servReqService;

    @Autowired
    private UserDataColumnRepository userDataColumnRepository;

    @Autowired
    PsrUdfLocatorService udfLocatorService;

    @Autowired
    ServReqContactService servReqContactService;

    @Autowired
    PsrMiscCodesService psrMiscCodesService;

    @Autowired
    NstConfigTypeSrsiService nstConfigTypeSrsiService;

    public static final Map<String, String> UDF_FIELDS = new ConcurrentHashMap<>();

    public static final String PSR_USER_DATA_TABLE = "PSR_USER_DATA";
    public static final String PSR_UDF_TYPE = "SERV_REQ";
    public static final String MISC_CODE_CAT_CONTACT = "CACONTTYP";
    public static final String VALUE_LABEL_FOR_NST_CONFIG = "Descriptive Name";

    public TopPsrServiceImpl() {
        super();
    }

    @Override
    public PsrOrderDetails getPsrOrderDetails(Long documentNumber) {
        PsrOrderDetails orderDetails = new PsrOrderDetails();
        ServReq servReq = servReqService.getServReqForPsr(documentNumber);
        if (servReq != null) {
            orderDetails = buildOrderDetailsFromServReq(servReq);
        }
        return orderDetails;
    }

    @Override
    public PsrServiceLocation getPsrServiceLocation(Long docNum) {
        List<Object[]> results = servReqService.getLineCodingFramingBySR(docNum);
        PsrServiceLocation psrServiceLocation = new PsrServiceLocation();
        for (Object[] record : results) {
            if (null != record) {
                psrServiceLocation.setLineCoding(DashvueUtils.objectToString(record[0]));
                psrServiceLocation.setFraming(DashvueUtils.objectToString(record[1]));
                break;
            }
        }
        return psrServiceLocation;
    }


    @Override
    public PsrDetails getPsrDetails(Long documentNumber) {
        try {
            PsrDetails psrDetails = new PsrDetails();
            ServReq servReq = servReqService.getServReqForPsr(documentNumber);
            if (servReq != null) {
                PsrOrderDetails orderDetails = buildOrderDetailsFromServReq(servReq);
                List<UserDefinedField> udfFields = getUdfFieldsForServReq(servReq);
                psrDetails.setOrderDetailInformation(orderDetails);
                psrDetails.setUserDefinedFields(udfFields);
                psrDetails.setContacts(servReqContactsToPsrContacts(servReq.getServReqContacts()));
                psrDetails.setPsrServiceLocation(getPsrServiceLocation(servReq.getDocumentNumber()));
                psrDetails.setChildSRs(getChildSRs(servReq));
                psrDetails.setGlobalServiceLocationProducts(getGlobalServiceLocationProducts(servReq));
                psrDetails.setTrunkGroups(getTopTrunkGroupQueryResults(servReq.getDocumentNumber()));
                psrDetails.setPicInformation(getPicInformation(servReq.getDocumentNumber()));
                psrDetails.setTnFeatures(getTnFeatures(servReq.getDocumentNumber()));
                psrDetails.setHuntGroups(getHuntGroups(servReq.getDocumentNumber()));
                psrDetails.setNotes(getPsrNotes(servReq));
                psrDetails.setSrHierarchies(getSrHierarchiesForSR(servReq));
            }
            return psrDetails;
        } catch (Exception ex) {
            return null;
        }
    }

    private List<SrHierarchyProcResult> getSrHierarchiesForSR(ServReq servReq){
        List<SrHierarchyProcResult> srHierarchyProcResults = servReqService.getSrHierarchyForSR(servReq.getDocumentNumber());
        if(!CollectionUtils.isEmpty(srHierarchyProcResults)){
            return srHierarchyProcResults;
        }
        return null;
    }

    private static final String CHILD_TYPE_ALL = "ALL";
    private static final String CHILD_TYPE_PSR = "PSR";
    private static final String CHILD_TYPE_ASR = "ASR";
    private static final String CHILD_TYPE_LSR = "LSR";
    private static final String CHILD_TYPE_ISR = "LEC";

    private ChildSR getChildSRs(ServReq servReq){
        List<TopChildSrQueryResult> childSrByQueryResult = servReqService.getChildOrders(servReq.getDocumentNumber(), CHILD_TYPE_ALL);
        if(!CollectionUtils.isEmpty(childSrByQueryResult)){
            ChildSR childSR = new ChildSR();
            List<TopChildSrQueryResult> childAsr = new ArrayList<>();
            List<TopChildSrQueryResult> childLsr = new ArrayList<>();
            List<TopChildSrQueryResult> childIsr = new ArrayList<>();
            List<TopChildSrQueryResult> childPsr = new ArrayList<>();
            List<TopChildSrQueryResult> childOther = new ArrayList<>();
            for(TopChildSrQueryResult queryResult : childSrByQueryResult){
                switch (queryResult.getTypeOfSr()){
                    case CHILD_TYPE_ASR:
                        childAsr.add(queryResult);
                        break;
                    case CHILD_TYPE_LSR:
                        childLsr.add(queryResult);
                        break;
                    case CHILD_TYPE_ISR:
                        childIsr.add(queryResult);
                        break;
                    case CHILD_TYPE_PSR:
                        childPsr.add(queryResult);
                        break;
                    default:
                        childOther.add(queryResult);
                        break;
                }
            }
            if(!CollectionUtils.isEmpty(childAsr)) childSR.setChildAsr(childAsr);
            if(!CollectionUtils.isEmpty(childLsr)) childSR.setChildLsr(childLsr);
            if(!CollectionUtils.isEmpty(childIsr)) childSR.setChildIsr(childIsr);
            if(!CollectionUtils.isEmpty(childPsr)) childSR.setChildPsr(childPsr);
            if(!CollectionUtils.isEmpty(childOther)) childSR.setChildOther(childOther);

            return childSR;
        }
        return null;
    }

    private static final String ARCHIVED_NOTES_IND_TEXT = "Notes have been archived.  Please visit:";

    private List<PsrNote> getPsrNotes(ServReq servReq){
        List<PsrNote> psrNotes = new ArrayList<>();
        List<Notes> notesList = servReqService.getNotesForSr(servReq);
        if(!CollectionUtils.isEmpty(notesList)){
            String firstLine = notesList.get(0).getNoteText();
            if(firstLine.toLowerCase().contains(ARCHIVED_NOTES_IND_TEXT.toLowerCase())){
                List<NotesBase> notesBaseList = servReqService.getArchivedNotesForSr(servReq);
                if(!CollectionUtils.isEmpty(notesBaseList)){
                    for(NotesBase notesBase : notesBaseList){
                        PsrNote psrNote = getPsrNoteFromArchivedNote(notesBase);
                        if(null != psrNote){
                            psrNotes.add(psrNote);
                        }
                    }
                }
            } else {
                    for(Notes note : notesList){
                        PsrNote psrNote = getPsrNoteFromNote(note);
                        if(null != psrNote){
                            psrNotes.add(psrNote);
                        }
                    }
            }
        }
        return psrNotes;
    }

    private PsrNote getPsrNoteFromArchivedNote(NotesBase notesBase){
        PsrNote psrNote = new PsrNote();
        psrNote.setNoteId(notesBase.getNotesId());
        psrNote.setSystemGenInd(notesBase.getSystemGenInd());
        psrNote.setCircuitNoteInd(notesBase.getCircuitNoteInd());
        psrNote.setUserId(notesBase.getUserId());
        psrNote.setDateEntered(notesBase.getDateEntered());
        psrNote.setNoteText(notesBase.getNoteText());
        return psrNote;
    }

    private PsrNote getPsrNoteFromNote(Notes note){
        PsrNote psrNote = new PsrNote();
        psrNote.setNoteId(note.getNotesId());
        psrNote.setSystemGenInd(note.getSystemGenInd());
        psrNote.setCircuitNoteInd(note.getCircuitNoteInd());
        psrNote.setUserId(note.getUserId());
        psrNote.setDateEntered(note.getDateEntered());
        psrNote.setNoteText(note.getNoteText());
        return psrNote;
    }


    private List<TnFeature> getTnFeatures(Long docNum) {
        List<TopTnFeatQueryResult> tnFeatQueryResults = servReqService.getTnFeatQueryResults(docNum);
        if (!CollectionUtils.isEmpty(tnFeatQueryResults)) {
            List<TnFeature> tnFeatures = new ArrayList<>();
            for (TopTnFeatQueryResult tnFeatQueryResult : tnFeatQueryResults) {
                TnFeature tnFeature = new TnFeature();
                tnFeature.setCircuit(tnFeatQueryResult.getTelNbr());
                tnFeature.setFeatures(tnFeatQueryResult.getFeatures());
                tnFeature.setStatus(tnFeatQueryResult.getActivityCd());
                tnFeature.setValueLabel(tnFeatQueryResult.getValueLabel());
                tnFeature.setValidValue(tnFeatQueryResult.getValidValue());

                tnFeatures.add(tnFeature);
            }
            return tnFeatures;
        }
        return null;
    }

    private List<HuntGroup> getHuntGroups(Long docNum) {
        List<TopHuntGrpQueryResult> huntGrpQueryResults = servReqService.getHuntGrpQueryResults(docNum);
        if (!CollectionUtils.isEmpty(huntGrpQueryResults)) {
            List<HuntGroup> huntGroups = new ArrayList<>();
            for (TopHuntGrpQueryResult huntGrpQueryResult : huntGrpQueryResults) {
                HuntGroup huntGroup = new HuntGroup();
                huntGroup.setHuntGroupType(huntGrpQueryResult.getHuntType());
                huntGroup.setStatus(huntGrpQueryResult.getHuntStatus());
                huntGroup.setName(huntGrpQueryResult.getHuntName());
                huntGroup.setNumber(huntGrpQueryResult.getHuntNumber());
                if (!CollectionUtils.isEmpty(huntGrpQueryResult.getHuntGroupDetails())) {
                    huntGroup.setDetails(getHuntGroupDetails(huntGrpQueryResult.getHuntGroupDetails()));
                }

                huntGroups.add(huntGroup);
            }
            return huntGroups;
        }
        return null;
    }

    private List<HuntGroupDetail> getHuntGroupDetails(List<TopHuntGrpDetailQueryResult> huntGrpDetailQueryResults) {
        if (!CollectionUtils.isEmpty(huntGrpDetailQueryResults)) {
            List<HuntGroupDetail> huntGroupDetails = new ArrayList<>();
            for (TopHuntGrpDetailQueryResult huntGrpDetailQueryResult : huntGrpDetailQueryResults) {
                HuntGroupDetail huntGroupDetail = new HuntGroupDetail();
                huntGroupDetail.setHuntFr(huntGrpDetailQueryResult.getHuntMbr());
                huntGroupDetail.setHuntTo(huntGrpDetailQueryResult.getHuntTo());
                huntGroupDetail.setActivity(huntGrpDetailQueryResult.getHuntActivity());

                huntGroupDetails.add(huntGroupDetail);
            }
            return huntGroupDetails;
        }
        return null;
    }


    private List<PicInformation> getPicInformation(Long docNum) {
        List<TopPicQueryResult> picQueryResults = servReqService.topPicQuery(docNum);
        if (!CollectionUtils.isEmpty(picQueryResults)) {
            List<PicInformation> picInformations = new ArrayList<>();
            String prevCircuit = "";
            for (TopPicQueryResult picQueryResult : picQueryResults) {
                PicInformation picInformation = new PicInformation();
                if (StringUtils.hasText(picQueryResult.getTelNbr()) && "XXX".equals(picQueryResult.getTelNbr())) {
                    picInformation.setCircuit(picQueryResult.getItemAlias());
                } else {
                    picInformation.setCircuit(picQueryResult.getTelNbr());
                }
                if (prevCircuit.equals(picInformation.getCircuit())) {
                    picInformation.setCircuit("");
                }
                picInformation.setPicType(picQueryResult.getDescription100());
                picInformation.setPic(picQueryResult.getPic());
                picInformation.setCarrierName(picQueryResult.getCustomerNameAbbreviation());
                picInformation.setFreezeInd(picQueryResult.getFreezePic());
                picInformations.add(picInformation);

                if (StringUtils.hasText(picInformation.getCircuit())) {
                    prevCircuit = picInformation.getCircuit();
                }

            }
            return picInformations;
        }
        return null;
    }

    private List<TopTrunkGroupQueryResult> getTopTrunkGroupQueryResults(Long docNum) {
        return servReqService.getTopTrunkGroupQueryResults(docNum);
    }

    @Autowired
    ServReqSiService servReqSiService;

    @Autowired
    ServItemService servItemService;

    private List<GlobalServiceLocationProduct> getGlobalServiceLocationProducts(ServReq servReq) {
        if (!CollectionUtils.isEmpty(servReq.getServReqSiList())) {
            List<GlobalServiceLocationProduct> globalServiceLocationProducts = new ArrayList<>();
            List<ServReqSi> servReqSiList = servReqService.getIncludedServReqSiList(servReq);
            List<LocationQuery> locationQueryList = servReqService.getLocationQueryResults(servReq.getDocumentNumber());
            for (ServReqSi servReqSi : servReqSiList) {
                globalServiceLocationProducts.add(getGslbpFromSrsi(servReqSi, locationQueryList));
            }
            return globalServiceLocationProducts;
        }
        return null;
    }

    private GlobalServiceLocationProduct getGslbpFromSrsi(ServReqSi servReqSi, List<LocationQuery> locationQueryList) {
        GlobalServiceLocationProduct globalServiceLocationProduct = new GlobalServiceLocationProduct();
        globalServiceLocationProduct.setItemAlias(servReqSi.getItemAlias());
        globalServiceLocationProduct.setItemAliasSuf(servReqSi.getItemAliasSuf());
        globalServiceLocationProduct.setActivityCdText(servReqSiService.getActivityCdText(servReqSi.getActivityCd()));
        globalServiceLocationProduct.setServItemDesc(servItemService.findOne(servReqSi.getServReqSiPK().getServItemId()).getServItemDesc());
        globalServiceLocationProduct.setValueLabels(getValueLabelsForGslp(servReqSi));
        if (!CollectionUtils.isEmpty(locationQueryList)) {
            List<LocationQuery> primaryLocations = new ArrayList<>();
            List<LocationQuery> secondaryLocations = new ArrayList<>();
            List<LocationQuery> orderServiceLocations = new ArrayList<>();
            for (LocationQuery locationQuery : locationQueryList) {
                if (locationQuery.getServItemId().equals(servReqSi.getServReqSiPK().getServItemId())) {
                    switch (locationQuery.getSslServLocUse()) {
                        case "PRILOC":
                            primaryLocations.add(locationQuery);
                            break;
                        case "SECLOC":
                            secondaryLocations.add(locationQuery);
                            break;
                        default:
                            if (!StringUtils.isEmpty(locationQuery.getSslServLocUse())) {
                                orderServiceLocations.add(locationQuery);
                            }
                    }
                }
            }
            if (!CollectionUtils.isEmpty(primaryLocations)) {
                globalServiceLocationProduct.setPrimaryLocations(primaryLocations);
            }
            if (!CollectionUtils.isEmpty(secondaryLocations)) {
                globalServiceLocationProduct.setSecondaryLocations(secondaryLocations);
            }
            if (!CollectionUtils.isEmpty(orderServiceLocations)) {
                globalServiceLocationProduct.setOrderServiceLocations(orderServiceLocations);
            }
        }
        return globalServiceLocationProduct;
    }

    private List<ValueLabelModel> getValueLabelsForGslp(ServReqSi servReqSi) {
        List<ValueLabelsBySrsiQuery> labels = servReqSiService.getValueLabelsBySrsiQuery(servReqSi);
        List<CaBySrsiResult> caLabels = servReqSiService.getCaBySrsiProc(servReqSi);
        List<ValueLabelModel> labelModels = new ArrayList<>();
        if (!CollectionUtils.isEmpty(labels)) {
            for (ValueLabelsBySrsiQuery label : labels) {
                labelModels.add(getVlmFromValueLabelSrsi(label));
            }
        }
        if (!CollectionUtils.isEmpty(caLabels)) {
            for (CaBySrsiResult caLabel : caLabels) {
                labelModels.add(getVlmFromCaLabelSrsi(caLabel));
            }
        }
        Circuit ckt = servReqSiService.getCircuit(servReqSi);
        if (null != ckt) {
            labelModels.add(new ValueLabelModel("RATE_CODE", ckt.getRateCode()));
        }
        if (!CollectionUtils.isEmpty(labelModels)) {
            return labelModels;
        }
        return null;
    }

    private ValueLabelModel getVlmFromCaLabelSrsi(CaBySrsiResult caLabel) {
        ValueLabelModel labelModel = new ValueLabelModel();
        labelModel.setValueLabel(caLabel.getValueLabel());
        labelModel.setValidValue(caLabel.getValidValue());
        return labelModel;
    }

    private ValueLabelModel getVlmFromValueLabelSrsi(ValueLabelsBySrsiQuery label) {
        ValueLabelModel labelModel = new ValueLabelModel();
        labelModel.setValueLabel(label.getValueLabel());
        labelModel.setValidValue(label.getValidValue());
        return labelModel;
    }


    @Override
    public List<PsrSearchResultModel> getPsrSearchResults(String searchCriteria, String searchValue) {
        List<PsrSearchResultModel> psrSearchResultModelList = new ArrayList<>();
        if (!StringUtils.isEmpty(searchCriteria) && !StringUtils.isEmpty(searchValue)) {
            searchCriteria = searchCriteria.trim();
            switch (searchCriteria) {
                case "CKT_XREF":
                    char firstChar = searchValue.charAt(0);
                    if (firstChar == '%') {
                        searchValue = searchValue.replace("%", "");
                    }
                    break;

                case "ECCKT":
                    searchValue = searchValue.replaceAll(" ", "%");
                    break;

                case "ACCT_NAME":
                    searchValue = searchValue.replaceAll(" ", "%");
                    break;

                case "TN":
                    searchValue = searchValue.replaceAll("-", "");
                    break;

                case "PNT_TO_NBR":
                    searchValue = searchValue.replaceAll("-", "");
                    break;
            }
            List<ServReq> servReqList = servReqService.getPsrSearchResults(searchCriteria.trim(), searchValue);
            if (!CollectionUtils.isEmpty(servReqList)) {
                for (ServReq servReq : servReqList) {
                    psrSearchResultModelList.add(getPsrSrchResultFromSR(servReq, searchCriteria, searchValue));
                }
            }
        }
        return psrSearchResultModelList;
    }

    private PsrSearchResultModel getPsrSrchResultFromSR(ServReq servReq, String searchCriteria, String searchValue) {
        PsrSearchResultModel psrSearchResultModel = new PsrSearchResultModel();

        psrSearchResultModel.setPsrNumber(servReq.getDocumentNumber().toString());
        psrSearchResultModel.setSuppType(servReqService.getSupplementTypeText(servReq));

        if (searchCriteria.equals("DESC_NAME") || searchCriteria.equals("SHORT_NM") || searchCriteria.equals("PROV_SYS_ID")) {
            NstConfigTypeSrsi nstConfigTypeSrsi = getNstConfigTypeSrsiForSR(servReq);
            if (!ObjectUtils.isEmpty(nstConfigTypeSrsi)) {
                psrSearchResultModel.setShortName(nstConfigTypeSrsi.getNsNmShort());
                psrSearchResultModel.setDescriptiveName(getDescriptiveName(nstConfigTypeSrsi));
                psrSearchResultModel.setProviderSystemId(nstConfigTypeSrsi.getNsProviderSysId());
            }
        } else {
            switch (searchCriteria) {
                case "LD_ONLY":
                    psrSearchResultModel.setProduct(getProductName(servReq, searchValue));
                    break;
                case "MGD_RTR":
                    psrSearchResultModel.setRpon(servReq.getRelatedPon());
                    break;
                case "NDN":
                    psrSearchResultModel.setCircuitId(getCircuitId(servReq, searchValue));
                    break;
                case "RPON":
                    psrSearchResultModel.setRpon(servReq.getRelatedPon());
                    psrSearchResultModel.setCustomer(servReq.getCustAcctInfo().getCompanyName());
                    psrSearchResultModel.setProject(servReq.getProjectIdentification());
                    psrSearchResultModel.setProvPlan(servReqService.getCurrentProvPlan(servReq));
                    break;
                case "VPN_ID_EUL":
                    psrSearchResultModel.setRpon(servReq.getRelatedPon());
                    psrSearchResultModel.setCustomer(servReq.getCustAcctInfo().getCompanyName());
                    break;
                default:
                    psrSearchResultModel.setPsrType(servReq.getRelatedPon());
            }
        }
        return psrSearchResultModel;
    }

    private String getProductName(ServReq servReq, String searchValue) {
        return servReqService.getServItemForLDOnly(servReq.getDocumentNumber(), searchValue);
    }

    private String getCircuitId(ServReq servReq, String searchValue) {
        return servReqService.getCircuitIdForNDN(servReq.getDocumentNumber(), searchValue);
    }

    private NstConfigTypeSrsi getNstConfigTypeSrsiForSR(ServReq servReq) {
        try {
            List<NstConfigTypeSrsi> nstConfigTypeSrsiList = nstConfigTypeSrsiService.getNstConfigTypeSrsiByDocNum(servReq.getDocumentNumber());
            if (!CollectionUtils.isEmpty(nstConfigTypeSrsiList)) {
                return nstConfigTypeSrsiList.get(0);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private String getDescriptiveName(NstConfigTypeSrsi nstConfigTypeSrsi) {
        try {
            List<Object> objects = nstConfigTypeSrsiService.getSpecificValueLabel(nstConfigTypeSrsi.getNstConfigTypeSrsiPK().getDocumentNumber(),
                    nstConfigTypeSrsi.getNstConfigTypeSrsiPK().getServItemId(), VALUE_LABEL_FOR_NST_CONFIG);
            for (Object object : objects) {
                // Todo
//      return object.get("VALID_VALUE");
                return "VALUE_LABEL";
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private PsrOrderDetails buildOrderDetailsFromServReq(ServReq servReq) {
        PsrOrderDetails orderDetails = new PsrOrderDetails();
        orderDetails.setOrderNumber(servReq.getDocumentNumber());
        orderDetails.setCustomerAccountNumber(servReq.getCustAcctInfo().getCustAcctNbr());
        orderDetails.setCustomerCompanyName(servReq.getCustAcctInfo().getCompanyName());
        orderDetails.setCustomerPriorityCode(servReq.getCustAcctInfo().getCustacctPriorityCd());
        orderDetails.setServiceCategoryName(servReq.getCustAcctInfo().getServiceCategoryName());
        orderDetails.setActivityIndicator(servReqService.getActivityIndText(servReq));
        orderDetails.setBtn(servReqService.getBtnText(servReq));
        orderDetails.setOrganizationName(servReq.getOrganization().getOrganizationName());
        orderDetails.setDesiredDueDate(servReq.getDesiredDueDate().toLocalDate());
        orderDetails.setOrderedBy(servReq.getServiceOrder().getFirstName());
        orderDetails.setServiceOrderDate(servReq.getServiceOrder().getServiceOrderDate().toLocalDate());
        orderDetails.setOrderedByTelNumber(servReq.getServiceOrder().getOrderedByTelNbr());
        orderDetails.setProject(servReq.getProjectIdentification());
        orderDetails.setRelatedPon(servReq.getRelatedPon());
        orderDetails.setSupplementTypeText(servReqService.getSupplementTypeText(servReq));
        orderDetails.setPon(servReq.getPon());
        if (!CollectionUtils.isEmpty(servReq.getServReqContacts())) {
            orderDetails.setContactType(servReq.getServReqContacts().get(0).getSrContactType());
            orderDetails.setTelephoneNumber(servReq.getServReqContacts().get(0).getTelNbr());
            orderDetails.setFirstName(servReq.getServReqContacts().get(0).getFirstName());
            orderDetails.setLastName(servReq.getServReqContacts().get(0).getLastName());
        }
        orderDetails.setPrimaryBilling(servReqService.getPrimaryBillingAddress(servReq));
        orderDetails.setAssignedProvPlan(servReqService.getLastProvPlan(servReq));

        return orderDetails;
    }

    private CustomerAccount getCustomerAccountInfoFromServReq(ServReq servReq) {
        CustAcct custAcct = servReq.getCustAcctInfo();
        return !ObjectUtils.isEmpty(custAcct) ? new CustomerAccount(custAcct.getCustAcctNbr(), custAcct.getCompanyName(), custAcct.getCustacctPriorityCd(), custAcct.getServiceCategoryName()) : null;
    }

    private List<UserDefinedField> getUdfFieldsForServReq(ServReq servReq) {
        List<UserDataColumn> psrColumnNames = udfLocatorService.getUserColumnDetailsByTableName(PSR_USER_DATA_TABLE);
        List<String> udfDynamicFields = new ArrayList<>();
        for (UserDataColumn column : psrColumnNames) {
            if (column.getActiveInd().equals("Y") || this.UDF_FIELDS.containsKey(column.getUserDataColumnPK().getColumnName())) {
                udfDynamicFields.add(column.getUserDataColumnPK().getColumnName());
            }
        }
        return new ArrayList<UserDefinedField>(udfLocatorService.getFieldListUDFs(PSR_UDF_TYPE, servReq.getDocumentNumber(), udfDynamicFields).values());
    }

    private List<PsrContact> servReqContactsToPsrContacts(List<ServReqContact> servReqContacts) {
        List<PsrContact> psrContacts = new ArrayList<>();
        Map<String, String> miscCodeCategoryDescMap = psrMiscCodesService.getMiscCodeCategoryDescMap(MISC_CODE_CAT_CONTACT);
        for (ServReqContact servReqContact : servReqContacts) {
            PsrContact psrContact = new PsrContact();
            psrContact.setDescription(miscCodeCategoryDescMap.get(servReqContact.getSrContactType()));
            psrContact.setTelephoneNumber(servReqContact.getTelNbr());
            psrContact.setFirstName(servReqContact.getFirstName());
            psrContact.setLastName(servReqContact.getLastName());
            psrContact.setEmailAddress(servReqContact.getEmailAddr());
            psrContacts.add(psrContact);
        }
        return psrContacts;
    }

    public static void setUdfFields() {
        UDF_FIELDS.put("AFTER_HOURS_CUT", "");
        UDF_FIELDS.put("AFTER_HOURS_CUT_INTERVAL", "");
        UDF_FIELDS.put("AGENT_CODE", "");
        UDF_FIELDS.put("CUT_FS_NEEDED", "");
        UDF_FIELDS.put("CANCELLED_REPLACED_PSR_NUM", "");
        UDF_FIELDS.put("CHANGE_SUP", "");
        UDF_FIELDS.put("CIRCUIT_TYPE", "");
        UDF_FIELDS.put("CLEC_PROVIDER", "");
        UDF_FIELDS.put("CC_RELATED_BRANCH", "");
        UDF_FIELDS.put("PSR_CONTACT_CENTER", "");
        UDF_FIELDS.put("DMARC_NRC", "");
        UDF_FIELDS.put("DUE_DATE_CATEGORY", "");
        UDF_FIELDS.put("EQUIPMENT_ADD_ON_1A", "");
        UDF_FIELDS.put("EQUIPMENT_ADD_ON_2A", "");
        UDF_FIELDS.put("EQUIPMENT_ADD_ON_3A", "");
        UDF_FIELDS.put("EXPEDITE_FEE", "");
        UDF_FIELDS.put("EQP_GTH_INSTRUCTIONS", "");
        UDF_FIELDS.put("FEDERAL", "");
        UDF_FIELDS.put("ICB_CODES_APPROVAL", "");
        UDF_FIELDS.put("INSTALL_MARKET", "");
        UDF_FIELDS.put("ISRDLY_ORDERS", "");
        UDF_FIELDS.put("LINX_CIRCUIT_MRC", "");
        UDF_FIELDS.put("LINX_CIRCUIT_NRC", "");
        UDF_FIELDS.put("LINX_CONTRACT_TERM", "");
        UDF_FIELDS.put("LINXSALESREP_CHANNELMANAGER", "");
        UDF_FIELDS.put("LOA_CFA_REQUIRED", "");
        UDF_FIELDS.put("LSR_RECEIVED", "");
        UDF_FIELDS.put("LEC_DEMARC_A", "");
        UDF_FIELDS.put("LEC_DEMARC_Z", "");
        UDF_FIELDS.put("MANDATORY_SITE_SURVEY", "");
        UDF_FIELDS.put("NAC_PRECUT", "");
        UDF_FIELDS.put("NAPT_NUMBER", "");
        UDF_FIELDS.put("NETWORK_EQUIPMENT", "");
        UDF_FIELDS.put("OUT_OFMARKET", "");
        UDF_FIELDS.put("TCSI", "");
        UDF_FIELDS.put("PM_ORDER_ROUTING", "");
        UDF_FIELDS.put("PTD_ELIGIBLE", "");
        UDF_FIELDS.put("PART_ACCT_NAME", "");
        UDF_FIELDS.put("PART_TIER", "");
        UDF_FIELDS.put("PRICING_SOURCE", "");
        UDF_FIELDS.put("PROVPLANNAME", "");
        UDF_FIELDS.put("REMOVE_CNR", "");
        UDF_FIELDS.put("RELATED_HPBX_BRANCH_PSR", "");
        UDF_FIELDS.put("SALESORDERNUMBER", "");
        UDF_FIELDS.put("SEGMENT", "");
        UDF_FIELDS.put("SERVICE_EXTENSION_INSTRUCTIONS", "");
        UDF_FIELDS.put("TAXID_LOCA", "");
        UDF_FIELDS.put("TAXID_LOCZ", "");
        UDF_FIELDS.put("TAXID_A", "");
        UDF_FIELDS.put("TAXID_B", "");
        UDF_FIELDS.put("TECHNICAL_ICB", "");
        UDF_FIELDS.put("VENDOR", "");
        UDF_FIELDS.put("VENDOR_HAND", "");
        UDF_FIELDS.put("VENDOR_ID", "");
        UDF_FIELDS.put("WORKORDERNUMBER", "");
        UDF_FIELDS.put("SITE_SURVEY_EXCEPTION_REASON", "");
        UDF_FIELDS.put("TF_OE", "");
    }

}
