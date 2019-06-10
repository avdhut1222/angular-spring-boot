import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PsrDetail} from '../../domain/psr-detail';
import {PsrSearchCriteria} from '../../domain/psr-search-criteria';
import {PsrSearchResult} from '../../domain/psr-search-result';
import {OrderDetail} from '../../domain/order-detail';
import {RequestOptions} from '@angular/http';

@Injectable()
export class PsrSearchService {

  private _psrSearchCriteria: string;
  private _psrSearchValue: string;
  psrDetails: PsrDetail;

  constructor(private http: HttpClient) {}

  get psrSearchCriteria(): string {
    return this._psrSearchCriteria;
  }

  set psrSearchCriteria(value: string) {
    this._psrSearchCriteria = value;
    sessionStorage.setItem('psrSearchCriteria', value);
  }

  get psrSearchValue(): string {
    return this._psrSearchValue;
  }

  set psrSearchValue(value: string) {
    this._psrSearchValue = value;
    sessionStorage.setItem('psrSearchValue', value);
  }

  fetchPsrDetails(documentNumber: string) {
    this.http.get<PsrDetail>('api/top/get-psr-details/' + documentNumber, {responseType: 'json'})
      .subscribe( (resp: PsrDetail) => {this.psrDetails = resp; });
  }

  // fetchPsrDetails(documentNumber: string): void{
  //   this.http.get<PsrDetail>('api/top/get-psr-details/' + documentNumber, {responseType: 'json'})
  //     .subscribe( (resp: PsrDetail) => this.psrDetails = resp );
  // }

  fetchPsrSearchCriteria(): Observable<PsrSearchCriteria[]> {
    return this.http.get<PsrSearchCriteria[]>('assets/data/psr-search-criteria.json', { responseType: 'json' });
  }

  fetchPsrSearchResults(): Observable<PsrSearchResult[]> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    const data = {
      searchCriteria: sessionStorage.getItem('psrSearchCriteria'),
      searchValue: sessionStorage.getItem('psrSearchValue')
    };
    // return this.http.get(this.url, options)
    return this.http.post<PsrSearchResult[]>('api/top/get-psr-search-results', data, httpOptions);
  }

  fetchPsrOrderDetails(documentNumber: string): Observable<OrderDetail> {
    return this.http.get<OrderDetail>('api/top/get-order-details/' + documentNumber, {responseType: 'json'});
  }

}
