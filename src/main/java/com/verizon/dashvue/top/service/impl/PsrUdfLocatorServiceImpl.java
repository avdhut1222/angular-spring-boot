package com.verizon.dashvue.top.service.impl;

import com.verizon.dashvue.common.repository.dashvue.PsrUserDataRepository;
import com.verizon.dashvue.common.repository.dashvue.UserDataCategoryValuesRepository;
import com.verizon.dashvue.common.repository.dashvue.UserDataColumnRepository;
import com.verizon.dashvue.common.domain.dashvue.PsrUserData;
import com.verizon.dashvue.common.domain.dashvue.UserDataCategoryValues;
import com.verizon.dashvue.common.domain.dashvue.UserDataColumn;
import com.verizon.dashvue.top.domain.UserDefinedField;
import com.verizon.dashvue.top.service.PsrUdfLocatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Mankavale, Avdhut
 * Created: 10/16/2018 10:55 AM
 */

@Service
//@Transactional
public class PsrUdfLocatorServiceImpl implements PsrUdfLocatorService {

  @Autowired
  UserDataColumnRepository userDataColumnRepository;

  @Autowired
  PsrUserDataRepository psrUserDataRepository;

  @Autowired
  UserDataCategoryValuesRepository userDataCategoryValuesRepository;

  public static final String COLUMN_STYLE_DROPDOWN = "DROPDOWN";
  public static final String COLUMN_STYLE_DATE = "DATE";
  public static final String FOREIGN_KEY_IND_R = "R";

  @Override
  public Map<String, UserDefinedField> getFieldListUDFs(String udfType, Long udfId, List<String> fieldList) {
    Map<String, UserDefinedField> udfList = new HashMap<>();
    if(!CollectionUtils.isEmpty(fieldList)){
      List<UserDataColumn> columnInfo = getUserColumnDetailsByColumnNames(fieldList);
      PsrUserData psrUserData = psrUserDataRepository.findById(udfId).orElse(null);
      Map<String, String> psrUserDataMap = !ObjectUtils.isEmpty(psrUserData) ? psrUserData.getPsrUserDataMap() : new HashMap<>();
      List<String> dropdownUdfList = new ArrayList<>();
      List<String> dateUdfList = new ArrayList<>();

      createUdfMap(udfList, columnInfo, dropdownUdfList, dateUdfList);

      if(!CollectionUtils.isEmpty(psrUserDataMap)){
        for(String key : psrUserDataMap.keySet()) {
          if(udfList.containsKey(key)) {
            udfList.get(key).setUdfValue(psrUserDataMap.get(key));
            udfList.get(key).setUdfDisplayValue(psrUserDataMap.get(key));
          }
        }

        setDisplayValueForDropdownUdf(udfList, dropdownUdfList);
      }
    }
    return udfList;
  }

  private void setDisplayValueForDropdownUdf(Map<String, UserDefinedField> udfList, List<String> dropdownUdfList) {
    for(String dropdown : dropdownUdfList){
      String udfValue = udfList.containsKey(dropdown) ? udfList.get(dropdown).getUdfValue() : null;
      if(StringUtils.hasText(udfValue)){
        UserDataCategoryValues userDataCategoryValues = userDataCategoryValuesRepository.findById(Long.parseLong(udfValue)).orElse(null);
        String udfDisplayValue = !ObjectUtils.isEmpty(userDataCategoryValues) ? userDataCategoryValues.getDisplayValue() : null;
        if(StringUtils.hasText(udfDisplayValue)){
          udfList.get(dropdown).setUdfDisplayValue(udfDisplayValue);
        }
      }
    }
  }

  private void createUdfMap(Map<String, UserDefinedField> udfList, List<UserDataColumn> columnInfo, List<String> dropdownUdfList, List<String> dateUdfList) {
    for(UserDataColumn userDataColumn : columnInfo){
      udfList.put(userDataColumn.getUserDataColumnPK().getColumnName(), getUdfFieldFromUdc(userDataColumn));
      if( COLUMN_STYLE_DROPDOWN.equals(userDataColumn.getColumnStyle()) && FOREIGN_KEY_IND_R.equals(userDataColumn.getForeignKeyInd()) ){
        dropdownUdfList.add( userDataColumn.getUserDataColumnPK().getColumnName() );
      }
      if( COLUMN_STYLE_DATE.equals( userDataColumn.getColumnStyle() ) ){
        dateUdfList.add( userDataColumn.getUserDataColumnPK().getColumnName() );
      }
    }
  }

  private UserDefinedField getUdfFieldFromUdc(UserDataColumn userDataColumn){
    UserDefinedField userDefinedField = new UserDefinedField();
    userDefinedField.setUdfName(userDataColumn.getUserDataColumnPK().getColumnName());
    userDefinedField.setUdfLabel(userDataColumn.getColumnLabel());
    userDefinedField.setUdfStyle(userDataColumn.getColumnStyle());
    userDefinedField.setUdfOrder(userDataColumn.getColumnOrder());
    userDefinedField.setUdfForeignKeyInd(userDataColumn.getForeignKeyInd());
    return userDefinedField;
  }

  @Override
  public List<UserDataColumn> getUserColumnDetailsByTableName(String tableName) {
    return userDataColumnRepository.getUserColumnDetailsByTableName(tableName);
  }

  @Override
  public List<UserDataColumn> getUserColumnDetailsByColumnNames(List<String> columnNames) {
    return userDataColumnRepository.getUserColumnDetailsByColumnNames(columnNames);
  }

}
