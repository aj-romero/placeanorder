import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { Product } from '../interfaces/product.interface';

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  api = 'http://localhost:9000/api/v1/';
  private mylist:Product[] = [];
  private myCart = new BehaviorSubject<Product[]>([]);
  myCart$ = this.myCart.asObservable();

  public viewCart = new BehaviorSubject<boolean>(false);
  public viewAlert = new BehaviorSubject<boolean>(false);

  constructor(private httpClient: HttpClient) { }

  getProducts(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.api + 'product/list');
  }

  addProduct(product:Product){
    if(this.mylist.length === 0){
      product.quantity = 1;
      this.mylist.push(product);
      this.myCart.next(this.mylist)
    }else{
      const prodMod = this.mylist.find((elem) => {
        return elem.id === product.id;
      });
      if(prodMod){
        prodMod.quantity++;
        this.myCart.next(this.mylist)
      }else{
        product.quantity = 1;
        this.mylist.push(product);
        this.myCart.next(this.mylist)
      }
    }
    
  }

  deleteProduct(id:number){
    this.mylist = this.mylist.filter((product)=>{
      return product.id !=id;
    });
    this.myCart.next(this.mylist);
  }

  findProductById(id: number) {
    return this.mylist.find((element) => {
      return element.id === id;
    });
  }
  totalCart() {
    const total = this.mylist.reduce(function (acc, product) { return acc + (product.quantity * product.price); }, 0)
    return total
  }

  countProducts(){
    return this.mylist.length;
  }

}
