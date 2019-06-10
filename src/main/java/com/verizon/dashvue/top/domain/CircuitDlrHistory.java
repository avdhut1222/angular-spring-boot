package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CircuitDlrHistory {

    private Long circuitDesignId;
    private Long issueNbr;
    private Long documentNumber;
    private String ecckt;
    private String issueStatusText;
    private String orderNbr;
}
