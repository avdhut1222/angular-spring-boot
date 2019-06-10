package com.verizon.dashvue.top.service;

import com.verizon.dashvue.common.domain.dashvue.UserDataColumn;
import com.verizon.dashvue.top.domain.UserDefinedField;

import java.util.List;
import java.util.Map;

/**
 * @author Mankavale, Avdhut
 * Created: 10/16/2018 10:30 AM
 */
public interface PsrUdfLocatorService {
  Map<String, UserDefinedField> getFieldListUDFs(String udfType, Long udfId, List<String> fieldList);
  List<UserDataColumn> getUserColumnDetailsByTableName(String tableName);
  List<UserDataColumn> getUserColumnDetailsByColumnNames(List<String> columnNames);
}
