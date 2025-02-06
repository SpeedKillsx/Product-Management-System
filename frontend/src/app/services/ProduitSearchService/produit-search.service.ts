
import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { Observable } from 'rxjs';
import { APIData } from '../../model/interface/APIData';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class ProduitSearchService {

  http = inject(HttpClient);
  
  searchProductMulti(filters?: {
    name?: string;
    description?: string;
    price?: number;
    quantity?: number;
    category_name?: string

  }): Observable<APIData> {
    let params = new HttpParams();
    
    if (filters?.name) params = params.set('name', filters.name);
    if (filters?.description) params = params.set('description', filters.description);
    if (filters?.price) params = params.set('price', filters.price.toString());
    if (filters?.quantity) params = params.set('quantity', filters.quantity.toString());
    if (filters?.category_name) params = params.set('category_name', filters.category_name);
    console.log("filters = ", params);

    return this.http.get<APIData>(environment.API_URL + "produits/search", {params: params});
  }
}
