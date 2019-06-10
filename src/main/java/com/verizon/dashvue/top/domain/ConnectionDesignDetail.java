package com.verizon.dashvue.top.domain;

import com.verizon.dashvue.common.domain.dashvue.ServReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionDesignDetail {

    private Boolean populated;
    private String clrNotes;
    private AdministrativeInformation administrativeInformation;
    private DesignInformation designInformation;
    private EndUserTermination endUserTermination;
    private List<DlrNote> dlrNotes;
    private List<DesignLine> designLines;
    private List<CircuitXrefInfo> circuitXrefInfoList;

//    private String designLayoutReport;
//    private String circuit;
//    private String dlrCircuitDesignLine;
//    private ServReq servReq;
}
