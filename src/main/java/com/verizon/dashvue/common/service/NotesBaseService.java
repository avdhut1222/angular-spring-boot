package com.verizon.dashvue.common.service;

import com.verizon.dashvue.common.domain.infostore.NotesBase;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 10/29/2018 1:17 PM
 */
public interface NotesBaseService extends IOService<NotesBase, Long> {

    List<NotesBase> getNotesBaseByDocumentNumber(Long docNum);
}
