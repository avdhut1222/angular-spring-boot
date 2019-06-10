package com.verizon.dashvue.common.procresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopPicQueryResult {

    private String trunkGroupDesignId;
    private String servItemId;
    private String telNbr;
    private String itemAlias;
    private String description100;
    private String pic;
    private String customerNameAbbreviation;
    private String freezePic;
    private String sortOrder;

}
