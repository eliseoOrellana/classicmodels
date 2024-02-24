package io.eliseoorellana.classicmodels.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.eliseoorellana.classicmodels.model.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String>{

   
}
