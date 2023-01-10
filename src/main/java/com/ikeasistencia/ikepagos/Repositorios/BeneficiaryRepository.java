package com.ikeasistencia.ikepagos.Repositorios;

import com.ikeasistencia.ikepagos.Entidades.Beneficiary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BeneficiaryRepository  extends  JpaRepository<Beneficiary,Integer> {

    @Query(value="SELECT * FROM beneficiary_ikepagos order by id_beneficiary desc limit 1;",nativeQuery=true)
    Beneficiary findLast();
    
}
