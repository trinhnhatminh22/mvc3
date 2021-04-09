package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.User;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;




@Controller
public class HomController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String welcome(Model model) {
        String message = "Hello Spring Boot + JSP";
        model.addAttribute("message", message);
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "index";
    }
    @GetMapping("/signin")
    public String signIn() {
        return "signin";
    }

    @GetMapping("employee")
    public String showCreateForm(){
        return "createemployee";
    }

    @PostMapping("/")
    public String showInfo(@ModelAttribute("user") User user, ModelMap model) {
        if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            model.addAttribute("error", "Please input email/password");
            return "redirect:/signin";
        }
        if (userService.validateLogin(user)) {
            model.addAttribute("logged", true);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Wrong email/password");
            return "signin";
        }

    }

    @PostMapping("/employee")
    public String createEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        if(employee.getName().isEmpty()){
            return "createemployee";
        }else{
            employeeService.createEmployee(employee);
            return "redirect:/";
        }
    }

    @RequestMapping (value = "/employee/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") String id){
       employeeService.deleteEmployee(Long.parseLong(id));
       return "index";

    }
}
