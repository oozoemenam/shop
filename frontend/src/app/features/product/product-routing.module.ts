import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetailComponent } from './pages/detail/detail.component';
import { GridComponent } from './pages/grid/grid.component';


const routes: Routes = [
  {
    path: "",
    component: GridComponent,
  },
  {
    path: ":id",
    component: DetailComponent
  }
]
@NgModule({
  declarations: [
  ],
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class ProductRoutingModule { }
