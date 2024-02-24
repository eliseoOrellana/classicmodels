package io.eliseoorellana.classicmodels.Service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.eliseoorellana.classicmodels.Repository.OfficeRepository;
import io.eliseoorellana.classicmodels.model.Office;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> getAllOficinasOrderedByCity() {
        return officeRepository.findAll(Sort.by(Sort.Direction.ASC, "city"));
    }

}
