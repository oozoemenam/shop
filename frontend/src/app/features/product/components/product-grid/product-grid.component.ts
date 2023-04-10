import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { Product } from '../../models/product.interface';
import { ProductActions } from '../../enums/product-actions.enum';

@Component({
  selector: 'app-product-grid',
  templateUrl: './product-grid.component.html',
  styleUrls: ['./product-grid.component.css']
})
export class ProductGridComponent implements OnInit {
  @Input() products: ReadonlyArray<Product> = [];
  @Output() product = new EventEmitter<{ product: Product, action: ProductActions }>();

  constructor() { }

  ngOnInit(): void {
  }

  selectProduct(product: Product, action: ProductActions) {
    this.product.emit({ product, action });
  }
}
