import { Component, OnInit } from '@angular/core';
import { StoreService } from 'src/app/service/store.service';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  myCart$ = this.storeService.myCart$;
  constructor(private storeService:StoreService){}
  ngOnInit(): void {
    
  }

  totalProduct(price:number, units:number){
    return (price*units).toFixed(2);
  }

  deleteProduct(id:number){
    this.storeService.deleteProduct(id);
  }

  updateUnits(operation: string, id: number) {

    const product = this.storeService.findProductById(id)
    if (product) {
      if (operation === 'minus' && product.quantity > 0) {
        product.quantity--;
      }
      if (operation === 'add') {
        product.quantity++;

      }
      if (product.quantity === 0) {
        this.deleteProduct(id);
      }
    }

  }

  totalCart(){
    const result = this.storeService.totalCart();
    return result;
  }

  processOrder(){
    this.storeService.viewCart.next(!this.storeService.viewCart.getValue());
    let totalCart = this.totalCart();
    if(totalCart <= 0){
      this.storeService.viewAlert.next(true);
      
    }else{
      this.storeService.isShowProducts.next(false);
    }
    
    
  }

}
