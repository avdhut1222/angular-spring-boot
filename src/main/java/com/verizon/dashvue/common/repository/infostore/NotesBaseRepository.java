package com.verizon.dashvue.common.repository.infostore;

import com.verizon.dashvue.common.domain.infostore.NotesBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotesBaseRepository extends JpaRepository<NotesBase, Long> {

    @Query("select nb from NotesBase nb where nb.documentNumber = :documentNumber  order by nb.notesSequence")
    List<NotesBase> findNotesBaseByDocumentNumber(@Param("documentNumber") Long documentNumber);

}
