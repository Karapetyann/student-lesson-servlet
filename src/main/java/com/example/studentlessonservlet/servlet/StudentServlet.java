package com.example.studentlessonservlet.servlet;

import com.example.studentlessonservlet.manager.StudentManager;
import com.example.studentlessonservlet.model.Lesson;
import com.example.studentlessonservlet.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/students")

public class StudentServlet extends HttpServlet {
    private StudentManager studentManager = new StudentManager();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentManager.getStudents();
        req.setAttribute("students",students);
        req.getRequestDispatcher("/WEB-INF/students.jsp").forward(req,resp);
    }



}
