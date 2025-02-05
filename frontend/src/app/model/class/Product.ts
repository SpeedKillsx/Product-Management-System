import { Category } from "./Category";

export class Product {
    id:number=0;
    name:string="";
    description:string="";
    price:number=0;
    quantity:number=0;
    category_name:string="";
    constructor(id:number, name:string, descrirption:string, price:number, quantity:number, category:string){
        this.id = id;
        this.name = name;
        this.description = descrirption;
        this.price = price;
        this.quantity = quantity;
        this.category_name = category;
    }
}