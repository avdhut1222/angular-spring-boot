package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.JeopardyType;
import com.verizon.dashvue.common.domain.dashvue.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mankavale, Avdhut
 * Created: 9/24/2018 2:29 PM
 */
public interface JeopardyTypeRepository extends JpaRepository<JeopardyType, JeopardyType.JeopardyTypePK> {


}
