import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RateCode} from '../../domain/rate-code';
import {ConnectionSearchResult} from '../../domain/connection-search-result';
import {ConnectionDesignDetails} from '../../domain/connection-design-details';
import {CircuitDlrHistory} from "../../domain/circuit-dlr-history";

@Injectable()
export class ConnectionDesignService {
    private _circuitType: string;
    private _locationA: string;
    private _locationZ: string;
    private _designation: string;
    private _rateCode: string;

    connectionDesignDetails: ConnectionDesignDetails;

    get circuitType(): string {
        return this._circuitType;
    }

    set circuitType(value: string) {
        this._circuitType = value;
        if (value) {
            sessionStorage.setItem('connectionCircuitType', value);
        }
    }

    get locationA(): string {
        return this._locationA;
    }

    set locationA(value: string) {
        this._locationA = value;
        if (value) {
            sessionStorage.setItem('connectionLocationA', value);
        }
    }

    get locationZ(): string {
        return this._locationZ;
    }

    set locationZ(value: string) {
        this._locationZ = value;
        if (value) {
            sessionStorage.setItem('connectionLocationZ', value);
        }
    }

    get designation(): string {
        return this._designation;
    }

    set designation(value: string) {
        this._designation = value;
        if (value) {
            sessionStorage.setItem('connectionDesignation', value);
        }
    }

    get rateCode(): string {
        return this._rateCode;
    }

    set rateCode(value: string) {
        this._rateCode = value;
        if (value) {
            sessionStorage.setItem('connectionRateCode', value);
        }
    }

    constructor(private http: HttpClient) {
    }

    fetchRateCodes(): Observable<RateCode[]> {
        return this.http.get<RateCode[]>('assets/data/rate-codes.json', {responseType: 'json'});
    }

    fetchConnectionSearchResults(): Observable<ConnectionSearchResult[]> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };
        const data = {
            circuitType: sessionStorage.getItem('connectionCircuitType'),
            locationA: sessionStorage.getItem('connectionLocationA'),
            locationZ: sessionStorage.getItem('connectionLocationZ'),
            designation: sessionStorage.getItem('connectionDesignation'),
            rateCode: sessionStorage.getItem('connectionRateCode')
        };
        return this.http.post<ConnectionSearchResult[]>('api/top/get-connection-search-results', data, httpOptions);
    }

    fetchConnectionHistory(circuitDesignId: string): Observable<CircuitDlrHistory[]> {
        return this.http.get<CircuitDlrHistory[]>('api/top/connection-design/circuit-info/' + circuitDesignId, {responseType: 'json'});
    }

    fetchConnectionDesignDetails(circuitDesignId: string, issueNum: string, docNum: string) {
        let url = 'api/top/connection-design/connection-design-detail/circuitDesignId/' + circuitDesignId + '/issueNbr/' + issueNum + '/docNum/' + docNum;
        return this.http.get<ConnectionDesignDetails>(url, {responseType: 'json'})
            .subscribe((resp: ConnectionDesignDetails) => {
                this.connectionDesignDetails = resp;
            });
    }

}
