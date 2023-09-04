import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/interfaces/product.interface';
import { StoreService } from 'src/app/service/store.service';
import { ProductModel } from 'src/app/model/product-model';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit{

  products: ProductModel [] = [];
  constructor(private storeService: StoreService){}

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(){
    this.storeService.getProducts().subscribe((res)=>{
      this.products = res;
      
  });
  }
  addToCart(product: ProductModel){
    return this.storeService.addProduct(product);
  }

}
