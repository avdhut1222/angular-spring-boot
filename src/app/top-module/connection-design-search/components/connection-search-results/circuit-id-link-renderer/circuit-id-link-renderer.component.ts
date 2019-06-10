import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-circuit-id-link-renderer',
  templateUrl: './circuit-id-link-renderer.component.html',
  styleUrls: ['./circuit-id-link-renderer.component.scss']
})
export class CircuitIdLinkRendererComponent implements OnInit {

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
