package com.verizon.dashvue.common.procresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopHuntGrpDetailQueryResult {
    private String servItemId;
    private String lastModifiedDate;
    private String lastModifiedUserId;
    private String servItemIdHuntTo;
    private String huntMbr;
    private String huntTo;
    private String huntActivity;
    private String tnAssocItemCd;
}
