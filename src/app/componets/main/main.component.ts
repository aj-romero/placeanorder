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
  constructor(private storeService:StoreService){}

  ngOnInit(): void{
    this.storeService.getProducts().subscribe((res)=>{
        this.products = res;
        console.log(this.products);
        
    });
  }
}
