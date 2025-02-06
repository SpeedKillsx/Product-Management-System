import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Product } from '../../model/class/Product';
import { environment } from '../../../environments/environment.development';
import { Observable } from 'rxjs';
import { APIData } from '../../model/interface/APIData';

@Injectable({
  providedIn: 'root'
})
export class ProduitListServiceService {
  productList: Product[] = []
  http = inject(HttpClient);

  getAllProduct(): Observable<APIData> {
    return this.http.get<APIData>(environment.API_URL + 'produits/');
  }

  
  

}
