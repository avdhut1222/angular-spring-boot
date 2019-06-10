import {Component, OnInit} from '@angular/core';
import {ConnectionDesignService} from "../../../service/connection-design.service.";
import {ConnectionDesignDetails} from "../../../../domain/connection-design-details";
import {EndUserTermination} from "../../../../domain/end-user-termination";

@Component({
    selector: 'app-eu-termination',
    templateUrl: './eu-termination.component.html',
    styleUrls: ['./eu-termination.component.scss']
})
export class EuTerminationComponent implements OnInit {

    endUserTermination: EndUserTermination;
    objectKeys = Object.keys;

    constructor(protected connectionDesignService: ConnectionDesignService) {
    }

    ngOnInit() {
        // this.connectionDesignService.fetchConnectionDesignDetails('12286023', '17').subscribe( (resp: ConnectionDesignDetails) => {
        //   this.endUserTermination = resp.endUserTermination;
        // });
    }

}
