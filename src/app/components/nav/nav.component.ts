import { Component, OnInit } from '@angular/core';
import {NavLinkService} from "../../service/nav-link.service";
import {NavCategory} from "../../domain/nav-category";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  navCategories: NavCategory[];

  constructor(private navLinkService: NavLinkService) { }

  ngOnInit() {
    this.navLinkService.fetchNavLinks().subscribe((resp: NavCategory[]) => this.navCategories = resp);
  }

}
