package com.verizon.dashvue.common.service.impl;

import com.verizon.dashvue.common.domain.dashvue.Task;
import com.verizon.dashvue.common.repository.dashvue.TaskRepository;
import com.verizon.dashvue.common.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class TaskServiceImpl extends AbstractService<Task, Task.TaskPK> implements TaskService {

    @Qualifier("dashvueEntityManager")
    @Autowired
    EntityManager dashvueEntityManager;

    @Autowired
    TaskRepository taskRepository;

    @Override
    protected PagingAndSortingRepository<Task, Task.TaskPK> getRepository() {
        return taskRepository;
    }

    @Override
    public List<Task> findTasksForSR(Long docNum, List<String> statusTypes, List<String> taskTypes){
        if(CollectionUtils.isEmpty(statusTypes) && CollectionUtils.isEmpty(taskTypes)){
            return taskRepository.findByDocNum(docNum);
        } else if(CollectionUtils.isEmpty(statusTypes) && !CollectionUtils.isEmpty(taskTypes)){
            return taskRepository.findByDocNumAndTaskTypes(docNum, taskTypes);
        } else if(!CollectionUtils.isEmpty(statusTypes) && CollectionUtils.isEmpty(taskTypes)){
            return taskRepository.findByDocNumAndStatusTypes(docNum, statusTypes);
        } else {
            return taskRepository.findByDocNumTaskTypesStatusTypes(docNum, taskTypes, statusTypes);
        }
    }
}
