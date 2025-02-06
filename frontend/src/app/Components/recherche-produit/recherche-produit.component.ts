import { HttpClient } from '@angular/common/http';
import { Component, inject, OnInit } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { Product } from '../../model/class/Product';
import { ProduitSearchService } from '../../services/ProduitSearchService/produit-search.service';
import { CommonModule } from '@angular/common';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Category } from '../../model/class/Category';
import { ProduitFormService } from '../../services/ProduitFormService/produit-form-component.service';
import { APIData } from '../../model/interface/APIData';
import { error } from 'console';

@Component({
  selector: 'app-recherche-produit',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './recherche-produit.component.html',
  styleUrl: './recherche-produit.component.css'
})
export class RechercheProduitComponent implements OnInit{
  // Lists
  producList: Product[] = [];
  categoriesList: Category[] = [];
  filtredProductList: Product[] = [];
  //Inject Services
  prodSearchService = inject(ProduitSearchService);
  prodListService = inject(ProduitFormService);
  // Form
  groupForm: FormGroup = new FormGroup({
    name: new FormControl(""),
    description: new FormControl(""),
    price: new FormControl(0),
    quantity: new FormControl(0),
    category_name: new FormControl(0),
  });


  ngOnInit(): void {
    this.prodListService.loadCategories().subscribe((res:any)=>{
      this.categoriesList = res;
    });
  }
  
  getProductMulti() {
    const formValue = this.groupForm.value;
    console.log(formValue);
    this.prodSearchService.searchProductMulti(formValue).subscribe((res:APIData)=>{
      this.filtredProductList = res.data;

    }, (error)=>{
      alert("Error during the research with the sepecefique parameters");
      console.log("ERROR: ", error);
    });
  }


}
