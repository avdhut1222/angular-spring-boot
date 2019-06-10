package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.Circuit;
import com.verizon.dashvue.common.domain.dashvue.NsConRel;

import java.util.List;

public interface NsConRelService extends IOService<NsConRel, NsConRel.NsConRelPK> {
    List<NsConRel> getChildrenCircuits(Circuit circuit);

    List<NsConRel> getParentCircuits(Circuit circuit);
}
