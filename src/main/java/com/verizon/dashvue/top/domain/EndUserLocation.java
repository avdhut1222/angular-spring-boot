package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EndUserLocation {

    private String endUserStreetAddress;
    private String bldg;
    private String floor;
    private String room;
    private String city;
    private String state;
    private String accessTelNbr;
    private String endUserTermination;
    private Long endUserReceiveLevel;
    private Long endUserTransmitLevel;
    private String endUserTermination4w;
    private Long endUserTransmit4w;
}
