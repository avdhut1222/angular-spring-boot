import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppComponent } from './app.component';
import { XhrInterceptor } from './interceptor/xhr.interceptor';
import { NavLinkService } from './service/nav-link.service';
import { AppRoutingModule } from './app-routing.module';
import {UtilsModule} from "./utils-module/utils.module";
import {HomeComponent} from "./components/home/home.component";
import {NavComponent} from "./components/nav/nav.component";
import {FooterComponent} from "./components/footer/footer.component";
import {PageNotFoundComponent} from "./components/page-not-found/page-not-found.component";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavComponent,
    FooterComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    UtilsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true },
    NavLinkService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
