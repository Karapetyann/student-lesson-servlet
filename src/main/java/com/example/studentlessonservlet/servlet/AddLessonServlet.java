package com.example.studentlessonservlet.servlet;

import com.example.studentlessonservlet.manager.LessonManager;
import com.example.studentlessonservlet.manager.UserManager;
import com.example.studentlessonservlet.model.Lesson;
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
import java.sql.Date;

@WebServlet(urlPatterns = "/addLesson")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 5,//5mb
        maxRequestSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 1
)
public class AddLessonServlet extends HttpServlet {
    private LessonManager lessonManager = new LessonManager();
    private UserManager userManager = new UserManager();
    private final String UPLOAD_DIRECTORY = "C:\\Users\\Hakob\\IdeaProjects\\student-lesson-servlet\\uploadDirectory";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addLesson.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("lessonName");
        Date lessonDuration = null;
        int duration = Integer.parseInt(req.getParameter("lessonDuration"));
        String lecturerName = req.getParameter("lessonLecturerName");
        double price = Double.parseDouble(req.getParameter("lessonPrice"));
        Part picture = req.getPart("picture");
        String pictureName = null;
        if (picture != null && picture.getSize() > 0) {
            pictureName = System.currentTimeMillis() + "_" + picture.getSubmittedFileName();
            picture.write(UPLOAD_DIRECTORY + File.separator + pictureName);
        }
        User user = (User) req.getSession().getAttribute("user");
        Lesson byName = lessonManager.getByName(name);
        if (byName == null) {
            lessonManager.add(Lesson.builder()
                    .name(name)
                    .duration(duration)
                    .lecturerName(lecturerName)
                    .price(price)
                    .picName(pictureName)
                    .user(user)
                    .build());
            resp.sendRedirect("/lessons");
        } else {
            req.getSession().setAttribute("msg", "This name is already in use");
            resp.sendRedirect("/");
        }
    }
}
