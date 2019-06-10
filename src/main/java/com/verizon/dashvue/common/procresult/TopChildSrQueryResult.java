package com.verizon.dashvue.common.procresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


/**
 * @author Mankavale, Avdhut
 * Created: 3/11/2019 3:14 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopChildSrQueryResult {

    private Long documentNumber;
    private String typeOfSr;
    private String pon;
    private String orderNumber;
    private String ban;
    private LocalDate focDate;
    private TopPartyAddressQueryResult address;
}
