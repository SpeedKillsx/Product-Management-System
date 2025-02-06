import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { APIData } from '../../model/interface/APIData';
import { Product } from '../../model/class/Product';
import { environment } from '../../../environments/environment.development';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProduitDetailService {
  http = inject(HttpClient);

  updateProduct(obj:Product){
  return this.http.put<APIData>(`${environment.API_URL}produits/${obj.id}`, obj).pipe(catchError(error => {
                    
                    return throwError(() => new Error('ERROR occured during the updating process : ', error));
                }));
  }
/*
 {@param} Product : Object Product to delelte
*/
  deleteProduct(id:number){
    return this.http.delete<APIData>(`${environment.API_URL}produits/${id}`).pipe(catchError(error => {
      
      return throwError(() => new Error('ERROR occurred during the deleting process : \n', error));
  }))
  }
}
