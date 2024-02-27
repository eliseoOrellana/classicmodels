package io.eliseoorellana.classicmodels.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.eliseoorellana.classicmodels.Service.EmployeeService;
import io.eliseoorellana.classicmodels.Service.OfficeService;
import io.eliseoorellana.classicmodels.model.Employee;
import io.eliseoorellana.classicmodels.model.Office;


@Controller
@RequestMapping("/sales-manager")
public class SalesManagerController {

@Autowired
    private EmployeeService employeeService;

    @Autowired
    private OfficeService officeService;
    

   @GetMapping
    public String getAllEmployees(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("employee", new Employee());
        model.addAttribute("offices", officeService.getAllOffices());
        model.addAttribute("office", new Office());
        return "sales-manager";
    }

}
