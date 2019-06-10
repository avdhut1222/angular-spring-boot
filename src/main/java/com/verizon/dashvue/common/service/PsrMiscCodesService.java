package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.PsrMiscCodes;

import java.util.Map;

/**
 * @author Mankavale, Avdhut
 * Created: 10/23/2018 12:25 PM
 */
public interface PsrMiscCodesService extends IOService<PsrMiscCodes, PsrMiscCodes.PsrMiscCodesPK> {
  Map<String, String> getMiscCodeCategoryDescMap(String miscCodeCategory);
}
