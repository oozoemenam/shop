import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { Product } from '../models/product.interface';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${environment.apiUrl}/products`).pipe(
      tap((data: Product[]) => data),
      catchError(err => throwError(() => err))
    )
  }

  getProduct(id: string): Observable<Product> {
    return this.http.get<Product>(`${environment.apiUrl}/products/${id}`).pipe(
      tap((data: Product) => data),
      catchError(err => throwError(() => err))
    )
  }
}
