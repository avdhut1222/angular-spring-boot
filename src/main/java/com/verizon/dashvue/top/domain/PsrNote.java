package com.verizon.dashvue.top.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PsrNote {

    private Long noteId;
    private String systemGenInd;
    private String circuitNoteInd;
    private String userId;
    private LocalDate dateEntered;
    private String noteText;
}
