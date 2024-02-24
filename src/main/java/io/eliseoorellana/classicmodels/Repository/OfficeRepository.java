package io.eliseoorellana.classicmodels.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.eliseoorellana.classicmodels.model.Office;

@Repository
public interface OfficeRepository  extends JpaRepository<Office, Long>{

    List<Office> findAll(Sort sort);

}
