package com.example.studentlessonservlet.manager;

import com.example.studentlessonservlet.db.DBConnectionProvider;
import com.example.studentlessonservlet.model.Lesson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private UserManager userManager = new UserManager();


    public List<Lesson> getLessons() {
        String sql = "SELECT * FROM lesson";
        List<Lesson> lessons = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                lessons.add(Lesson.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .duration(resultSet.getInt("duration"))
                        .lecturerName(resultSet.getString("lecturerName"))
                        .price(resultSet.getDouble("price"))
                        .picName(resultSet.getString("pic_name"))
                        .user(userManager.getById(resultSet.getInt("user_id")))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lessons;
    }

    public void add(Lesson lesson) {
        String sql = "INSERT INTO lesson(name, duration, lecturerName, price, pic_name, user_id) VALUES(?,?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, lesson.getName());
            ps.setInt(2, lesson.getDuration());
            ps.setString(3, lesson.getLecturerName());
            ps.setDouble(4, lesson.getPrice());
            ps.setString(5, lesson.getPicName());
            ps.setInt(6, lesson.getUser().getId());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int anInt = generatedKeys.getInt(1);
                lesson.setId(anInt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM lesson WHERE id=" + id;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Lesson getById(int lessonId) {
        String sql = "SELECT * FROM lesson WHERE id=" + lessonId;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Lesson.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .duration(resultSet.getInt("duration"))
                        .lecturerName(resultSet.getString("lecturerName"))
                        .price(resultSet.getDouble("price"))
                        .picName(resultSet.getString("pic_name"))
                        .user(userManager.getById(resultSet.getInt("user_id")))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void update(Lesson lesson) {
        String sql = "UPDATE lesson SET name =?, duration = ?, lecturerName = ?, price = ?, pic_name = ?, user_id = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, lesson.getName());
            ps.setInt(2, lesson.getDuration());
            ps.setString(3, lesson.getLecturerName());
            ps.setDouble(4, lesson.getPrice());
            ps.setString(5, lesson.getPicName());
            ps.setInt(6, lesson.getId());
            ps.setInt(7, lesson.getUser().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Lesson getByName(String name) {
        String sql = "SELECT * FROM lesson WHERE name=" + name;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Lesson.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .duration(resultSet.getInt("duration"))
                        .lecturerName(resultSet.getString("lecturerName"))
                        .price(resultSet.getDouble("price"))
                        .picName(resultSet.getString("pic_name"))
                        .user(userManager.getById(resultSet.getInt("user_id")))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Lesson> getByUser(int id) {
        String sql = "SELECT * FROM lesson WHERE user_id=" + id;
        List<Lesson> lessons = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                lessons.add(Lesson.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .duration(resultSet.getInt("duration"))
                        .lecturerName(resultSet.getString("lecturerName"))
                        .price(resultSet.getDouble("price"))
                        .picName(resultSet.getString("pic_name"))
                        .user(userManager.getById(resultSet.getInt("user_id")))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lessons;
    }
}
