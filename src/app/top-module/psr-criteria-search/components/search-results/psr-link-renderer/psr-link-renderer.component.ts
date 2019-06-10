import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-psr-link-renderer',
  templateUrl: './psr-link-renderer.component.html',
  styleUrls: ['./psr-link-renderer.component.scss']
})
export class PsrLinkRendererComponent implements OnInit {

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
