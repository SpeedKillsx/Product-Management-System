import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Product } from '../../model/class/Product';
import { ProduitListServiceService } from '../../services/ProduitListService/produit-list-service.service';
import { APIData } from '../../model/interface/APIData';
import { Category } from '../../model/class/Category';
import { ProduitFormService } from '../../services/ProduitFormService/produit-form-component.service';
import { ProduitDetailService } from '../../services/ProduitDetailService/produit-detail.service';

// TODO: Make imports between components
@Component({
  selector: 'app-produit-detail',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './produit-detail.component.html',
  styleUrl: './produit-detail.component.css'
})
export class ProduitDetailComponent implements OnInit{
  
  productList: Product[] = [];
  categoriesList: Category[] = [];
  productId:number = 0;
  selectedId:number = 0;
  prodListService = inject(ProduitListServiceService);
  prodFormService = inject(ProduitFormService);
  prodDetailService = inject(ProduitDetailService);

    // Create a Form group
    formgroupe:FormGroup = new FormGroup({
      name: new FormControl(""),
      description: new FormControl(""),
      price: new FormControl(0),
      quantity:new FormControl(0),
      category_name:  new FormControl("")
    });
  
    ngOnInit(): void {
      // Load the product
      this.UpdateListe();
      // Call the loadCategories method from prodFromService
      this.prodFormService.loadCategories().subscribe((res:any)=>{
        this.categoriesList = res;
        console.log("Les cat = ", res);
      });
    }
    /*
      Load the products 
    */
    UpdateListe(){
      this.prodListService.getAllProduct().subscribe((res:APIData)=>{
        console.log(res.data);
        this.productList = res.data;
      })
    }
    //FROM : https://stackblitz.com/edit/typescript-table-row-click?file=index.ts
    OnClickedTable(){
      
      const table: HTMLTableElement = document.querySelector('#table-products')!;

      // get all rows in the first table body
      const rows = table.tBodies[0].rows;

      // convert the rows to an array with the spread operator (...)
      // then iterate over each row using forEach
      Array.from(rows).forEach((row, idx) => {
        // attach a click handler on each row
        row.addEventListener('click', event => {
          // get all cells in the row, convert them to an array with the spread operator (...)
          // then for each cell, return its textContent by mapping on the array
          const tds = Array.from(row.cells).map(td => td.textContent);
          this.selectedId = idx;
          this.productId =  this.productList[this.selectedId].id;
          this.formgroupe.controls['name'].setValue(tds[0]);
          this.formgroupe.controls['description'].setValue(tds[1]);
          this.formgroupe.controls['price'].setValue(tds[2]);
          this.formgroupe.controls['quantity'].setValue(tds[3]);
          this.formgroupe.controls['category_name'].setValue(tds[4]);
         
        });
      }); 
    }
    // Update the product from the table
    updateProduct(){
      const formValue = this.formgroupe.value;
      this.prodDetailService.updateProduct({...formValue, id:this.productId}).subscribe((res:APIData)=>{
          if(res){
            alert("Update Done");
          }else{
            alert("Update ERROR");
          }
      });
      
    }
}
