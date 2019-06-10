package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.Circuit;
import com.verizon.dashvue.common.domain.dashvue.TransmissionRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 3/6/2019 5:03 PM
 */
public interface TransmissionRateRepository extends JpaRepository<TransmissionRate, String> {

}
