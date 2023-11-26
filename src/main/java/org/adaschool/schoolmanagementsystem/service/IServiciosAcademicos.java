package org.adaschool.schoolmanagementsystem.service;

import org.adaschool.schoolmanagementsystem.model.entity.Course;
import org.adaschool.schoolmanagementsystem.model.entity.Student;
import org.adaschool.schoolmanagementsystem.model.exception.CourseNotFoundException;
import org.adaschool.schoolmanagementsystem.model.exception.StudentAlreadyInscribedException;
import org.adaschool.schoolmanagementsystem.model.exception.StudentNotEnrolledInCourseException;
import org.adaschool.schoolmanagementsystem.model.exception.StudentNotFoundException;

public interface IServiciosAcademicos {

    void enrollStudent(Student student);
    void addCourse(Course course);


    //los últimos dos metodos, deben tener excepciones
    void registerStudentCourse(Student student, Integer courseId) throws StudentAlreadyInscribedException, CourseNotFoundException;

    void unsubscribeStudentCourse(Integer studentId, Integer courseId) throws StudentNotEnrolledInCourseException, CourseNotFoundException, StudentNotFoundException;
}
