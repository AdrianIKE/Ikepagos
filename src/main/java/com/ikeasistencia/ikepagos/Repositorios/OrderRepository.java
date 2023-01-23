package com.ikeasistencia.ikepagos.Repositorios;

import com.ikeasistencia.ikepagos.Entidades.Order;


import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends  JpaRepository<Order,Integer>{
    
    Order findByIdPay(String id_pay);


}
