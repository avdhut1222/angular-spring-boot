package com.verizon.dashvue.top.domain;

import com.verizon.dashvue.common.procresult.SrHierarchyProcResult;
import com.verizon.dashvue.common.procresult.TopTrunkGroupQueryResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 10/10/2018 3:56 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PsrDetails {

    private PsrOrderDetails orderDetailInformation;
    private List<UserDefinedField> userDefinedFields;
    private List<PsrContact> contacts;
    private PsrServiceLocation psrServiceLocation;
    private ChildSR childSRs;
    private List<GlobalServiceLocationProduct> globalServiceLocationProducts;
    private List<TopTrunkGroupQueryResult> trunkGroups;
    private List<PicInformation> picInformation;
    private List<TnFeature> tnFeatures;
    private List<HuntGroup> huntGroups;
    private List<PsrNote> notes;
    private List<SrHierarchyProcResult> srHierarchies;
}
