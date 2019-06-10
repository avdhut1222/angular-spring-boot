package com.verizon.dashvue.common.procresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopTrunkGroupQueryResult {

    private String twoSixCode;
    private String selectionHuntSequence;
    private String glareAction;
    private String digitsIncomingQty;
    private String startSignallingTypeIn;
    private String digitsOutpulsedQty;
    private String startSignallingTypeOut;
    private String outpulseType;

}
