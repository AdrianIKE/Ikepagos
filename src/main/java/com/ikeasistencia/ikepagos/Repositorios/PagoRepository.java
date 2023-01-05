package com.ikeasistencia.ikepagos.Repositorios;

import com.ikeasistencia.ikepagos.Entidades.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PagoRepository extends  JpaRepository<Pago,Integer>{
    
    Pago findById(Long id);

}
