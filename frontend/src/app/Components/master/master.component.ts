import { Component, OnInit } from '@angular/core';
import { ProduitListComponentComponent } from '../produit-list-component/produit-list-component.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ProduitFormComponentComponent } from '../produit-form-component/produit-form-component.component';

@Component({
  selector: 'app-master',
  standalone: true,
  imports: [FormsModule, CommonModule, ProduitFormComponentComponent],
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
