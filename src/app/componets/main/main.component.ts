import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/interfaces/product.interface';
import { StoreService } from 'src/app/service/store.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit{
  products:Product[]=[];
  alert:boolean=false;
  showProducts:boolean=true;
  constructor(private storeService:StoreService){}

  ngOnInit(): void{
    this.storeService.viewAlert.subscribe((alert) => {
      this.alert = alert;
    });
    this.storeService.isShowProducts.subscribe((state) =>{
      this.showProducts = state;
    });
  }

  closeAlert(){
    this.alert = false;
  }
}
