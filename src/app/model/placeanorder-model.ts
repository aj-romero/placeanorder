import { ProductModel } from "./product-model";

export class PlaceAnOrderModel{
    name: String = '';
    creditCardNumber:String='';
    products:ProductModel[]=[];
}