import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router } from '@angular/router';
import {switchMap} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {PsrLinkRendererComponent} from './psr-link-renderer/psr-link-renderer.component';
import {PsrSearchResult} from '../../../domain/psr-search-result';
import {PsrSearchService} from '../../service/psr-search.service';

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.scss']
})
export class SearchResultsComponent implements OnInit {
  private gridApi;
  private gridColumnApi;

  columnDefs = [
    {
      headerName: 'PSR Number',
      field: 'psrNumber',
      cellRendererFramework: PsrLinkRendererComponent
    },
    {headerName: 'Supplement Type', field: 'suppType' },
    {headerName: 'PSR Type', field: 'psrType'},
    {headerName: 'Short Name', field: 'shortName'},
    {headerName: 'Descriptive Name', field: 'descriptiveName'},
    {headerName: 'Provider System ID', field: 'providerSystemId'},
    {headerName: 'Product', field: 'product'},
    {headerName: 'RPON', field: 'rpon'},
    {headerName: 'Circuit ID', field: 'circuitId'},
    {headerName: 'Customer', field: 'customer'},
    {headerName: 'Project', field: 'project'},
    {headerName: 'Prov Plan', field: 'provPlan'}
  ];

  rowData: PsrSearchResult[];

  constructor( private route: ActivatedRoute,
               private router: Router,
               private psrSearchService: PsrSearchService
  ) { }

  ngOnInit() {
    // this.route.paramMap.pipe(
    //   switchMap((params: ParamMap): Observable<PsrSearchResult[]> => {
    //     return this.psrSearchService.fetchPsrSearchResults(params.get('searchCriteria'), params.get('searchValue'));
    //   })
    // ).subscribe((resp: PsrSearchResult[]) => this.rowData = resp);
  }

  onGridSizeChanged(params) {
    const networkQueryArray = ['DESC_NAME', 'SHORT_NM', 'PROV_SYS_ID'];
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
        if (networkQueryArray.includes(this.psrSearchService.psrSearchCriteria)) {
          if (column.colId === 'psrNumber' || column.colId === 'suppType' || column.colId === 'shortName'
              || column.colId === 'descriptiveName' || column.colId === 'providerSytemId') {
            columnsToShow.push(column.colId);
          } else {
            columnsToHide.push(column.colId);
          }
        }
        switch (this.psrSearchService.psrSearchCriteria) {
          case 'LD_ONLY':
            if (column.colId === 'psrNumber' || column.colId === 'suppType' || column.colId === 'product') {
              columnsToShow.push(column.colId);
            } else {
              columnsToHide.push(column.colId);
            }
            break;
          case 'MGD_RTR':
            if (column.colId === 'psrNumber' || column.colId === 'suppType' || column.colId === 'rpon') {
              columnsToShow.push(column.colId);
            } else {
              columnsToHide.push(column.colId);
            }
            break;
          case 'NDN':
            if (column.colId === 'psrNumber' || column.colId === 'suppType' || column.colId === 'circuitId') {
              columnsToShow.push(column.colId);
            } else {
              columnsToHide.push(column.colId);
            }
            break;
          case 'RPON':
            if (column.colId === 'psrNumber' || column.colId === 'suppType' || column.colId === 'rpon'
              || column.colId === 'customer' || column.colId === 'project' || column.colId === 'provPlan') {
              columnsToShow.push(column.colId);
            } else {
              columnsToHide.push(column.colId);
            }
            break;
          case 'VPN_ID_EUL':
            if (column.colId === 'psrNumber' || column.colId === 'suppType' || column.colId === 'rpon' || column.colId === 'customer') {
              columnsToShow.push(column.colId);
            } else {
              columnsToHide.push(column.colId);
            }
            break;
          default:
            if (column.colId === 'psrNumber' || column.colId === 'suppType' || column.colId === 'psrType') {
              columnsToShow.push(column.colId);
            } else {
              columnsToHide.push(column.colId);
            }
        }
      }
    }
    params.columnApi.setColumnsVisible(columnsToShow, true);
    params.columnApi.setColumnsVisible(columnsToHide, false);
    params.api.sizeColumnsToFit();
  }

  onGridReady(params) {
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;

    // this.route.paramMap.pipe(
    //   switchMap(( paramMap: ParamMap ): Observable<PsrSearchResult[]> => {
    //     return this.psrSearchService.fetchPsrSearchResults(paramMap.get('searchCriteria'), paramMap.get('criteriaValue'));
    //   })
    // ).subscribe((resp: PsrSearchResult[]) => this.rowData = resp);

    this.psrSearchService.fetchPsrSearchResults().subscribe((resp: PsrSearchResult[]) => this.rowData = resp);
  }



}
