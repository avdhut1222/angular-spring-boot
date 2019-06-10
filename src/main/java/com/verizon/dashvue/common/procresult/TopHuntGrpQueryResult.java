package com.verizon.dashvue.common.procresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopHuntGrpQueryResult {
    private String serItemId;
    private String huntType;
    private String huntNumber;
    private String huntName;
    private String huntStatus;
    private String huntId;
    private String huntTypeCd;
    private List<TopHuntGrpDetailQueryResult> huntGroupDetails;
}
