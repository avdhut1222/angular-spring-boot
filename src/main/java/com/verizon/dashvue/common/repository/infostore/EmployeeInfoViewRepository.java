package com.verizon.dashvue.common.repository.infostore;

import com.verizon.dashvue.common.domain.infostore.EmployeeInfoView;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mankavale, Avdhut
 * Created: 9/24/2018 2:32 PM
 */
public interface EmployeeInfoViewRepository extends JpaRepository<EmployeeInfoView, String> {
}
