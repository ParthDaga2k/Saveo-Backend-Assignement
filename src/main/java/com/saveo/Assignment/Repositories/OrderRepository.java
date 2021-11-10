package com.saveo.Assignment.Repositories;

import com.saveo.Assignment.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

}
