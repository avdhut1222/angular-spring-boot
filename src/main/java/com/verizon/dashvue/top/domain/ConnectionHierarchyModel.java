package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionHierarchyModel {

    private Long circuitDesignId;
    private String circuitId;
    private String circuitType;
    private String status;
    private List<ConnectionHierarchyModel> children;
    private List<ConnectionHierarchyModel> parents;
}
