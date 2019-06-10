import { Component, OnInit } from '@angular/core';
import {ConnectionDesignService} from "../../../service/connection-design.service.";
import {ConnectionDesignDetails} from "../../../../domain/connection-design-details";
import {DesignInformation} from "../../../../domain/design-information";

@Component({
  selector: 'app-design-section',
  templateUrl: './design-section.component.html',
  styleUrls: ['./design-section.component.scss']
})
export class DesignSectionComponent implements OnInit {

  designInformation: DesignInformation;
  objectKeys = Object.keys;

  constructor(protected connectionDesignService: ConnectionDesignService) { }

  ngOnInit() {
    // this.connectionDesignService.fetchConnectionDesignDetails('12286023', '17').subscribe( (resp: ConnectionDesignDetails) => {
    //   this.designInformation = resp.designInformation;
    // });
  }
}
