package com.verizon.dashvue.common.repository.dashvue;

import com.verizon.dashvue.common.domain.dashvue.Notes;
import com.verizon.dashvue.common.domain.dashvue.ServReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mankavale, Avdhut
 * Created: 9/24/2018 2:29 PM
 */
public interface NotesRepository extends JpaRepository<Notes, Long> {

  @Query("select notes from Notes notes where notes.documentNumber = :documentNumber order by notes.notesSequence")
  List<Notes> findNotesByDocumentNumber(@Param("documentNumber") Long documentNumber);

}
