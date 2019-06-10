import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Observable} from "rxjs";
import {ConnectionSearchResult} from "../../domain/connection-search-result";
import {ConnectionHierarchySearchModel} from "../../domain/connection-hierarchy-search-model";
import {ConnectionHierarchyModel} from "../../domain/connection-hierarchy-model";

@Injectable({
  providedIn: 'root'
})
export class ConnectionHierarchyService {

    // private _ecckt: string;
    // private _eccktExactMatch: boolean;
    // private _connectionReference: string;
    // private _connXrefExactMatch: boolean;
    // private _locationA: string;
    // private _locationAExactMatch: boolean;
    // private _locationZ: string;
    // private _locationZExactMatch: boolean;
    // private _circuitTypes: string[];
    // private _lookupChildren: boolean;
    //
    //
    // get ecckt(): string {
    //     return this._ecckt;
    // }
    //
    // set ecckt(value: string) {
    //     this._ecckt = value;
    // }
    //
    // get eccktExactMatch(): boolean {
    //     return this._eccktExactMatch;
    // }
    //
    // set eccktExactMatch(value: boolean) {
    //     this._eccktExactMatch = value;
    // }
    //
    // get connectionReference(): string {
    //     return this._connectionReference;
    // }
    //
    // set connectionReference(value: string) {
    //     this._connectionReference = value;
    // }
    //
    // get connXrefExactMatch(): boolean {
    //     return this._connXrefExactMatch;
    // }
    //
    // set connXrefExactMatch(value: boolean) {
    //     this._connXrefExactMatch = value;
    // }
    //
    // get locationA(): string {
    //     return this._locationA;
    // }
    //
    // set locationA(value: string) {
    //     this._locationA = value;
    // }
    //
    // get locationAExactMatch(): boolean {
    //     return this._locationAExactMatch;
    // }
    //
    // set locationAExactMatch(value: boolean) {
    //     this._locationAExactMatch = value;
    // }
    //
    // get locationZ(): string {
    //     return this._locationZ;
    // }
    //
    // set locationZ(value: string) {
    //     this._locationZ = value;
    // }
    //
    // get locationZExactMatch(): boolean {
    //     return this._locationZExactMatch;
    // }
    //
    // set locationZExactMatch(value: boolean) {
    //     this._locationZExactMatch = value;
    // }
    //
    // get circuitTypes(): string[] {
    //     return this._circuitTypes;
    // }
    //
    // set circuitTypes(value: string[]) {
    //     this._circuitTypes = value;
    // }
    //
    // get lookupChildren(): boolean {
    //     return this._lookupChildren;
    // }
    //
    // set lookupChildren(value: boolean) {
    //     this._lookupChildren = value;
    // }

    private _connectionHierarchySearchModel: ConnectionHierarchySearchModel;


    get connectionHierarchySearchModel(): ConnectionHierarchySearchModel {
        return this._connectionHierarchySearchModel;
    }

    set connectionHierarchySearchModel(value: ConnectionHierarchySearchModel) {
        this._connectionHierarchySearchModel = value;
    }

    constructor( private http: HttpClient ) { }

    fetchConnectionHierarchySearchResults()
        : Observable<ConnectionHierarchyModel[]> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };
        return this.http.post<ConnectionHierarchyModel[]>('api/top/get-connection-hierarchy-search-results'
            , this.connectionHierarchySearchModel, httpOptions);
    }

    fetchConnectionHierarchyChildren()
        : Observable<ConnectionHierarchyModel[]> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };
        return this.http.get<ConnectionHierarchyModel[]>('assets/data/conn-hierarchy-c.json');
    }

    fetchConnectionHierarchyParents()
        : Observable<ConnectionHierarchyModel[]> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };
        return this.http.get<ConnectionHierarchyModel[]>('assets/data/conn-hierarchy-p.json');
    }
}
