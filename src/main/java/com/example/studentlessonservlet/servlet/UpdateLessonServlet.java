package com.example.studentlessonservlet.servlet;

import com.example.studentlessonservlet.manager.LessonManager;
import com.example.studentlessonservlet.manager.UserManager;
import com.example.studentlessonservlet.model.Lesson;
import com.example.studentlessonservlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = "/updateLesson")
public class UpdateLessonServlet extends HttpServlet {
    private LessonManager lessonManager = new LessonManager();
    private UserManager userManager = new UserManager();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Lesson lesson = lessonManager.getById(id);
        req.setAttribute("lesson", lesson);
        req.getRequestDispatcher("/WEB-INF/updateLesson.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int id = Integer.parseInt(req.getParameter("lessonId"));
            String name = req.getParameter("lessonName");
            int duration = Integer.parseInt(req.getParameter("lessonDuration"));
            String lecturerName = req.getParameter("lessonLecturerName");
            double price = Double.parseDouble(req.getParameter("lessonPrice"));
            String picName = req.getParameter("lessonPicName");
            User user = (User) req.getSession().getAttribute("user");
            lessonManager.update(Lesson.builder()
                    .id(id)
                    .name(name)
                    .duration(duration)
                    .lecturerName(lecturerName)
                    .price(price)
                    .picName(picName)
                    .user(user)
                    .build());
            resp.sendRedirect("/lessons");
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
