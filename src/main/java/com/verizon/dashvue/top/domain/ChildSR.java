package com.verizon.dashvue.top.domain;

import com.verizon.dashvue.common.procresult.TopChildSrQueryResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 10/24/2018 3:16 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChildSR {
    private List<TopChildSrQueryResult> childAsr;
    private List<TopChildSrQueryResult> childLsr;
    private List<TopChildSrQueryResult> childIsr;
    private List<TopChildSrQueryResult> childPsr;
    private List<TopChildSrQueryResult> childOther;

}
