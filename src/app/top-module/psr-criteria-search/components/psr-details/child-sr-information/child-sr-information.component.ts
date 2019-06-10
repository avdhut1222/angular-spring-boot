import { Component, OnInit } from '@angular/core';
import {PsrSearchService} from '../../../service/psr-search.service';
import {ChildSr} from '../../../../domain/child-sr';

@Component({
  selector: 'app-child-sr-information',
  templateUrl: './child-sr-information.component.html',
  styleUrls: ['./child-sr-information.component.scss']
})
export class ChildSrInformationComponent implements OnInit {

  childSRs: ChildSr;

  constructor(protected psrSearchService: PsrSearchService) { }

  ngOnInit() {
    this.childSRs = this.psrSearchService.psrDetails.childSRs;
  }

}
