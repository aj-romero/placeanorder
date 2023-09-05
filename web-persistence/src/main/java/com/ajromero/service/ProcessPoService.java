package com.ajromero.service;

import com.ajromero.domain.*;
import com.ajromero.domain.entity.OrderDetail;
import com.ajromero.domain.entity.Product;
import com.ajromero.domain.entity.PurchaseOrder;
import com.ajromero.domain.payment.PayByCC;
import com.ajromero.domain.payment.ReserveFundByCC;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessPoService implements IProcessValidation {
    private ProcessPO processPO;
    private ServiceResponse serviceResponse;

    @Autowired
    private IProductService productService;

    @Autowired
    private IPurchaseOrder purchaseOrderService;

    @Autowired
    private IOrderDetail orderDetailService;

    public ProcessPoService() {
        this.processPO = new ProcessPO();
        this.serviceResponse = new ServiceResponse();
    }

    @Override
    public ServiceResponse validateOrder(PlaceAnOrder order) {
        return validate(order);
    }

    public ServiceResponse validate(PlaceAnOrder po) {
        /*if (!processPO.validCardNumber(po.getCreditCardNumber())) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("The credit card number is not a valid number");
            return serviceResponse;
        }

        if (!processPO.firsNumberValidation(po.getCreditCardNumber())) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("The credit card number does not start with 4000");
            return serviceResponse;
        }

        if (!processPO.rangeNumberValidation(po.getCreditCardNumber())) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("The credit card number should be between 4111 and 4222");
            return serviceResponse;
        }

        if (!(po.calculateTotalList() > 0)) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("The total amount should be greater than zero.");
            return serviceResponse;
        }*/

        serviceResponse.setSuccess(true);
        serviceResponse.setMessage("Well done");
        return serviceResponse;
    }

    @Override
    public ServiceResponse validateItems(PlaceAnOrder po) {
       /* if (!processPO.validateCodeRange(po.getProducts())) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("The product code is  between"
                    + " 239 – 384, and it is not acceptable");
            return serviceResponse;
        }
        if (!processPO.validateQuantity(po.getProducts())) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("The quantity of the product is not greater than zero");
            return serviceResponse;
        }*/
        serviceResponse.setSuccess(true);
        serviceResponse.setMessage("Well done");
        return serviceResponse;
    }

    @Override
    public ServiceResponse updateInventory(PlaceAnOrder po) {
        PurchaseOrder porder = createPurchaseOrder();
        setOrderDetail(po.getProducts(),porder);
        serviceResponse.setSuccess(true);
        serviceResponse.setMessage("Inventory Updated");
        return serviceResponse;
    }

    private PurchaseOrder createPurchaseOrder() {
        PurchaseOrder porder = new PurchaseOrder(new ReserveFundByCC(),new PayByCC());
        return purchaseOrderService.save(porder);
    }

    private Product updateProduct(Product product, Integer quantity) {
        product.adjustStock(quantity);
        return productService.save(product);
    }

    private void setOrderDetail(Set<ProductDto> items, PurchaseOrder po) {
        OrderDetail odetail;
        for (ProductDto i: items) {
            odetail = new OrderDetail();
            Product productDB = productService.findById(i.getId());
            productDB = updateProduct(productDB, i.getQuantity());
            odetail.setProduct(productDB);
            odetail.setOrder(po);
            odetail.setPrice(i.getPrice());
            odetail.setQuantity(i.getQuantity());
            orderDetailService.save(odetail);
        }
    }
}

