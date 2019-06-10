import { Component, OnInit } from '@angular/core';
import {PsrSearchService} from '../../../service/psr-search.service';
import {PsrNote} from '../../../../domain/psr-note';

@Component({
  selector: 'app-notes-information',
  templateUrl: './notes-information.component.html',
  styleUrls: ['./notes-information.component.scss']
})
export class NotesInformationComponent implements OnInit {

  private gridApi;
  private gridColumnApi;

  columnDefs = [
    {headerName: 'User Id', field: 'userId' },
    {headerName: 'Date Entered', field: 'dateEntered' },
    {headerName: 'Note Text', field: 'noteText'}
  ];

  rowData: PsrNote[];

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
    this.rowData = this.psrSearchService.psrDetails.notes;
    // }

  }

}
