package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.Circuit;
import com.verizon.dashvue.common.domain.dashvue.CircuitXref;
import com.verizon.dashvue.common.domain.dashvue.NetworkLocation;
import com.verizon.dashvue.common.procresult.TopCktQueryResult;
import com.verizon.dashvue.common.repository.dashvue.CircuitRepository;
import com.verizon.dashvue.common.repository.dashvue.CircuitXrefRepository;
import com.verizon.dashvue.common.repository.dashvue.NetworkLocationRepository;
import com.verizon.dashvue.common.service.CircuitService;
import com.verizon.dashvue.util.DashvueUtils;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mankavale, Avdhut
 * Created: 3/11/2019 10:46 PM
 */
@Service
//@Transactional
public class CircuitServiceImpl extends AbstractService<Circuit, Long> implements CircuitService {

    @Autowired
    CircuitRepository circuitRepository;

    @Qualifier("dashvueEntityManager")
    @Autowired
    EntityManager dashvueEntityManager;

    @Autowired
    CircuitXrefRepository circuitXrefRepository;

    @Autowired
    NetworkLocationRepository networkLocationRepository;

    @Override
    protected PagingAndSortingRepository<Circuit, Long> getRepository() {
        return circuitRepository;
    }

    @Override
    public Circuit getByCircuitDesignId(Long circuitDesignId) {
        return circuitRepository.findById(circuitDesignId).orElse(null);
    }

    @Override
    public List<Circuit> getAllByCircuitDesignId(List<Long> circuitDesignIdList){
        return circuitRepository.findCircuitsByDesignId(circuitDesignIdList);
    }

    @Override
//  @Transactional
    public List<TopCktQueryResult> networkLocationSearch(String cktType, String locA, String locZ, String designation, String rateCode) {
        List<TopCktQueryResult> topCktQueryResults = new ArrayList<>();
        StoredProcedureQuery query = this.dashvueEntityManager.createNamedStoredProcedureQuery("topCktQuery");
        query.setParameter("iCktType", cktType);
        query.setParameter("iLocA", locA);
        query.setParameter("iLocZ", locZ);
        query.setParameter("iDesgn", designation);
        query.setParameter("iRateCode", rateCode);
        try {
            List<Object[]> results = query.getResultList();
            for (Object[] obj : results) {
                if (null != obj) {
                    TopCktQueryResult topCktQueryResult = new TopCktQueryResult();
                    topCktQueryResult.setCircuitDesignId(DashvueUtils.objectToString(obj[0]));
                    topCktQueryResult.setLocationId(DashvueUtils.objectToString(obj[1]));
                    topCktQueryResult.setLocationId2(DashvueUtils.objectToString(obj[2]));
                    topCktQueryResults.add(topCktQueryResult);
                }
            }
            return topCktQueryResults;
        } catch (Exception e) {
            return null;
        } finally {
            query.unwrap(ProcedureOutputs.class).release();
        }
    }

    @Override
    public List<Circuit> getCircuitsForHierarchySearch(String ecckt, Boolean eccktExactMatch, String connectionXref
        , Boolean connXrefExactMatch, String location, Boolean locAExactMatch, String location2, Boolean locZExactMatch, List<String> circuitTypes){
//        ecckt = !StringUtils.isEmpty(ecckt) ? ecckt.toUpperCase().trim().replaceAll(" +", "%") : "%";
//        connectionXref = !StringUtils.isEmpty(connectionXref) ? connectionXref.toUpperCase().trim().replaceAll(" +", "%") : "%";
//        location = !StringUtils.isEmpty(location) ? location.toUpperCase().trim().replaceAll(" +", "%") : "%";
//        location2 = !StringUtils.isEmpty(location2) ? location2.toUpperCase().trim().replaceAll(" +", "%") : "%";
//        circuitTypes = !CollectionUtils.isEmpty(circuitTypes) ? circuitTypes : null;
        Set<Circuit> circuits = new HashSet<>();
        if(!StringUtils.isEmpty(ecckt)){
            if(eccktExactMatch){
                circuits.addAll(circuitRepository.findByEcckt(ecckt));
            }else {
                ecckt = ecckt.toUpperCase().trim().replaceAll(" +", "%");
                circuits.addAll(circuitRepository.findByEccktWildCard(ecckt));
            }
        }
        if(!StringUtils.isEmpty(connectionXref)){
            List<CircuitXref> xrefs = null;
            if(connXrefExactMatch){
                xrefs = circuitXrefRepository.findByCircuitXrefEcckt(connectionXref);
            } else {
                connectionXref = connectionXref.toUpperCase().trim().replaceAll(" +", "%");
                xrefs = circuitXrefRepository.findByCircuitXrefEccktWildCard(connectionXref);
            }
            if(!CollectionUtils.isEmpty(xrefs)) {
                List<Long> xrefCktIds = xrefs.stream()
                    .map(cx -> cx.getCircuitXrefPK().getCircuitDesignId())
                    .collect(Collectors.toList());
                circuits.addAll(circuitRepository.findCircuitsByDesignId(xrefCktIds));
            }
        }
        if(!StringUtils.isEmpty(location)){
            List<NetworkLocation> networkLocations = null;
            if(locAExactMatch){
                networkLocations = networkLocationRepository.findByClliCode(location);

            } else {
                location = location.toUpperCase().trim().replaceAll(" +", "%");
                networkLocations = networkLocationRepository.findByClliCodeWildCard(location);
            }
            if(!CollectionUtils.isEmpty(networkLocations)){
                List<Long> locationIds = networkLocations.stream()
                    .map(nl -> nl.getLocationId())
                    .collect(Collectors.toList());
                circuits.addAll(circuitRepository.findByLocationIds(locationIds));
            }
        }
        if(!StringUtils.isEmpty(location2)){
            List<NetworkLocation> networkLocation2s = null;
            if(locZExactMatch){
                networkLocation2s = networkLocationRepository.findByClliCode(location2);
            } else {
                location2 = location2.toUpperCase().trim().replaceAll(" +", "%");
                networkLocation2s = networkLocationRepository.findByClliCodeWildCard(location2);
            }
            if(!CollectionUtils.isEmpty(networkLocation2s)){
                List<Long> location2Ids = networkLocation2s.stream()
                    .map(nl -> nl.getLocationId())
                    .collect(Collectors.toList());
                circuits.addAll(circuitRepository.findByLocation2Ids(location2Ids));
            }
        }
        List<Circuit> retCktList = new ArrayList<>(circuits);
        return retCktList;
    }

}
