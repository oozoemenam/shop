import { createAction, props } from "@ngrx/store";
import { ProductActionTypes } from "./product.actions.types";
import { Product } from "../models/product.interface";


export const getProductList = createAction(
  ProductActionTypes.GET_PRODUCT_LIST,
);

export const setProductList = createAction(
  ProductActionTypes.SET_PRODUCT_LIST,
  props<{ products: ReadonlyArray<Product> }>(),
)
