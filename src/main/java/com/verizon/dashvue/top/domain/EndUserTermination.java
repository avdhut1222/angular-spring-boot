package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EndUserTermination {

    private EndUserLocation primaryLocation;
    private EndUserLocation secondaryLocation;
}
