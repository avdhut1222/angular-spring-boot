package com.verizon.dashvue.top.service;

import com.verizon.dashvue.top.domain.ConnectionHierarchyModel;
import com.verizon.dashvue.top.domain.ConnectionHierarchySearchModel;

import java.util.List;

public interface TopConnectionHierarchyService {
    List<ConnectionHierarchyModel> getConnectionHierarchy(ConnectionHierarchySearchModel connectionHierarchySearchModel);
}
