import { Component, OnInit } from '@angular/core';
import {NavLinkService} from "../../service/nav-link.service";
import {NavCategory} from "../../domain/nav-category";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  navCategories: NavCategory[];

  baseImageUrl: string = "assets/images/";

  constructor( private navLinkService: NavLinkService) { }

  ngOnInit() {
    this.navLinkService.fetchNavLinks().subscribe((resp: NavCategory[]) => this.navCategories = resp);
  }

}
