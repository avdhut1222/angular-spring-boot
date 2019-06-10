package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionHierarchySearchModel {

    private String ecckt;
    private Boolean eccktExactMatch;
    private String connectionReference;
    private Boolean connXrefExactMatch;
    private String locationA;
    private Boolean locationAExactMatch;
    private String locationZ;
    private Boolean locationZExactMatch;
    private List<String> circuitTypes;
    private Boolean lookupChildren;
}
