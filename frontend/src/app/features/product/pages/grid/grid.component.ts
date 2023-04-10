import { Component, OnInit } from '@angular/core';
import { selectProducts } from '../../state/product.selectors';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { AppState } from 'src/app/state/app.state';
import { ProductActionTypes } from '../../state/product.actions.types';
import { Product } from '../../models/product.interface';
import { ProductActions } from '../../enums/product-actions.enum';

@Component({
  selector: 'app-grid',
  templateUrl: './grid.component.html',
  styleUrls: ['./grid.component.css']
})
export class GridComponent implements OnInit {
  products: ReadonlyArray<Product> = [];
  products$ = this.store.select(selectProducts());

  constructor(
    private router: Router,
    private store: Store<AppState>,
  ) { }

  ngOnInit(): void {
      this.store.dispatch({ type: ProductActionTypes.GET_PRODUCT_LIST });
      this.assignProducts();
  }

  assignProducts() {
    this.products$.subscribe((data) => {
      this.products = data;
    })
  }

  selectProduct(data: { product: Product, action: ProductActions }) {
    switch (data.action) {
      case ProductActions.View: {
        this.router.navigate([data.product.id]);
        return;
      }
      // case ProductActions.AddToCart: {
      //   this.store.dispatch({
      //     type: ProductActionTypes.ADD_TO_CART,
      //     payload: data.product.id
      //   })
      // }
      default:
        break;
    }
  }
}
