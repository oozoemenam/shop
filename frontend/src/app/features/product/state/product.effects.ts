import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { ProductActionTypes } from './product.actions.types';
import { catchError, EMPTY, forkJoin, map, mergeMap, tap } from "rxjs";
import { ProductService } from '../services/product.service';


@Injectable()
export class ProductEffects {
  constructor(
    private actions$: Actions,
    private productService: ProductService,
    private router: Router
  ) { }

  getPizzas$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(ProductActionTypes.GET_PRODUCT_LIST),
      mergeMap(() => this.productService.getProducts().pipe(
        map(products => ({ type: ProductActionTypes.SET_PRODUCT_LIST, products })),
        catchError(() => EMPTY)
      ))
    )
  }, { dispatch: true });
}
