import { Component, OnInit } from '@angular/core';
import {PsrSearchService} from '../../../service/psr-search.service';
import {TnFeature} from '../../../../domain/tn-feature';

@Component({
  selector: 'app-tn-features',
  templateUrl: './tn-features.component.html',
  styleUrls: ['./tn-features.component.scss']
})
export class TnFeaturesComponent implements OnInit {

  private gridApi;
  private gridColumnApi;

  columnDefs = [
    {headerName: 'Circuit', field: 'circuit' },
    {headerName: 'Features', field: 'features' },
    {headerName: 'Status', field: 'status'},
    {headerName: 'Value Label', field: 'valueLabel'},
    {headerName: 'Valid Value', field: 'validValue'}
  ];

  rowData: TnFeature[];

  constructor( private psrSearchService: PsrSearchService  ) { }

  ngOnInit() {}

  onGridSizeChanged(params) {
    const gridWidth = document.getElementById('grid-wrapper').offsetWidth;
    const columnsToShow = [];
    const columnsToHide = [];
    let totalColsWidth = 0;
    const allColumns = params.columnApi.getAllColumns();
    for (let i = 0; i < allColumns.length; i++) {
      const column = allColumns[i];
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

    // if(this.psrSearchService.psrDetails && this.psrSearchService.psrDetails.tnFeatures) {
      this.rowData = this.psrSearchService.psrDetails.tnFeatures;
    // }

  }

}
