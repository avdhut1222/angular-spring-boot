import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PsrSearchCriteria} from '../../../domain/psr-search-criteria';
import {PsrSearchFormModel} from '../../../domain/psr-search-form-model';
import {PsrSearchService} from '../../service/psr-search.service';

@Component({
  selector: 'app-psr-search',
  templateUrl: './psr-search.component.html',
  styleUrls: ['./psr-search.component.scss']
})
export class PsrSearchComponent implements OnInit {

  psrSearchCriteriaOptions: PsrSearchCriteria[];
  psrSearchFormModel: PsrSearchFormModel;
  psrSearchCriteria: string;
  psrSearchValue: string;

  constructor( private psrSearchService: PsrSearchService, private router: Router, private route: ActivatedRoute ) { }

  ngOnInit() {
    this.psrSearchService.fetchPsrSearchCriteria().subscribe( (resp: PsrSearchCriteria[]) => {
      this.psrSearchCriteriaOptions = resp;
    });
  }

  psrSearchFormSubmit(): boolean {
    if (this.psrSearchCriteria === 'DOCUMENT_NUMBER') {
      this.router.navigateByUrl('top/psr-details/' + this.psrSearchValue);
    } else {
      this.psrSearchService.psrSearchCriteria = this.psrSearchCriteria;
      this.psrSearchService.psrSearchValue = this.psrSearchValue;
      this.router.navigateByUrl('top/psr-search-results');
    }
    return false;
  }

}
