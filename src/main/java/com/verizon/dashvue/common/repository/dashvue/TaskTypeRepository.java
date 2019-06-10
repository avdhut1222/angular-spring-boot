package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.TaskSequence;
import com.verizon.dashvue.common.domain.dashvue.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mankavale, Avdhut
 * Created: 9/24/2018 2:29 PM
 */
public interface TaskTypeRepository extends JpaRepository<TaskType, String> {


}
