import { Component, OnInit } from '@angular/core';
import {PsrSearchService} from '../../../service/psr-search.service';
import {PicModel} from '../../../../domain/pic-model';

@Component({
  selector: 'app-pic-information',
  templateUrl: './pic-information.component.html',
  styleUrls: ['./pic-information.component.scss']
})
export class PicInformationComponent implements OnInit {

  private gridApi;
  private gridColumnApi;

  columnDefs = [
    {headerName: 'Circuit', field: 'circuit' },
    {headerName: 'PIC Type', field: 'picType' },
    {headerName: 'PIC', field: 'pic'},
    {headerName: 'Carrier Name', field: 'carrierName'},
    {headerName: 'Freeze Ind', field: 'freezeInd'}
  ];

  rowData: PicModel[];

  constructor( private psrSearchService: PsrSearchService ) { }

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

    this.rowData = this.psrSearchService.psrDetails.picInformation;

  }

}
