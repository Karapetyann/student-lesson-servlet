package com.example.studentlessonservlet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    private int id;
    private String name;
    private int duration;
    private String lecturerName;
    private double price;
    private String picName;
}
