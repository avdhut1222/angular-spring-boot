import { Component, OnInit } from '@angular/core';
import {PsrSearchService} from '../../../service/psr-search.service';

@Component({
  selector: 'app-hunt-group',
  templateUrl: './hunt-group.component.html',
  styleUrls: ['./hunt-group.component.scss']
})
export class HuntGroupComponent implements OnInit {

  constructor( private psrSearchService: PsrSearchService ) { }

  ngOnInit() {}


}
