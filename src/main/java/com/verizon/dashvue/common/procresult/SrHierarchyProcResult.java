package com.verizon.dashvue.common.procresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SrHierarchyProcResult {
    private String parentSr;
    private String parentType;
    private String childSr;
    private String childType;
    private String childPon;
    private String childOrdNbr;
    private String level;
}
