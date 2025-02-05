import { Component, Inject, OnInit } from '@angular/core';
import { Product } from '../../model/class/Product';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-produit-list-component',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './produit-list-component.component.html',
  styleUrl: './produit-list-component.component.css'
})
export class ProduitListComponentComponent implements OnInit{
  productList: Product[] = [];
  constructor(private http:HttpClient){}
  ngOnInit(): void {
    this.getAllProduct();
  }

  getAllProduct(){
    this.http.get('http://localhost:8080/api/v1/produits/').subscribe((res:any)=>{
      this.productList  = res;
    })
  }
  

}
