import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { KeyToStringPipe } from './pipes/key-to-string.pipe';
import {DecodeHtmlStringPipe} from "./pipes/decode-html-string.pipe";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    KeyToStringPipe,
    DecodeHtmlStringPipe
  ],
  exports: [
    KeyToStringPipe,
    DecodeHtmlStringPipe
  ]
})
export class UtilsModule { }
