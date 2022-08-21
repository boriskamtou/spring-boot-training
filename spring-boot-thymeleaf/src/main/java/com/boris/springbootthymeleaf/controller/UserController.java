package com.boris.springbootthymeleaf.controller;

import com.boris.springbootthymeleaf.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private String convertGPA(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade < 90 && grade >= 80) {
            return "B";
        } else if (grade < 80 && grade >= 70) {
            return "C";
        } else if (grade < 70 && grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    @RequestMapping("/")
    public String demo(Model model) {

        model.addAttribute("message", "Hello Thymeleaf");
        double grade = 90.5;
        model.addAttribute("grade", grade);
        model.addAttribute("GPA", convertGPA(grade));

        List<Student> students = new ArrayList<>();
        students.add(new Student("Kamtou", "Boris"));
        students.add(new Student("Dupont", "Antoine"));
        students.add(new Student("Smith", "Nate"));

        model.addAttribute("listOfStudent", students);
        return "demo";
    }

    @RequestMapping("demo3")
    public String demo3(HttpServletRequest request, Model model) {
        // Request
        request.setAttribute("request", "request data");
        // Session
        request.getSession().setAttribute("session", "session data");
        // Application
        request.getSession().getServletContext().setAttribute("application", "application data");
        return "demo2";
    }
}
