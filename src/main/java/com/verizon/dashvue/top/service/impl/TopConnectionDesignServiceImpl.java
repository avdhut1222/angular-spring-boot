package com.verizon.dashvue.top.service.impl;

import com.verizon.dashvue.common.domain.dashvue.*;
import com.verizon.dashvue.common.procresult.TopCktQueryResult;
import com.verizon.dashvue.common.service.*;
import com.verizon.dashvue.top.domain.*;
import com.verizon.dashvue.top.domain.EndUserLocation;
import com.verizon.dashvue.top.service.TopConnectionDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/11/2019 11:23 PM
 */
@Service
//@Transactional
public class TopConnectionDesignServiceImpl implements TopConnectionDesignService {

    @Autowired
    CircuitService circuitService;

    @Autowired
    DesignLayoutReportService designLayoutReportService;

    @Autowired
    DlrCircuitDesignLineService dlrCircuitDesignLineService;

    @Autowired
    ServReqService servReqService;

    @Autowired
    DlrNotesService dlrNotesService;

    @Autowired
    CircuitXrefService circuitXrefService;

    @Override
    public List<TopCktQueryResult> getConnectionSearchResults(ConnectionDesignSearchModel searchModel) {
        List<TopCktQueryResult> topCktQueryResults = new ArrayList<>();
        String circuitType = StringUtils.isEmpty(searchModel.getCircuitType()) ? "" : searchModel.getCircuitType();
        String locationA = StringUtils.isEmpty(searchModel.getLocationA()) ? "" : searchModel.getLocationA();
        String locationZ = StringUtils.isEmpty(searchModel.getLocationZ()) ? "" : searchModel.getLocationZ();
        String designation = StringUtils.isEmpty(searchModel.getDesignation()) ? "" : searchModel.getDesignation();
        String rateCode = StringUtils.isEmpty(searchModel.getRateCode()) ? "" : searchModel.getRateCode();
        topCktQueryResults = circuitService.networkLocationSearch(circuitType, locationA, locationZ, designation, rateCode);
        return topCktQueryResults;
    }

    @Override
    public List<CircuitDlrHistory> getCircuitInfo(Long circuitDesignId) {
        List<DesignLayoutReport> dlrHistory = designLayoutReportService.getDlrHistory(circuitDesignId);
        if (!CollectionUtils.isEmpty(dlrHistory)) {
            List<CircuitDlrHistory> circuitDlrHistories = new ArrayList<>();
            for (DesignLayoutReport designLayoutReport : dlrHistory) {
                CircuitDlrHistory circuitDlrHistory = getCDHfromDLR(designLayoutReport);
                if (null != circuitDlrHistory) {
                    circuitDlrHistories.add(circuitDlrHistory);
                }
            }
            return circuitDlrHistories;
        }
        return null;
    }

    private CircuitDlrHistory getCDHfromDLR(DesignLayoutReport designLayoutReport) {
        if (null != designLayoutReport) {
            CircuitDlrHistory circuitDlrHistory = new CircuitDlrHistory();
            circuitDlrHistory.setCircuitDesignId(designLayoutReport.getDesignLayoutReportPK().getCircuitDesignId());
            circuitDlrHistory.setIssueNbr(designLayoutReport.getDesignLayoutReportPK().getIssueNbr());
            circuitDlrHistory.setDocumentNumber(designLayoutReport.getDocumentNumber());
            circuitDlrHistory.setEcckt(designLayoutReport.getEcckt());
            circuitDlrHistory.setIssueStatusText(designLayoutReport.getIssueStatusText());
            circuitDlrHistory.setOrderNbr(designLayoutReport.getOrderNbr());
            return circuitDlrHistory;
        }
        return null;
    }

    @Override
    public ConnectionDesignDetail getConnectionDesignDetail(Long circuitDesignId, Long issueNbr, Long documentNumber) {
        ConnectionDesignDetail connectionDesignDetail = new ConnectionDesignDetail();
        Circuit circuit = circuitService.getByCircuitDesignId(circuitDesignId);
        if (null != circuit) {
            connectionDesignDetail.setClrNotes(circuit.getClrNotes());
            connectionDesignDetail.setPopulated(true);
        }
        DesignLayoutReport designLayoutReport = designLayoutReportService.getById(circuitDesignId, issueNbr);
        ServReq servReq = null;
        List<Task> taskList = null;
        if (null != documentNumber) {
            servReq = servReqService.getServReqByDocNum(documentNumber);
            List<String> taskTypes = Arrays.asList("DD", "PTD", "DLRD", "CDLRD");
            taskList = servReqService.getTasks(documentNumber, null, taskTypes);
        }
        if(null != designLayoutReport) {
            connectionDesignDetail.setAdministrativeInformation(getAdministrativeInformation(designLayoutReport, servReq, taskList));
            connectionDesignDetail.setDesignInformation(getDesignInfoFromDLR(designLayoutReport));
            connectionDesignDetail.setEndUserTermination(getEUTFromDLR(designLayoutReport));
        }
        List<DlrNotes> dlrNotesList = dlrNotesService.getDlrNotesByCktDesgnIdAndIssNbr(circuitDesignId, issueNbr);
        connectionDesignDetail.setDlrNotes(getDlrNotes(dlrNotesList));
        List<DlrCircuitDesignLine> dlrCircuitDesignLines = dlrCircuitDesignLineService.getDlrCircuitDesignLines(circuitDesignId, issueNbr);
        connectionDesignDetail.setDesignLines(getDesignLines(dlrCircuitDesignLines));
        List<CircuitXref> circuitXrefList = circuitXrefService.getCktXrefByCktDesgnId(circuitDesignId);
        connectionDesignDetail.setCircuitXrefInfoList(getCircuitXrefInfo(circuitXrefList));

        return connectionDesignDetail;
    }

    private AdministrativeInformation getAdministrativeInformation(DesignLayoutReport designLayoutReport, ServReq servReq, List<Task> taskList) {
        if (null != designLayoutReport) {
            AdministrativeInformation administrativeInformation = getAdminInfoFromDlr(designLayoutReport);
            if (null != administrativeInformation && null != servReq) {
                if(null != servReq.getCustAcctInfo()) {
                    administrativeInformation.setCompanyName(servReq.getCustAcctInfo().getCompanyName());
                }
                administrativeInformation.setPon(servReq.getPon());
                if (!CollectionUtils.isEmpty(taskList)) {
                    for (Task task : taskList) {
                        switch (task.getTaskType()) {
                            case "DD":
                                administrativeInformation.setDdTask(task.getActualCompletionDate().toString());
                                break;
                            case "PTD":
                                administrativeInformation.setPtdTask(task.getActualCompletionDate().toString());
                                break;
                            case "DLRD":
                                administrativeInformation.setDlrdTask(task.getActualCompletionDate().toString());
                                break;
                            case "CDLRD":
                                administrativeInformation.setCdlrdTask(task.getActualCompletionDate().toString());
                                break;
                        }
                    }
                }
            }
            return administrativeInformation;
        }
        return null;
    }

    private AdministrativeInformation getAdminInfoFromDlr(DesignLayoutReport designLayoutReport) {
        AdministrativeInformation administrativeInformation = new AdministrativeInformation();
        administrativeInformation.setVersion(designLayoutReport.getVersion());
        administrativeInformation.setEcInitiatedActivityInd(designLayoutReport.getEcInitiatedActivityInd());
        administrativeInformation.setIcCircuitReference(designLayoutReport.getIcCircuitReference());
        administrativeInformation.setIssueNumber(designLayoutReport.getDesignLayoutReportPK().getIssueNbr());
        administrativeInformation.setIssueStatusText(designLayoutReport.getIssueStatusText());
        administrativeInformation.setEcCompanyCode(designLayoutReport.getEcCompanyCode());
        administrativeInformation.setOrderNumber(designLayoutReport.getOrderNbr());
        administrativeInformation.setReferenceNumber(designLayoutReport.getReferenceNumber());
        administrativeInformation.setEcCircuit(designLayoutReport.getEcckt());
        administrativeInformation.setTwoSixCode(designLayoutReport.getTwoSixCode());
        administrativeInformation.setTrunkGroupId(designLayoutReport.getTrunkGroupId());
        administrativeInformation.setCircuitLayoutOrderNumber(designLayoutReport.getCircuitLayoutOrderNbr());
        administrativeInformation.setTelecomServicePriority(designLayoutReport.getTelecomServicePriority());
        administrativeInformation.setDesignEngineeringContact(designLayoutReport.getDesignEngineeringContact());
        administrativeInformation.setDesignContactTelephoneNumber(designLayoutReport.getDesignContactTelephoneNbr());
        administrativeInformation.setEcMaintenanceControlOffice(designLayoutReport.getEcMaintenanceControlOffice());
        administrativeInformation.setEcOperationsControlOffice(designLayoutReport.getEcOperationsControlOffice());
        administrativeInformation.setEcDesignerContact(designLayoutReport.getEcDesignerContact());
        administrativeInformation.setEcTelephoneNumber(designLayoutReport.getEcTelephoneNbr());
        administrativeInformation.setRemarksLine1(designLayoutReport.getRemarksLine1());
        administrativeInformation.setRemarksLine2(designLayoutReport.getRemarksLine2());
        administrativeInformation.setRemarksLine3(designLayoutReport.getRemarksLine3());
        return administrativeInformation;
    }

    private DesignInformation getDesignInfoFromDLR(DesignLayoutReport designLayoutReport){
        DesignInformation designInformation = new DesignInformation();
        designInformation.setAccessCustTerminalLocation(designLayoutReport.getAccessCustTerminalLocation());
        designInformation.setLinkType(designLayoutReport.getLinkType());
        designInformation.setAdditionalPointOfTermination(designLayoutReport.getAdditionalPointOfTerminatio());
        designInformation.setSignallingLinkCode(designLayoutReport.getSignallingLinkCode());
        designInformation.setTrunkCircuitIdCode(designLayoutReport.getTrunkCktIdCode());
        designInformation.setCircuitBridgingLocation(designLayoutReport.getCircuitBridgingLocation());
        designInformation.setCustomerSignallingPointCode(designLayoutReport.getCustomerSignallingPointCode());
        designInformation.setPrimaryLocation(designLayoutReport.getPrimaryLocation());
        designInformation.setSecondaryPointOfTermPriloc(designLayoutReport.getSecondaryPointOfTermPriloc());
        designInformation.setEcSignalingPointCode(designLayoutReport.getEcSignalingPointCode());
        designInformation.setSecondaryLocation(designLayoutReport.getSecondaryLocation());
        designInformation.setSecondaryPointOfTermSecloc(designLayoutReport.getSecondaryPointOfTermSecloc());
        designInformation.setNetworkChannelCode(designLayoutReport.getNetworkChannelCode());
        designInformation.setNetworkChannelOptionCode(designLayoutReport.getNetworkChannelOptionCode());
        designInformation.setNetworkChannelInterfaceCode(designLayoutReport.getNetworkChannelInterfaceCode());
        designInformation.setTransmissionLevelPoint(designLayoutReport.getTransmissionLevelPoint());
        designInformation.setMachineInterfaceCode(designLayoutReport.getMachineInterfaceCode());
        designInformation.setConnectingFacilityAssignment(designLayoutReport.getAccessCustTerminalLocation());
        designInformation.setSecNetworkChannelInterface(designLayoutReport.getSecNetworkChannelInterface());
        designInformation.setSecondaryTransmitLevelPoint(designLayoutReport.getSecondaryTransmitLevelPoint());
        return designInformation;
    }

    private EndUserTermination getEUTFromDLR(DesignLayoutReport dlr){
        EndUserTermination eut = new EndUserTermination();

        EndUserLocation priLoc = new EndUserLocation();
        priLoc.setEndUserStreetAddress(dlr.getPrilocEndUserStreetAddress());
        priLoc.setBldg(dlr.getPrilocBuilding());
        priLoc.setFloor(dlr.getPrilocFloor());
        priLoc.setRoom(dlr.getPrilocRoom());
        priLoc.setCity(dlr.getPrilocCity());
        priLoc.setState(dlr.getPrilocState());
        priLoc.setAccessTelNbr(dlr.getPrilocAccessTelNumber());
        priLoc.setEndUserTermination(dlr.getPrilocEndUserTermination());
        priLoc.setEndUserReceiveLevel(dlr.getPrilocEndUserReceiveLevel());
        priLoc.setEndUserTransmitLevel(dlr.getPrilocEndUserTransmitLevel());
        priLoc.setEndUserTermination4w(dlr.getPrilocEndUserTermination4W());
        priLoc.setEndUserTransmit4w(dlr.getPrilocEndUserTransmit4W());
        eut.setPrimaryLocation(priLoc);

        EndUserLocation secLoc = new EndUserLocation();
        secLoc.setEndUserStreetAddress(dlr.getPrilocEndUserStreetAddress());
        secLoc.setBldg(dlr.getSeclocBuilding());
        secLoc.setFloor(dlr.getSeclocFloor());
        secLoc.setRoom(dlr.getSeclocRoom());
        secLoc.setCity(dlr.getSeclocCity());
        secLoc.setState(dlr.getSeclocState());
        secLoc.setAccessTelNbr(dlr.getSeclocAccessTelNumber());
        secLoc.setEndUserTermination(dlr.getSeclocEndUserTermination());
        secLoc.setEndUserReceiveLevel(dlr.getSeclocEndUserReceiveLevel());
        secLoc.setEndUserTransmitLevel(dlr.getSeclocEndUserTransmitLevel());
        secLoc.setEndUserTermination4w(dlr.getSeclocEndUserTermination4W());
        eut.setSecondaryLocation(secLoc);

        return eut;
    }

    private List<DlrNote> getDlrNotes(List<DlrNotes> dlrNotesList){
        if(!CollectionUtils.isEmpty(dlrNotesList)) {
            List<DlrNote> noteList = new ArrayList<>();
            for (DlrNotes dlrNotes : dlrNotesList) {
                DlrNote note = new DlrNote();
                note.setNoteInd(dlrNotes.getDlrNotesPK().getNoteInd());
                note.setDlrNotesText(dlrNotes.getDlrNotesText());
                noteList.add(note);
            }
            return noteList;
        }
        return null;
    }

    private List<DesignLine> getDesignLines(List<DlrCircuitDesignLine> dlrCircuitDesignLines){
        if(!CollectionUtils.isEmpty(dlrCircuitDesignLines)){
            List<DesignLine> designLines = new ArrayList<>();
            for(DlrCircuitDesignLine line : dlrCircuitDesignLines){
                DesignLine designLine = new DesignLine();
                designLine.setRowSequenceNumber(line.getRowSequenceNbr());
                designLine.setNoteInd(line.getNoteInd());
                designLine.setLocation(line.getLocation());
                designLine.setEquipmentTypeFacilityDesign(line.getEquipmentTypeFacilityDesig());
                designLine.setRelayRackFacilityType(line.getRelayRackFacilityType());
                designLine.setUnitChannel(line.getUnitChannel());
                designLine.setSignalVoicePathType(line.getSignalVoicePathType());
                designLine.setZToATlp(line.getZToATlp());
                designLine.setAToZTlp(line.getAToZTlp());
                designLine.setIncrementalMileage(line.getIncrementalMileage());
                designLine.setMiscellaneousInformation(line.getMiscellaneousInformation());
                designLines.add(designLine);
            }
            return designLines;
        }
        return null;
    }

    private List<CircuitXrefInfo> getCircuitXrefInfo(List<CircuitXref> circuitXrefList){
        if(!CollectionUtils.isEmpty(circuitXrefList)){
            List<CircuitXrefInfo> circuitXrefInfoList = new ArrayList<>();
            for(CircuitXref xref : circuitXrefList){
                CircuitXrefInfo xrefInfo = new CircuitXrefInfo();
                xrefInfo.setCircuitXrefEcckt(xref.getCircuitXrefEcckt());
                xrefInfo.setCircuitXrefProvider(xref.getCircuitXrefProvider());
                circuitXrefInfoList.add(xrefInfo);
            }
            return circuitXrefInfoList;
        }
        return null;
    }
}
