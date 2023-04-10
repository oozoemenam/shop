import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'wordWrap'
})
export class WordWrapPipe implements PipeTransform {

  transform(value: string, length: number): string {
    return value.length > length ? `${value.substring(0, length)}...` : value;
  }

}
