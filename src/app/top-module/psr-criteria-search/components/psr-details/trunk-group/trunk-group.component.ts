import { Component, OnInit } from '@angular/core';
import {PsrSearchService} from '../../../service/psr-search.service';

@Component({
  selector: 'app-trunk-group',
  templateUrl: './trunk-group.component.html',
  styleUrls: ['./trunk-group.component.scss']
})
export class TrunkGroupComponent implements OnInit {

  objectKeys = Object.keys;

  constructor( protected psrSearchService: PsrSearchService) {
  }

  ngOnInit() {
  }

}
