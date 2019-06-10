import { Component, OnInit } from '@angular/core';
import {PsrSearchService} from '../../../service/psr-search.service';

@Component({
  selector: 'app-order-detail',
  templateUrl: './circuit-detail.component.html',
  styleUrls: ['./circuit-detail.component.scss']
})
export class CircuitDetailComponent implements OnInit {

  objectKeys = Object.keys;

  constructor( protected psrSearchService: PsrSearchService) {
  }

  ngOnInit() {}
}
