package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.ServReq;
import com.verizon.dashvue.common.domain.dashvue.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 9/24/2018 2:29 PM
 */
public interface TaskRepository extends JpaRepository<Task, Task.TaskPK> {

    @Query("select task from Task task where task.taskPK.documentNumber = :docNum")
    List<Task> findByDocNum(@Param("docNum") Long docNum);

    @Query("select task from Task task where task.taskPK.documentNumber = :docNum and task.taskStatus in :statusTypes")
    List<Task> findByDocNumAndStatusTypes(@Param("docNum") Long docNum, @Param("statusTypes") List<String> statusTypes);

    @Query("select task from Task task where task.taskPK.documentNumber = :docNum and task.taskType in :taskTypes")
    List<Task> findByDocNumAndTaskTypes(@Param("docNum") Long docNum, @Param("taskTypes") List<String> taskTypes);

    @Query("select task from Task task where task.taskPK.documentNumber = :docNum and task.taskType in :taskTypes and task.taskStatus in :statusTypes")
    List<Task> findByDocNumTaskTypesStatusTypes(@Param("docNum") Long docNum, @Param("taskTypes") List<String> taskTypes, @Param("statusTypes") List<String> statusTypes);
}
