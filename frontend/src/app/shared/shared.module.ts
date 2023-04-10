import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from './material/material.module';
import { ItemQuantityComponent } from './components/item-quantity/item-quantity.component';
import { TitleComponent } from './components/title/title.component';
import { PageComponent } from './components/page/page.component';
import { WordWrapPipe } from './pipes/word-wrap.pipe';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    ItemQuantityComponent,
    TitleComponent,
    PageComponent,
    WordWrapPipe
  ],
  imports: [
    CommonModule,
    MaterialModule,
    ReactiveFormsModule,
  ],
  exports: [
    MaterialModule,
    ReactiveFormsModule,
    ItemQuantityComponent,
    TitleComponent,
    PageComponent,
    WordWrapPipe
  ]
})
export class SharedModule { }
