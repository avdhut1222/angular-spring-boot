package com.verizon.dashvue.top.controller;

import com.verizon.dashvue.top.domain.ConnectionHierarchyModel;
import com.verizon.dashvue.top.domain.ConnectionHierarchySearchModel;
import com.verizon.dashvue.top.service.TopConnectionHierarchyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/top")
public class TopConnectionHierarchyController {

    @Autowired
    TopConnectionHierarchyService connectionHierarchyService;

    @RequestMapping(value = "get-connection-hierarchy-search-results", method = RequestMethod.POST)
    @ResponseBody
    public List<ConnectionHierarchyModel> getConnectionHierarchySearchResults(
        @RequestBody ConnectionHierarchySearchModel searchModel, final HttpServletResponse response){
        return connectionHierarchyService.getConnectionHierarchy(searchModel);
    }
}
