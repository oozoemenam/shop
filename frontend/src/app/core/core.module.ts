import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FooterComponent } from './components/footer/footer.component';
import { SharedModule } from '../shared/shared.module';
import { ErrorComponent } from './components/error/error.component';
import { HeaderComponent } from './components/header/header.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    ErrorComponent,
    PageNotFoundComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule
  ],
  exports: [
    HeaderComponent,
    FooterComponent
  ]
})
export class CoreModule { }
