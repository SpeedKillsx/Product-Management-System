import { Component, OnInit } from '@angular/core';
import { ProduitListComponentComponent } from '../produit-list-component/produit-list-component.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ProduitFormComponentComponent } from '../produit-form-component/produit-form-component.component';
import { ProduitDetailComponent } from '../produit-detail/produit-detail.component';

@Component({
  selector: 'app-master',
  standalone: true,
  imports: [FormsModule, CommonModule, ProduitFormComponentComponent, ProduitDetailComponent],
  templateUrl: './master.component.html',
  styleUrl: './master.component.css'
})
export class MasterComponent implements OnInit{
  currentPage  = "ADD";

  ngOnInit(): void {
      
  }

  changePage(tabName:string) :void{
    this.currentPage = tabName;
    
  }
}
