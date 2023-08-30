import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/interfaces/product.interface';
import { StoreService } from 'src/app/service/store.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit{

  products: Product[] = [];
  constructor(private storeService: StoreService){}

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(){
    this.storeService.getProducts().subscribe((res)=>{
      this.products = res;
      
  });
  }
  addToCart(product: Product){
    return this.storeService.addProduct(product);
  }

}
