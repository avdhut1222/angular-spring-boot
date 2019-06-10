import {Component, OnInit} from '@angular/core';
import {PsrSearchService} from "../../service/psr-search.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
    selector: 'app-psr-details',
    templateUrl: './psr-details.component.html',
    styleUrls: ['./psr-details.component.scss']
})
export class PsrDetailsComponent implements OnInit {

    constructor(protected psrSearchService: PsrSearchService,
                private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.route.paramMap.subscribe((params: ParamMap) => {
            this.psrSearchService.fetchPsrDetails(params.get('docNum'));
        });

    }

}
