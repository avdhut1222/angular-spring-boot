package com.verizon.dashvue.top.controller;

import com.verizon.dashvue.top.domain.PsrDetails;
import com.verizon.dashvue.top.domain.PsrOrderDetails;
import com.verizon.dashvue.top.domain.PsrSearchModel;
import com.verizon.dashvue.top.domain.PsrSearchResultModel;
import com.verizon.dashvue.top.service.TopPsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/top")
public class TopPsrController {

    @Autowired
    TopPsrService topPsrService;

    @RequestMapping(value = "/get-psr-details/{docNum}", method = RequestMethod.GET)
    @ResponseBody
    public PsrDetails getServReqById(@PathVariable("docNum") final Long docNum, final HttpServletResponse response) {
        try {
            return topPsrService.getPsrDetails(docNum);
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value = "/get-order-details/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PsrOrderDetails getOrderDetails(@PathVariable("id") final Long id, final HttpServletResponse response) {
        return topPsrService.getPsrOrderDetails(id);
    }

    @RequestMapping(value = "/get-psr-search-results/search-criteria/{searchCriteria}/search-value/{searchValue}", method = RequestMethod.GET)
    @ResponseBody
    public List<PsrSearchResultModel> getOrderDetails(@PathVariable("searchCriteria") final String searchCriteria, @PathVariable("searchValue") final String searchValue, final HttpServletResponse response) {
        return topPsrService.getPsrSearchResults(searchCriteria, searchValue);
    }

    @RequestMapping(value = "/get-psr-search-results", method = RequestMethod.POST)
    @ResponseBody
    public List<PsrSearchResultModel> getOrderDetails(@RequestBody PsrSearchModel searchModel, final HttpServletResponse response) {
        String searchCriteria = searchModel.getSearchCriteria();
        String searchValue = searchModel.getSearchValue();
        return topPsrService.getPsrSearchResults(searchCriteria, searchValue);
    }


//  @RequestMapping(value = "/top-pic-query/{id}", method = RequestMethod.GET)
//  @ResponseBody
//  public List<Object> topPicQuery(@PathVariable("id") final Long id, final HttpServletResponse response){
//    return topPsrService.topPicQuery(id);
//  }
}
