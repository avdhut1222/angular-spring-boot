import {Component, OnInit} from '@angular/core';
import {ConnectionDesignService} from "../../../service/connection-design.service.";
import {ConnectionDesignDetails} from "../../../../domain/connection-design-details";
import {DlrNote} from "../../../../domain/dlr-note";

@Component({
    selector: 'app-notes-section',
    templateUrl: './notes-section.component.html',
    styleUrls: ['./notes-section.component.scss']
})
export class NotesSectionComponent implements OnInit {

    private gridApi;
    private gridColumnApi;

    columnDefs = [
        {headerName: 'Note Ind', field: 'noteInd' },
        {headerName: 'DLR Notes Text', field: 'dlrNotesText' }
    ];

    rowData: DlrNote[];

    constructor( protected connectionDesignService: ConnectionDesignService ) { }

    ngOnInit() {}

    onGridSizeChanged(params) {
        var gridWidth = document.getElementById("grid-wrapper").offsetWidth;
        var columnsToShow = [];
        var columnsToHide = [];
        var totalColsWidth = 0;
        var allColumns = params.columnApi.getAllColumns();
        for (var i = 0; i < allColumns.length; i++) {
            let column = allColumns[i];
            totalColsWidth += column.getMinWidth();
            if (totalColsWidth > gridWidth) {
                columnsToHide.push(column.colId);
            } else {
                columnsToShow.push(column.colId);
            }
        }
        params.columnApi.setColumnsVisible(columnsToShow, true);
        params.columnApi.setColumnsVisible(columnsToHide, false);
        params.api.sizeColumnsToFit();
    }

    onGridReady(params) {
        this.gridApi = params.api;
        this.gridColumnApi = params.columnApi;

        this.rowData = this.connectionDesignService.connectionDesignDetails.dlrNotes;

        // this.route.parent.paramMap.pipe(
        //   switchMap((params: ParamMap): Observable<ConnectionDesignDetails> => {
        //     return this.connectionDesignService.fetchConnectionDesignDetails(params.get('docNum'), params.get('issueNum'));
        //   })
        // ).subscribe((resp: ConnectionDesignDetails) => this.rowData = resp.designLines);

    }

}
