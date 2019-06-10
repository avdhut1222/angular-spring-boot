import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CircuitIdLinkRendererComponent} from "./circuit-id-link-renderer/circuit-id-link-renderer.component";
import {ConnectionSearchResult} from "../../../domain/connection-search-result";
import {ConnectionDesignService} from "../../service/connection-design.service.";

@Component({
  selector: 'app-connection-search-results',
  templateUrl: './connection-search-results.component.html',
  styleUrls: ['./connection-search-results.component.scss']
})
export class ConnectionSearchResultsComponent implements OnInit {
  private gridApi;
  private gridColumnApi;

  columnDefs = [
    {
      headerName: 'Circuit Id',
      field: 'circuitDesignId',
      cellRendererFramework: CircuitIdLinkRendererComponent
    },
    {headerName: 'A Location', field: 'locationId' },
    {headerName: 'Z Location', field: 'locationId2'}
  ];

  rowData: ConnectionSearchResult[];

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

    // TODO: Fetch the search parameters from the URL. The pre-requisite is having these parameters sent from the search form
    // this.route.paramMap.pipe(
    //   switchMap((params: ParamMap): Observable<ConnectionSearchResult[]> => {
    //     return this.connectionDesignService.fetchConnectionSearchResults(params.get('searchCriteria'), params.get('searchValue'));
    //   })
    // ).subscribe((resp: ConnectionSearchResult[]) => this.rowData = resp);

    this.connectionDesignService.fetchConnectionSearchResults()
      .subscribe((resp: ConnectionSearchResult[]) => this.rowData = resp );
  }

}
