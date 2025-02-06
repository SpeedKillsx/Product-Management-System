import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { Product } from '../../model/class/Product';
import { APIData } from '../../model/interface/APIData';
import { catchError, throwError } from 'rxjs';
import { Category } from '../../model/class/Category';
import { error } from 'console';

@Injectable({
  providedIn: 'root'
})
export class ProduitFormService {
  
  http = inject(HttpClient);

   
  /*
    Load categories From Database
  */
  
  loadCategories(){
    return this.http.get(environment.API_URL+"categories/");
  }
  
  addProduct(obj: Product) {
    return this.http.post<APIData>(environment.API_URL + 'produits/', obj)
        .pipe(
            catchError(error => {
                console.error('Erreur lors de l\'ajout du produit:', error);
                return throwError(() => new Error('Échec de l\'ajout du produit.'));
            })
        );
  }
}
