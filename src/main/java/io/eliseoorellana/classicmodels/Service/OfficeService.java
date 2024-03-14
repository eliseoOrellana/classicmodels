package io.eliseoorellana.classicmodels.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.eliseoorellana.classicmodels.model.Office;
import io.eliseoorellana.classicmodels.repository.OfficeRepository;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> getAllOffices() {
        try {
            return officeRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Office getOfficeByCode(String officeCode) {
        try {
            Optional<Office> officeOptional = officeRepository.findById(officeCode);
            return officeOptional.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveOrUpdate(Office office) {
        try {
            officeRepository.save(office);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String officeCode) {
        try {
            officeRepository.deleteById(officeCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void softDeleteOffice(String officeCode) {
        Office office = officeRepository.findById(officeCode).orElse(null);
        if (office != null) {
            office.setDeleted(true);
            officeRepository.save(office);
        }
    }

    public List<String> findDistinctCountries() {
        return officeRepository.findDistinctCountries();
    }

}
