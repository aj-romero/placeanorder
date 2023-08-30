import { Component, OnInit } from '@angular/core';
import { StoreService } from 'src/app/service/store.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  viewCart: boolean = false;
  constructor(private storeService:StoreService){}

  ngOnInit(): void {
    
  }

  onToggleCart(){
    
    this.storeService.viewCart.next(!this.storeService.viewCart.getValue());
   // this.viewCart = this.storeService.viewCart.getValue();
    this.storeService.viewCart.subscribe((status) =>{
      this.viewCart = status;
    });
    
    
    
  }

  count(){
    return this.storeService.countProducts();
  }



}
