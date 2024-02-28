package io.eliseoorellana.classicmodels.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.eliseoorellana.classicmodels.model.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String>{

   

    List<Office> findByDeletedFalse();

    @Query("SELECT DISTINCT o.country FROM Office o")
    List<String> findDistinctCountries();
}
