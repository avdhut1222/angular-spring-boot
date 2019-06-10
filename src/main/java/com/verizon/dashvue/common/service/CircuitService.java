package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.Circuit;
import com.verizon.dashvue.common.procresult.LocationQuery;
import com.verizon.dashvue.common.procresult.TopCktQueryResult;

import java.util.List;
import java.util.Map;

/**
 * @author Mankavale, Avdhut
 * Created: 3/11/2019 10:45 PM
 */
public interface CircuitService extends IOService<Circuit, Long> {
    Circuit getByCircuitDesignId(Long circuitDesignId);

    List<Circuit> getAllByCircuitDesignId(List<Long> circuitDesignIdList);

    List<TopCktQueryResult> networkLocationSearch(String cktType, String locA, String locZ, String designation, String rateCode);

    List<Circuit> getCircuitsForHierarchySearch(String ecckt, Boolean eccktExactMatch, String connectionXref
        , Boolean connXrefExactMatch, String location, Boolean locAExactMatch, String location2, Boolean locZExactMatch, List<String> circuitTypes);
}
