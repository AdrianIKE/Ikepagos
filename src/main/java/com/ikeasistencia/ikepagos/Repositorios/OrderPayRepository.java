package com.ikeasistencia.ikepagos.Repositorios;

import com.ikeasistencia.ikepagos.Entidades.Order_Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPayRepository extends  JpaRepository<Order_Pay,Integer>{
    
}
