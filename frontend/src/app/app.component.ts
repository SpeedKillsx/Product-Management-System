import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { MasterComponent } from './Components/master/master.component';
import { ProduitListComponentComponent } from './Components/produit-list-component/produit-list-component.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ RouterOutlet, RouterLinkActive, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
  isActive = "active";
}
