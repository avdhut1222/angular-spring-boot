package com.verizon.dashvue.top.controller;

import com.verizon.dashvue.common.procresult.TopCktQueryResult;
import com.verizon.dashvue.top.domain.*;
import com.verizon.dashvue.top.service.TopConnectionDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/11/2019 11:21 PM
 */
@RestController
@RequestMapping(value = "/api/top")
public class TopConnectionDesignController {

    @Autowired
    TopConnectionDesignService topConnectionDesignService;

    @RequestMapping(value = "/get-connection-search-results", method = RequestMethod.POST)
    @ResponseBody
    public List<TopCktQueryResult> getOrderDetails(@RequestBody ConnectionDesignSearchModel searchModel, final HttpServletResponse response) {
        return topConnectionDesignService.getConnectionSearchResults(searchModel);
    }

    @RequestMapping(value = "/connection-design/circuit-info/{circuitDesignId}", method = RequestMethod.GET)
    @ResponseBody
    public List<CircuitDlrHistory> getCircuitInfo(@PathVariable("circuitDesignId") Long circuitDesignId){
        return topConnectionDesignService.getCircuitInfo(circuitDesignId);
    }

    @RequestMapping(value = "/connection-design/connection-design-detail/circuitDesignId/{circuitDesignId}/issueNbr/{issueNbr}/docNum/{documentNumber}", method = RequestMethod.GET)
    @ResponseBody
    public ConnectionDesignDetail getCircuitAllInfo(@PathVariable("circuitDesignId") Long circuitDesignId,
                                                    @PathVariable("issueNbr") Long issueNbr,
                                                    @PathVariable("documentNumber") Long documentNumber ){
        return topConnectionDesignService.getConnectionDesignDetail(circuitDesignId, issueNbr, documentNumber);
    }
}
