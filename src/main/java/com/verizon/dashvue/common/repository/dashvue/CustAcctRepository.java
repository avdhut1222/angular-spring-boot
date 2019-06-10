package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.CustAcct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mankavale, Avdhut
 * Created: 10/29/2018 1:50 PM
 */
public interface CustAcctRepository extends JpaRepository<CustAcct, Long> {
}
