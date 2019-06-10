import { Component, OnInit } from '@angular/core';
import {PsrSearchService} from '../../../service/psr-search.service';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.scss']
})
export class ContactsComponent implements OnInit {

  objectKeys = Object.keys;

  constructor( protected psrSearchService: PsrSearchService ) {
  }

  ngOnInit() {
  }

}
