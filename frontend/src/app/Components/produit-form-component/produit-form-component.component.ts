import { Component, inject, OnInit } from '@angular/core';
import { Product } from '../../model/class/Product';
import { ProduitFormService } from '../../services/produit-form-component.service';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Category } from '../../model/class/Category';
import { CommonModule } from '@angular/common';
import { APIData } from '../../model/interface/APIData';

@Component({
  selector: 'app-produit-form-component',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './produit-form-component.component.html',
  styleUrl: './produit-form-component.component.css'
})
export class ProduitFormComponentComponent implements OnInit{
  prodFormService = inject(ProduitFormService);
  categoriesList:Category[] = [];
  // Create a Form group
  formgroupe:FormGroup = new FormGroup({
    name: new FormControl(""),
    description: new FormControl(""),
    price: new FormControl(0),
    quantity:new FormControl(0),
    category_name:  new FormControl("")
  });

  ngOnInit(): void {
    this.loadCategories();
  }

  addProduct(){
    const formValue = this.formgroupe.value;
    debugger;
    this.prodFormService.addProduct(formValue).subscribe((res:APIData)=>{
      console.log(res);
      if (res){
        alert("Created ");
      }else{
        alert('Error');
      }
    });
  }

  loadCategories(){
    this.prodFormService.loadCategories().subscribe((res:any)=>{
      this.categoriesList = res;
    })
  }
}
