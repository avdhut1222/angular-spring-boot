package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.NstConfigTypeSrsi;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/6/2019 4:11 PM
 */
public interface NstConfigTypeSrsiService extends IOService<NstConfigTypeSrsi, NstConfigTypeSrsi.NstConfigTypeSrsiPK> {
  List<NstConfigTypeSrsi> getNstConfigTypeSrsiByDocNum(Long documentNumber);

  List<Object> getSpecificValueLabel(Long documentNumber, Long servItemId, String valueLabel) throws SQLException;
}
