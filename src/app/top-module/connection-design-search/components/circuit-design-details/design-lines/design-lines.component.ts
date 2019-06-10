import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {ConnectionDesignService} from "../../../service/connection-design.service.";
import {switchMap} from "rxjs/operators";
import {Observable} from "rxjs";
import {DesignLine} from "../../../../domain/design-line";
import {ConnectionDesignDetails} from "../../../../domain/connection-design-details";

@Component({
  selector: 'app-design-lines',
  templateUrl: './design-lines.component.html',
  styleUrls: ['./design-lines.component.scss']
})
export class DesignLinesComponent implements OnInit {

  private gridApi;
  private gridColumnApi;

  columnDefs = [
    {headerName: 'Seq No', field: 'rowSequenceNumber' },
    {headerName: 'Note Ind', field: 'noteInd' },
    {headerName: 'Location', field: 'location'},
    {headerName: 'Eqpt Type / Fac Desg', field: 'equipmentTypeFacilityDesign'},
    {headerName: 'Relay Rack / Fac Type', field: 'relayRackFacilityType'},
    {headerName: 'Unit / Channel', field: 'unitChannel'},
    {headerName: 'Signal Voice Path Type', field: 'signalVoicePathType'},
    {headerName: 'Z to A', field: 'zToATlp'},
    {headerName: 'A to Z', field: 'aToZTlp'},
    {headerName: 'Incremental Mileage', field: 'incrementalMileage'},
    {headerName: 'Misc Info', field: 'miscellaneousInformation'},
  ];

  rowData: DesignLine[];

  constructor( private route: ActivatedRoute,
               private router: Router,
               private connectionDesignService: ConnectionDesignService
  ) { }

  ngOnInit() {}

  onGridSizeChanged(params) {
    var gridWidth = document.getElementById("design-lines-grid-wrapper").offsetWidth;
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

    this.rowData = this.connectionDesignService.connectionDesignDetails.designLines;

    // this.route.parent.paramMap.pipe(
    //   switchMap((params: ParamMap): Observable<ConnectionDesignDetails> => {
    //     return this.connectionDesignService.fetchConnectionDesignDetails(params.get('docNum'), params.get('issueNum'));
    //   })
    // ).subscribe((resp: ConnectionDesignDetails) => this.rowData = resp.designLines);

  }
}
