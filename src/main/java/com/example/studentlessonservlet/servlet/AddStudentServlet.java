package com.example.studentlessonservlet.servlet;

import com.example.studentlessonservlet.manager.LessonManager;
import com.example.studentlessonservlet.manager.StudentManager;
import com.example.studentlessonservlet.manager.UserManager;
import com.example.studentlessonservlet.model.Lesson;
import com.example.studentlessonservlet.model.Student;
import com.example.studentlessonservlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/addStudent")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 1
)
public class AddStudentServlet extends HttpServlet {
    private StudentManager studentManager = new StudentManager();
    private LessonManager lessonManager = new LessonManager();
    private UserManager userManager = new UserManager();
    private final String UPLOAD_DIRECTORY = "C:\\Users\\Hakob\\IdeaProjects\\student-lesson-servlet\\uploadDirectory";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lesson> lessons = lessonManager.getLessons();
        req.setAttribute("lessons", lessons);
        req.getRequestDispatcher("/WEB-INF/addStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String name = req.getParameter("studentName");
            String surname = req.getParameter("studentSurname");
            String email = req.getParameter("studentEmail");
            int age = Integer.parseInt(req.getParameter("studentAge"));
            int lessonId = Integer.parseInt(req.getParameter("lesson_id"));
            Lesson byId = lessonManager.getById(lessonId);
            Part picture = req.getPart("picture");
            String pictureName = null;
            if (picture != null && picture.getSize() > 0) {
                pictureName = System.currentTimeMillis() + "_" + picture.getSubmittedFileName();
                picture.write(UPLOAD_DIRECTORY + File.separator + pictureName);
            }
            User user = (User) req.getSession().getAttribute("user");
            Student byEmail = studentManager.getByEmail(email);
            if (byEmail == null) {
                studentManager.add(Student.builder()
                        .name(name)
                        .surname(surname)
                        .email(email)
                        .age(age)
                        .lesson(byId)
                        .picName(pictureName)
                        .user(user)
                        .build());
                resp.sendRedirect("/students");
            } else {
                req.getSession().setAttribute("msg", "This email is already in use");
                resp.sendRedirect("/");
            }
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
