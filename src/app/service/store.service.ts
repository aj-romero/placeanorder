import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { Product } from '../interfaces/product.interface';
import { ProductModel } from '../model/product-model';

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  api = 'http://localhost:9000/api/v1/';
  private mylist:ProductModel[] = [];
  private myCart = new BehaviorSubject<ProductModel[]>([]);
  myCart$ = this.myCart.asObservable();

  public viewCart = new BehaviorSubject<boolean>(false);
  public viewAlert = new BehaviorSubject<boolean>(false);
  public isShowProducts = new BehaviorSubject<boolean>(true);

  constructor(private httpClient: HttpClient) { }

  getProducts(): Observable<ProductModel[]>{
    return this.httpClient.get<ProductModel[]>(this.api + 'products');
  }

  validateCard(req:any):Observable<any>{
    return this.httpClient.post<any>(this.api +'placeorder',req);
  }

  addProduct(product:ProductModel){
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
    if(this.countProducts() <= 0){
      this.isShowProducts.next(true);
    }
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
    const i = this.mylist.reduce(function (acc, product) { return acc + product.quantity; }, 0)
    return i;
  }

  resetList(){
    this.mylist = [];
    this.myCart.next(this.mylist);
  }

}
