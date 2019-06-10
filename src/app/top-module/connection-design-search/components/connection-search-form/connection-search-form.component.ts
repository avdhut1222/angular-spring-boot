import { Component, OnInit } from '@angular/core';
import {ConnectionDesignService} from "../../service/connection-design.service.";
import {RateCode} from "../../../domain/rate-code";
import {Router} from "@angular/router";

@Component({
  selector: 'app-connection-search-form',
  templateUrl: './connection-search-form.component.html',
  styleUrls: ['./connection-search-form.component.scss']
})
export class ConnectionSearchFormComponent implements OnInit {

  rateCodes: RateCode[];
  circuitType: string;
  aNetworkLocation: string;
  zNetworkLocation: string;
  connectionDesignation: string;
  selectedRateCode: string;

  constructor( private connectionDesignService: ConnectionDesignService, private router: Router ) { }

  ngOnInit() {
    this.connectionDesignService.fetchRateCodes().subscribe( (resp: RateCode[]) => {
      this.rateCodes = resp;
    });
    this.circuitType = 'F';
  }

  connectionSearchFormSubmit(): boolean {
    // TODO: Send the search parameters in the URL to results page
    this.connectionDesignService.circuitType = this.circuitType;
    this.connectionDesignService.locationA = this.aNetworkLocation;
    this.connectionDesignService.locationZ = this.zNetworkLocation;
    this.connectionDesignService.designation = this.connectionDesignation;
    this.connectionDesignService.rateCode = this.selectedRateCode;
    this.router.navigateByUrl('top/connection-search-results');
    return false;
  }

}
