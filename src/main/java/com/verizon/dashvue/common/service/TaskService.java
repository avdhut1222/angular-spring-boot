package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.Task;

import java.util.List;

public interface TaskService extends IOService<Task, Task.TaskPK> {
    List<Task> findTasksForSR(Long docNum, List<String> statusTypes, List<String> taskTypes);
}
