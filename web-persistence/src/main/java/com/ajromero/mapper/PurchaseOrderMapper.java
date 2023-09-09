package com.ajromero.mapper;

import com.ajromero.domain.dto.ProductDto;
import com.ajromero.domain.dto.PurchaseOrderDto;
import com.ajromero.domain.entity.OrderDetail;
import com.ajromero.domain.entity.Product;
import com.ajromero.domain.entity.PurchaseOrder;
import com.ajromero.service.IProductService;
import com.ajromero.utils.PayByCC;
import com.ajromero.utils.ReserveFundByCC;
import java.util.Set;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderMapper implements Function<PurchaseOrderDto, PurchaseOrder> {
    @Autowired
    private IProductService productService;

    @Override
    public PurchaseOrder apply(PurchaseOrderDto purchaseOrderDto) {
        PurchaseOrder purchaseOrder = new PurchaseOrder(new ReserveFundByCC(),new PayByCC());
        detailMapper(purchaseOrder,purchaseOrderDto.getProducts());
        return purchaseOrder;
    }

    private void detailMapper(PurchaseOrder purchaseOrder, Set<ProductDto> items) {
        OrderDetail odetail;
        for (ProductDto i : items) {
            Product productDB = productService.findById(i.getId());
            odetail = instanceOrderDetail(productDB, i.getPrice(), i.getQuantity());
            purchaseOrder.addOrderDetail(odetail);
        }
    }

    private OrderDetail instanceOrderDetail(Product product,
                                            double price, Integer quantity) {
        return new OrderDetail(quantity, price, product);
    }
}
