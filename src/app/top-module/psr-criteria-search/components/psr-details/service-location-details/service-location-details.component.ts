import {Component, OnInit} from '@angular/core';
import {PsrSearchService} from '../../../service/psr-search.service';
import {PsrServiceLocation} from '../../../../domain/psr-service-location';
import {ChildSr} from '../../../../domain/child-sr';

@Component({
    selector: 'app-service-location-details',
    templateUrl: './service-location-details.component.html',
    styleUrls: ['./service-location-details.component.scss']
})
export class ServiceLocationDetailsComponent implements OnInit {

    objectKeys = Object.keys;
    psrServiceLocation: PsrServiceLocation;
    childSRs: ChildSr;

    constructor(protected psrSearchService: PsrSearchService) {
    }

    ngOnInit() {
        this.psrServiceLocation = this.psrSearchService.psrDetails.psrServiceLocation;
        this.childSRs = this.psrSearchService.psrDetails.childSRs;
    }

}
