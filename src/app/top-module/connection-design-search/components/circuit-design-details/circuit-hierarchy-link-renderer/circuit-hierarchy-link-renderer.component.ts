import { Component, OnInit } from '@angular/core';
import {ConnectionDesignService} from "../../../service/connection-design.service.";

@Component({
  selector: 'app-circuit-hierarchy-link-renderer',
  templateUrl: './circuit-hierarchy-link-renderer.component.html',
  styleUrls: ['./circuit-hierarchy-link-renderer.component.scss']
})
export class CircuitHierarchyLinkRendererComponent implements OnInit {

  params: any;
  value: any;

  constructor() { }

  ngOnInit() {
  }

  agInit(params: any): void {
    this.params = params;
    this.value = this.params.value;
  }
}
