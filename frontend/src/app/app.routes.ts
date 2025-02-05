import { Routes } from '@angular/router';
import { MasterComponent } from './Components/master/master.component';
import { ProduitListComponentComponent } from './Components/produit-list-component/produit-list-component.component';

export const routes: Routes = [
    {
        path:'',
        redirectTo:'master',
        pathMatch:"full"
    },
    {
        path:'master',
        component: MasterComponent
    },
    {
        path:'product-list',
        component: ProduitListComponentComponent
    }
];
