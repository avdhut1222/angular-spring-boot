package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.DesignLayoutReport;
import com.verizon.dashvue.common.domain.dashvue.NstConfigTypeSrsi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * @author Mankavale, Avdhut
 * Created: 9/24/2018 2:29 PM
 */
public interface DesignLayoutReportRepository extends JpaRepository<DesignLayoutReport, DesignLayoutReport.DesignLayoutReportPK> {

    String DLR_HISTORY_QUERY = "select new DesignLayoutReport(dlr.designLayoutReportPK.circuitDesignId, dlr.designLayoutReportPK.issueNbr, dlr.documentNumber, " +
        "dlr.interexchangeCarrierName, dlr.issueDate, dlr.orderNbr, dlr.ecckt, dlr.issueStatus) " +
        "from DesignLayoutReport dlr where dlr.designLayoutReportPK.circuitDesignId = :circuitDesignId";

    @Query(DLR_HISTORY_QUERY)
    List<DesignLayoutReport> getDlrHistory(@Param("circuitDesignId") Long circuitDesignId);

    @Query("select dlr from DesignLayoutReport dlr where dlr.designLayoutReportPK.circuitDesignId = :circuitDesignId" +
        " and dlr.designLayoutReportPK.issueNbr = :issueNbr order by dlr.designLayoutReportPK.issueNbr desc")
    DesignLayoutReport getDlrDetails(@Param("circuitDesignId") Long circuitDesignId, @Param("issueNbr") Long issueNbr);


}
