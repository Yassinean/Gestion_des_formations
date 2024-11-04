package com.yassine.Gestion_Formation.exceptions;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(Long id) {
        super("Course not found with ID : " + id);
    }
}
