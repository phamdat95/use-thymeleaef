package com.codegym.controllers;

import com.codegym.model.Customer;
import com.codegym.service.CustomerServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    private CustomerServiceImp serviceImp = new CustomerServiceImp();
    @GetMapping(value = "/list")
    public String showList(Model model){
        model.addAttribute("list", serviceImp.findAll());

        return "list";
    }
    @GetMapping(value = "/create")
    public String createCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping(value = "/save")
    public String showCreate(Customer customer, RedirectAttributes model){
        int id = (int) (Math.random()*1000);
        customer.setId(id);
        serviceImp.save(customer);
        model.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/customer/list";
    }
    @GetMapping(value = "/edit")
    public String editCustomer(@RequestParam int id, Model model){
        model.addAttribute("customer", serviceImp.findById(id));
        return "edit";
    }
    @PostMapping(value = "/update")
    public String showEdit(Customer customer, RedirectAttributes redirectAttributes){
        serviceImp.edit(customer,customer.getId());
        redirectAttributes.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/customer/list";
    }
    @GetMapping(value = "/delete")
    public String deleteCustomer(Model model,@RequestParam int id){
        model.addAttribute("customer",serviceImp.findById(id));
        return "delete";
    }
    @PostMapping(value = "/remove")
    public String showDelete(RedirectAttributes redirectAttributes, Customer customer){
        serviceImp.delete(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Deleted customer successfully!");
        return "redirect:/customer/list";
    }
    @GetMapping(value = "/view")
    public String viewCustomer(Model model,@RequestParam int id){
        model.addAttribute("customer", serviceImp.findById(id));
        return "view";
    }
}
