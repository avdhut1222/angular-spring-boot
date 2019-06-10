package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.UserDataColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 10/15/2018 2:16 PM
 */
public interface UserDataColumnRepository extends JpaRepository<UserDataColumn, UserDataColumn.UserDataColumnPK> {

  @Query("select udc from UserDataColumn udc where udc.userDataColumnPK.tableName = :tableName order by udc.columnOrder")
  List<UserDataColumn> getUserColumnDetailsByTableName(@Param("tableName") String tableName);

  @Query("select udc from UserDataColumn udc where udc.userDataColumnPK.columnName in :columnNames order by udc.columnOrder")
  List<UserDataColumn> getUserColumnDetailsByColumnNames(@Param("columnNames") List<String> columnNames);

}
