import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-top-home',
  templateUrl: './top-home.component.html',
  styleUrls: ['./top-home.component.scss']
})
export class TopHomeComponent implements OnInit {

  baseImageUrl: string = "assets/images/";

  constructor() { }

  ngOnInit() {
  }

}
