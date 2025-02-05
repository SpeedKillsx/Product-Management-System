import { APP_ID, Component, inject, Inject, OnInit } from '@angular/core';
import { Product } from '../../model/class/Product';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ProduitListServiceService } from '../../services/produit-list-service.service';
import { catchError, Observable } from 'rxjs';
import { APIData } from '../../model/interface/APIData';
import { error } from 'console';
@Component({
  selector: 'app-produit-list-component',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './produit-list-component.component.html',
  styleUrl: './produit-list-component.component.css'
})
export class ProduitListComponentComponent implements OnInit{
  productList: Product[] = [];
  
  prodListComponent = inject(ProduitListServiceService);
  ngOnInit(): void {
    this.getAllProduct();
  }

  getAllProduct() {
    this.prodListComponent.getAllProduct().subscribe((products:APIData) => {
      this.productList = products.data;
      
    }, (error)=>{
      console.log("Error : ", error);
    })
  }

}
