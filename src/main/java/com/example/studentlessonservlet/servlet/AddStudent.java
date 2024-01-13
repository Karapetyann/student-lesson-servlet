package com.example.studentlessonservlet.servlet;

import com.example.studentlessonservlet.manager.LessonManager;
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

@WebServlet(urlPatterns = "/addStudent")
public class AddStudent extends HttpServlet {
    StudentManager studentManager = new StudentManager();
    LessonManager lessonManager = new LessonManager();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lesson> lessons = lessonManager.getLessons();
        req.setAttribute("lessons", lessons);
        req.getRequestDispatcher("/WEB-INF/addStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("studentName");
        String surname = req.getParameter("studentSurname");
        String email = req.getParameter("studentEmail");
        int age = Integer.parseInt(req.getParameter("studentAge"));
        int lessonId = Integer.parseInt(req.getParameter("lesson_id"));
        Lesson byId = lessonManager.getById(lessonId);
        studentManager.add(Student.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .age(age)
                .lesson(byId)
                .build());
        resp.sendRedirect("/students");
    }
}
