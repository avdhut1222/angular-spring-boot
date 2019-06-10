import { Component, OnInit } from '@angular/core';
import {DesignLine} from "../../../../domain/design-line";
import {ActivatedRoute, Router} from "@angular/router";
import {ConnectionDesignService} from "../../../service/connection-design.service.";
import {CircuitXrefInfo} from "../../../../domain/circuit-xref-info";

@Component({
  selector: 'app-circuit-xref-section',
  templateUrl: './circuit-xref-section.component.html',
  styleUrls: ['./circuit-xref-section.component.scss']
})
export class CircuitXrefSectionComponent implements OnInit {

    private gridApi;
    private gridColumnApi;

    columnDefs = [
        {headerName: 'Circuit Xref ECCKT', field: 'circuitXrefEcckt' },
        {headerName: 'Circuit Xref Provider', field: 'circuitXrefProvider' }
    ];

    rowData: CircuitXrefInfo[];

    constructor( private route: ActivatedRoute,
                 private router: Router,
                 private connectionDesignService: ConnectionDesignService
    ) { }

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

        this.rowData = this.connectionDesignService.connectionDesignDetails.circuitXrefInfoList;

    }

}
