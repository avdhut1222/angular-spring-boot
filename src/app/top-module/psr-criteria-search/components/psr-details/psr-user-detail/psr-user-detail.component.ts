import { Component, OnInit } from '@angular/core';
import {UserDefinedField} from "../../../../domain/user-defined-field";
import {PsrSearchService} from "../../../service/psr-search.service";

@Component({
  selector: 'app-psr-user-detail',
  templateUrl: './psr-user-detail.component.html',
  styleUrls: ['./psr-user-detail.component.scss']
})
export class PsrUserDetailComponent implements OnInit {

  objectKeys = Object.keys;
  psrUserData: UserDefinedField[];

  constructor( protected psrSearchService: PsrSearchService ) {
  }

  ngOnInit() {
  }

}
