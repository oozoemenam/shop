import { createReducer, on } from "@ngrx/store";
import { Product } from "../models/product.interface";
import { setProductList } from "./product.actions";


export interface ProductState {
  products: ReadonlyArray<Product>;
}

export const initialState: ProductState = {
  products: []
}

export const productReducer = createReducer(
  initialState,
  on(setProductList, (state, { products }) => {
    return {
      ...state,
      products
    }
  }),
);
