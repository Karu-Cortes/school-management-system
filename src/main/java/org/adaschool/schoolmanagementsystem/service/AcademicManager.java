package org.adaschool.schoolmanagementsystem.service;

import org.adaschool.schoolmanagementsystem.model.entity.Course;
import org.adaschool.schoolmanagementsystem.model.entity.Student;
import org.adaschool.schoolmanagementsystem.model.exception.CourseNotFoundException;
import org.adaschool.schoolmanagementsystem.model.exception.StudentAlreadyInscribedException;
import org.adaschool.schoolmanagementsystem.model.exception.StudentNotEnrolledInCourseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcademicManager implements IServiciosAcademicos{

    //creación de listas de las entidades Student y Course
    private List<Student> students;
    private List<Course> courses;

    //Creación de HashMap para mantener la lista de estudiantes inscritos en cada curso
    private Map<Student, Course> enrolledStudents;

    //Constructor
    /*en el cosntructor lo iniciamos con los tres atributos, donde Students y courses se instancian con ArrayList y enrolledStudents con HashMap
     * para el almacenamiento de estos datos */
    public AcademicManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        enrolledStudents = new HashMap<>();
    }

    // traemos los metodos implementados de la interfaz
    @Override
    public void enrollStudent(Student student) {

    }

    @Override
    public void addCourse(Course course) {

    }

    @Override
    public void registerStudentCourse(Student student, Integer courseId) throws StudentAlreadyInscribedException, CourseNotFoundException {

    }

    @Override
    public void unsubscribeStudentCourse(Integer studentId, Integer courseId) throws StudentNotEnrolledInCourseException {

    }
}
