package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.dashvue.AssignedTelNum;
import com.verizon.dashvue.common.domain.dashvue.Notes;
import com.verizon.dashvue.common.domain.dashvue.ServReq;
import com.verizon.dashvue.common.domain.dashvue.ServReqSi;
import com.verizon.dashvue.common.procresult.*;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 10/29/2018 1:17 PM
 */
public interface NotesService extends IOService<Notes, Long> {

    List<Notes> getNotesByDocumentNumber(Long docNum);
}
