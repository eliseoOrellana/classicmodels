package io.eliseoorellana.classicmodels.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.eliseoorellana.classicmodels.model.Office;
import io.eliseoorellana.classicmodels.service.OfficeService;

@Controller
@RequestMapping("/offices")
public class OfficeController {

private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public String getAllOffices(Model model) {
        model.addAttribute("offices", officeService.getAllOffices());
        
        return "employees";
    }

    @GetMapping("/{officeCode}")
    public Office getOfficeByCode(@PathVariable String officeCode) {
        return officeService.getOfficeByCode(officeCode);
    }

    @PostMapping
    public void createOrUpdateOffice(@RequestBody Office office) {
        officeService.saveOrUpdate(office);
    }

    @DeleteMapping("/{officeCode}")
    public void deleteOffice(@PathVariable String officeCode) {
        officeService.delete(officeCode);
    }

    @GetMapping("/soft-delete/{officeCode}")
    public String softDeleteOffice(@PathVariable("officeCode") String officeCode) {
        officeService.softDeleteOffice(officeCode);
        return "redirect:/offices";
    }

}
