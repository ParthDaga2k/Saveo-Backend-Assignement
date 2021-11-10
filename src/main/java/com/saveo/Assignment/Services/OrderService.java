package com.saveo.Assignment.Services;

import com.saveo.Assignment.Repositories.OrderRepository;
import com.saveo.Assignment.models.Order;
import com.saveo.Assignment.models.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;
    public String placeOrder(OrderRequest request){
        Order order = new Order(request.getcUniqueId(),request.getQuantity(),request.getcName());
        String message = "";
        try {
            message = Integer.toString(repository.save(order).getOrderId());
        } catch (Exception e){
            System.out.println(e.getMessage());
            message = "Failed";
        }
        return message;
    }
}

