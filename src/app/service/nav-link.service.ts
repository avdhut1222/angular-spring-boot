import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NavCategory } from '../domain/nav-category';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class NavLinkService {

  constructor( private http: HttpClient) {
    this.fetchNavLinks();
  }

  fetchNavLinks(): Observable<NavCategory[]> {
    return this.http.get<NavCategory[]>('assets/data/nav-links.json');
  }
}
