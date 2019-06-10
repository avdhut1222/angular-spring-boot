import {Component, OnInit} from '@angular/core';
import {ConnectionDesignService} from "../../../service/connection-design.service.";
import {ConnectionDesignDetails} from "../../../../domain/connection-design-details";
import {AdministrativeInformation} from "../../../../domain/administrative-information";

@Component({
    selector: 'app-administrative-section',
    templateUrl: './administrative-section.component.html',
    styleUrls: ['./administrative-section.component.scss']
})
export class AdministrativeSectionComponent implements OnInit {

    administrativeInformation: AdministrativeInformation;
    objectKeys = Object.keys;

    constructor(protected connectionDesignService: ConnectionDesignService) {
    }

    ngOnInit() {
        // this.connectionDesignService.fetchConnectionDesignDetails('12286023', '17').subscribe((resp: ConnectionDesignDetails) => {
        //     this.administrativeInformation = resp.administrativeInformation;
        // });
    }
}
