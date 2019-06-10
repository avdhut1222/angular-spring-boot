package com.verizon.dashvue.common.procresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopTnFeatQueryResult {
    private String features;
    private String activityCd;
    private String telNbr;
    private String valueLabel;
    private String validValue;
    private String vAct;
}
