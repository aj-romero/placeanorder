import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder  } from '@angular/forms';
import { StoreService } from 'src/app/service/store.service';
import { PlaceAnOrderModel } from 'src/app/model/placeanorder-model';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit {

  myCart$ = this.storeService.myCart$;
  formCheckout: FormGroup = new FormGroup({});
  placeAnOrder: PlaceAnOrderModel = new PlaceAnOrderModel();
  alert:boolean = false;
  submitted:boolean = false;
  errorMsj:String='';

  constructor(private storeService:StoreService, private fb: FormBuilder){

  }

  ngOnInit(): void {
    this.formCheckout = this.fb.group({
      name: ['', Validators.required],
      creditCardNumber: ['', Validators.required]
    });
  }
  totalProduct(price:number, units:number){
    return (price*units).toFixed(2);
  }

  totalCart(){
    const result = this.storeService.totalCart();
    return result;
  }
  save(){
    this.submitted = true;
    if (this.formCheckout.valid) {
      this.setValues();
      this.storeService.validateCard(this.placeAnOrder).subscribe((resp) =>{
          console.log(resp);
          if(resp.success){
             // this.cleanAndReturn();
             this.errorMessage(resp.message);
          }else{
                this.errorMessage(resp.message);
          }

      } );
    }
    
  }
  errorMessage(msj:String ){
    this.alert = true;
    this.errorMsj = msj;
  }

  cleanAndReturn(){
          this.storeService.resetList();//limpiamos la lista del carrito
          this.storeService.isShowProducts.next(true); //esto para regresar al app-products
  }

  setValues(){
    this.placeAnOrder.name = this.formCheckout.controls['name'].value;    
    this.placeAnOrder.creditCardNumber = this.formCheckout.controls['creditCardNumber'].value;    
    
    this.storeService.myCart$.subscribe((list)=>{
      this.placeAnOrder.products = list;
      console.log(this.placeAnOrder);
            
    });
  }

  closeAlert(){
    this.alert = false;
  }
}
