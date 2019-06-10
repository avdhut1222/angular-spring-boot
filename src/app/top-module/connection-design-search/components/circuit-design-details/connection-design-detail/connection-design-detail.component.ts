import {Component, OnInit} from '@angular/core';
import {ConnectionDesignService} from "../../../service/connection-design.service.";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {PsrSearchService} from "../../../../psr-criteria-search/service/psr-search.service";

@Component({
    selector: 'app-connection-design-detail',
    templateUrl: './connection-design-detail.component.html',
    styleUrls: ['./connection-design-detail.component.scss']
})
export class ConnectionDesignDetailComponent implements OnInit {

    private circuitDesignId: string;
    private sub: any;
    constructor(protected connectionDesignService: ConnectionDesignService,
                private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.sub = this.route.parent.params.subscribe(parentParams => {
            this.circuitDesignId = parentParams.circuitDesignId;
        });
        this.route.paramMap.subscribe((params: ParamMap) => {
            this.connectionDesignService.fetchConnectionDesignDetails(this.circuitDesignId, params.get('issueNbr'), params.get('docNum'));
        });
    }

    ngOnDestroy(){
        this.sub.unsubscribe();
    }

}
