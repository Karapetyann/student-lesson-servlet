package com.example.studentlessonservlet.servlet;

import com.example.studentlessonservlet.manager.LessonManager;
import com.example.studentlessonservlet.model.Lesson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

@WebServlet(urlPatterns = "/addLesson")
public class AddLesson extends HttpServlet {
    LessonManager lessonManager = new LessonManager();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addLesson.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("lessonName");
        Date lessonDuration = null;
        int duration = Integer.parseInt(req.getParameter("lessonDuration"));
        String lecturerName = req.getParameter("lessonLecturerName");
        double price = Double.parseDouble(req.getParameter("lessonPrice"));
        lessonManager.add(Lesson.builder()
                        .name(name)
                        .duration(duration)
                        .lecturerName(lecturerName)
                        .price(price)
                .build());
        resp.sendRedirect("/lessons");
    }
}
