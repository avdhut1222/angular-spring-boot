import {Component, OnInit} from '@angular/core';
import {CircuitDetails} from "../../../../domain/circuit-details";
import {ConnectionDesignService} from "../../../service/connection-design.service.";
import {ConnectionDesignDetails} from "../../../../domain/connection-design-details";

@Component({
    selector: 'app-circuit-details',
    templateUrl: './circuit-details.component.html',
    styleUrls: ['./circuit-details.component.scss']
})
export class CircuitDetailsComponent implements OnInit {

    clrNotes: string;
    objectKeys = Object.keys;

    constructor(protected connectionDesignService: ConnectionDesignService) {
    }

    ngOnInit() {
        // this.connectionDesignService.fetchConnectionDesignDetails('12286023', '17').subscribe((resp: ConnectionDesignDetails) => {
        //     this.clrNotes = resp.clrNotes;
        // });
    }

}
