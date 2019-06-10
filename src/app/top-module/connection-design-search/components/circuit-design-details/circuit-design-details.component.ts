import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {ConnectionDesignService} from "../../service/connection-design.service.";
import {Observable} from "rxjs";
import {switchMap} from "rxjs/operators";
import {CircuitHierarchyLinkRendererComponent} from "./circuit-hierarchy-link-renderer/circuit-hierarchy-link-renderer.component";
import {CircuitDlrHistory} from "../../../domain/circuit-dlr-history";

@Component({
  selector: 'app-circuit-design-details',
  templateUrl: './circuit-design-details.component.html',
  styleUrls: ['./circuit-design-details.component.scss']
})
export class CircuitDesignDetailsComponent implements OnInit {
  private gridApi;
  private gridColumnApi;

  columnDefs = [
    {
      headerName: 'Circuit Id',
      field: 'ecckt',
      cellRendererFramework: CircuitHierarchyLinkRendererComponent
    },
    {headerName: 'Issue Number', field: 'issueNbr' },
    {headerName: 'Status', field: 'issueStatusText'},
    {headerName: 'Document Number', field: 'orderNbr'}
  ];

  rowData: CircuitDlrHistory[];

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

    this.route.paramMap.pipe(
      switchMap((params: ParamMap): Observable<CircuitDlrHistory[]> => {
        return this.connectionDesignService.fetchConnectionHistory(params.get('circuitDesignId'));
      })
    ).subscribe((resp: CircuitDlrHistory[]) => this.rowData = resp);

  }
}
