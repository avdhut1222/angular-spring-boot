import {Component, OnInit} from '@angular/core';
import {ConnectionHierarchyModel} from "../../../domain/connection-hierarchy-model";
import {ConnectionHierarchyService} from "../../service/connection-hierarchy.service";
import {switchMap} from "rxjs/operators";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Observable} from "rxjs";
import {CircuitDlrHistory} from "../../../domain/circuit-dlr-history";

@Component({
    selector: 'app-connection-hierarchy-search-results',
    templateUrl: './connection-hierarchy-search-results.component.html',
    styleUrls: ['./connection-hierarchy-search-results.component.scss']
})
export class ConnectionHierarchySearchResultsComponent implements OnInit {

    protected connectionHierarchyList: ConnectionHierarchyModel[];

    constructor(private connectionHierarchyService: ConnectionHierarchyService,
                private route: ActivatedRoute,
                private router: Router) {
    }

    ngOnInit() {

        // this.route.paramMap.pipe(
        //     switchMap((params: ParamMap): Observable<ConnectionHierarchyModel[]> => {
        //         if(params.get('lookupChildren') == 'true') {
        //             return this.connectionHierarchyService.fetchConnectionHierarchyChildren();
        //         } else {
        //             return this.connectionHierarchyService.fetchConnectionHierarchyParents();
        //         }
        //     })
        // ).subscribe((resp: ConnectionHierarchyModel[]) => this.connectionHierarchyList = resp);

        this.connectionHierarchyService.fetchConnectionHierarchySearchResults()
            .subscribe((resp: ConnectionHierarchyModel[]) => this.connectionHierarchyList = resp);
    }

}
