package com.ajromero.mapper;

import com.ajromero.domain.dto.ProductDto;
import com.ajromero.domain.dto.PurchaseOrderDto;
import com.ajromero.domain.entity.OrderDetail;
import com.ajromero.domain.entity.Product;
import com.ajromero.domain.entity.PurchaseOrder;
import com.ajromero.domain.payment.PayByCC;
import com.ajromero.domain.payment.ReserveFundByCC;
import com.ajromero.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Function;

@Service
public class PurchaseOrderMapper implements Function<PurchaseOrderDto, PurchaseOrder> {
    @Autowired
    private IProductService productService;
    @Override
    public PurchaseOrder apply(PurchaseOrderDto purchaseOrderDto) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setFundReservedCode(new ReserveFundByCC().reserveFunds());
        purchaseOrder.setPaymentCode(new PayByCC().pay());
        detailMapper(purchaseOrder,purchaseOrderDto.getProducts());
        return purchaseOrder;
    }

    private void detailMapper(PurchaseOrder purchaseOrder, Set<ProductDto> items) {
        OrderDetail odetail;
        for (ProductDto i: items) {
            odetail = new OrderDetail();
            Product productDB = productService.findById(i.getId());
            odetail.setProduct(productDB);
            odetail.setPrice(i.getPrice());
            odetail.setQuantity(i.getQuantity());
            purchaseOrder.addOrderDetail(odetail);
        }

    }
}
