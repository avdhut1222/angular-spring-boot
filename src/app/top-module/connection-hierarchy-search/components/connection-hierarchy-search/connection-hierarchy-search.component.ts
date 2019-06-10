import {Component, OnInit} from '@angular/core';
import {ConnectionHierarchySearchModel} from "../../../domain/connection-hierarchy-search-model";
import {ConnectionHierarchyService} from "../../service/connection-hierarchy.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-connection-hierarchy-search',
    templateUrl: './connection-hierarchy-search.component.html',
    styleUrls: ['./connection-hierarchy-search.component.scss']
})
export class ConnectionHierarchySearchComponent implements OnInit {

    // ecckt: string;
    // eccktExactMatch: boolean;
    // connectionReference: string;
    // connXrefExactMatch: boolean;
    // locationA: string;
    // locationAExactMatch: boolean;
    // locationZ: string;
    // locationZExactMatch: boolean;
    // circuitTypes: string[];
    // lookupChildren: boolean;

    connectionHierarchySearchModel: ConnectionHierarchySearchModel;

    cktTypeOptions = [
        {name: 'Bandwidth', value: 'B', checked: true},
        {name: 'Facility', value: 'F', checked: true},
        {name: 'Special', value: 'S', checked: true},
        {name: 'Trunk', value: 'T', checked: true},
        {name: 'Virtual', value: 'V', checked: true},
        {name: 'SONET/SDH Route', value: 'R', checked: false},
        {name: 'Net Route', value: 'N', checked: false}
    ];

    get selectedCktTypeOptions(): string[] { // right now: ['1','3']
        return this.cktTypeOptions
            .filter(opt => opt.checked)
            .map(opt => opt.value);
    }

    constructor( protected connectionHierarchyService: ConnectionHierarchyService,
                 private router: Router ) {
    }

    ngOnInit() {
        this.connectionHierarchySearchModel = new class implements ConnectionHierarchySearchModel {
            circuitTypes: string[];
            connXrefExactMatch: boolean;
            connectionReference: string;
            ecckt: string;
            eccktExactMatch: boolean;
            locationA: string;
            locationAExactMatch: boolean;
            locationZ: string;
            locationZExactMatch: boolean;
            lookupChildren: boolean;
        }
    }

    connectionHierarchyFormSubmit() {
        // this.connectionHierarchyService.ecckt(this.ecckt);
        // this.connectionHierarchyService.eccktExactMatch(this.eccktExactMatch);
        // this.connectionHierarchyService.connectionReference(this.connectionReference);
        // this.connectionHierarchyService.connXrefExactMatch(this.connXrefExactMatch);
        // this.connectionHierarchyService.locationA(this.locationA);
        // this.connectionHierarchyService.locationAExactMatch(this.locationAExactMatch);
        // this.connectionHierarchyService.locationZ(this.locationZ);
        // this.connectionHierarchyService.locationZExactMatch(this.locationZExactMatch);
        // this.connectionHierarchyService.lookupChildren(this.lookupChildren);
        this.connectionHierarchySearchModel.circuitTypes = this.selectedCktTypeOptions;
        // console.log(this.connectionHierarchySearchModel);
        this.connectionHierarchyService.connectionHierarchySearchModel = this.connectionHierarchySearchModel;
        this.router.navigateByUrl('top/connection-hierarchy-search-results/' + this.connectionHierarchySearchModel.lookupChildren);
    }
}
