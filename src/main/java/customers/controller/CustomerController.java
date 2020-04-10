package customers.controller;

import customers.entity.Customer;
import customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CustomerController {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/")
    public String welcomePage(Model model) {
        model.addAttribute("date", new java.util.Date());
        return "index";
    }

    @GetMapping(value = "/customers")
    public String getCustomer(Model model) {
        List<Customer> customerList = customerRepository.findAll();
        if (customerList != null) {
            model.addAttribute("customers", customerList);
        }
        return "customers";
    }

    @GetMapping(value = "/customers/add")
    public String formToAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customerForm";
    }

    @PostMapping(value = "/customers/submit")
    public String addToCustomer(String name, Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @GetMapping(value = "/customers/login")
    public String showLoginPage() {
        return "customerForm";
    }
}