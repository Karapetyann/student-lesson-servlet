package com.example.studentlessonservlet.servlet;

import com.example.studentlessonservlet.manager.LessonManager;
import com.example.studentlessonservlet.manager.StudentManager;
import com.example.studentlessonservlet.manager.UserManager;
import com.example.studentlessonservlet.model.Lesson;
import com.example.studentlessonservlet.model.Student;
import com.example.studentlessonservlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
    private StudentManager studentManager = new StudentManager();
    private LessonManager lessonManager = new LessonManager();
    private UserManager userManager = new UserManager();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lesson> lessons = lessonManager.getLessons();
        req.setAttribute("lessons", lessons);
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentManager.getById(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("/WEB-INF/updateStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int id = Integer.parseInt(req.getParameter("studentId"));
            String name = req.getParameter("studentName");
            String surname = req.getParameter("studentSurname");
            String email = req.getParameter("studentEmail");
            int age = Integer.parseInt(req.getParameter("studentAge"));
            String picName = req.getParameter("studentPicName");
            int lessonId = Integer.parseInt(req.getParameter("lessonId"));
            Lesson lesson = lessonManager.getById(lessonId);
            User user = (User) req.getSession().getAttribute("user");
            studentManager.update(Student.builder()
                    .id(id)
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .age(age)
                    .picName(picName)
                    .lesson(lesson)
                    .user(user)
                    .build());
            resp.sendRedirect("/students");
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
