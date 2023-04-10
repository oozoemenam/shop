import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListComponent } from './pages/list/list.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { DetailComponent } from './pages/detail/detail.component';
import { GridComponent } from './pages/grid/grid.component';
import { ProductGridComponent } from './components/product-grid/product-grid.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { ProductRoutingModule } from './product-routing.module';
import { StoreModule } from '@ngrx/store';
import { productReducer } from './state/product.reducer';
import { EffectsModule } from '@ngrx/effects';
import { ProductEffects } from './state/product.effects';
import { HttpClientModule } from '@angular/common/http';
// import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    ListComponent,
    ProductListComponent,
    DetailComponent,
    GridComponent,
    ProductGridComponent
  ],
  imports: [
    CommonModule,
    ProductRoutingModule,
    SharedModule,
    HttpClientModule,
    StoreModule.forFeature('productState', productReducer),
    EffectsModule.forFeature([ProductEffects])
  ]
})
export class ProductModule { }
