package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PicInformation {

    private String circuit;
    private String picType;
    private String pic;
    private String carrierName;
    private String freezeInd;

}
