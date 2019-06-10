import { Component, OnInit } from '@angular/core';
import {PsrSearchService} from "../../../service/psr-search.service";

@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.scss']
})
export class OrderDetailComponent implements OnInit {

  objectKeys = Object.keys;

  constructor( protected psrSearchService: PsrSearchService) {
  }

  ngOnInit() {
    // this.route.parent.paramMap.pipe(
    //   switchMap((params: ParamMap): Observable<OrderDetail> => {
    //     return this.psrSearchService.fetchPsrOrderDetails(params.get('docNum'));
    //   })
    // ).subscribe((resp: OrderDetail) => this.orderDetailInformation = resp);
  }
}
