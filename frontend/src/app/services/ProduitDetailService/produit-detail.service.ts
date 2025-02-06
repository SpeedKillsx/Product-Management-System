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
                    console.error('Erreur lors de la modification du produit:', error);
                    return throwError(() => new Error('Échec de la mise a jour du produit.'));
                }));
  }
}
