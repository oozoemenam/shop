import { createFeatureSelector, createSelector } from "@ngrx/store";
import { ProductState } from "./product.reducer";


export const selectProductState =
createFeatureSelector<ProductState>("productState")

export const selectProducts = () => createSelector(
  selectProductState,
  (state: ProductState) => state.products
)

export const selectProduct = (id: string) => createSelector(
  selectProductState,
  (state: ProductState) => state.products.find(product => product.id == id)
)
