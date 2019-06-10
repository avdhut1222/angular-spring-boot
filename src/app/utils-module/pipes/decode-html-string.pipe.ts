import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'decodeHtmlString'
})
export class DecodeHtmlStringPipe implements PipeTransform {

  transform(value: string) {
    const tempElement = document.createElement("span");
    tempElement.innerHTML = value;
    return tempElement.innerText;
  }

}