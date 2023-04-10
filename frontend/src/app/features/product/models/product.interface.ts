import { Category } from "./category.interface";

export interface Product {
  id: string;
  name: string;
  price: number;
  description: string;
  category: Category;
  imageUrl: string;
}
