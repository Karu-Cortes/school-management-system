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
        if (students.contains(student)) {
            System.out.println("El estudiante ya se encuentra registrado");
        } else {
            students.add(student);
            System.out.println("El estudiante " + student.getName()+" "+student.getFirstName()+ " se ha registrado de forma exitosa");
        }
    }

    @Override
    public void addCourse(Course course) {
        if (courses.contains(course)) {
            System.out.println("El curso en mención, ya se encuentra registrado");
        } else {
            courses.add(course);
            System.out.println("El curso " + course.getName()+ " se ha registrado de forma exitosa");
        }
    }

    @Override
    public void registerStudentCourse(Student student, Integer courseId) throws StudentAlreadyInscribedException, CourseNotFoundException {
        if (enrolledStudents.containsKey(student)) {
            throw new StudentAlreadyInscribedException("El estudiante ya está inscrito en un curso");
        }


        Course course = findCourseById(courseId);


        if (course == null) {
            System.out.println("No se encontró el curso con el ID ingresado");
            return;
        }


        enrolledStudents.put(student, course);
        System.out.println("El estudiante " + student.getName() + " " + student.getFirstName() +
                " se ha inscrito en el curso " + course.getName() + " de forma exitosa");

    }

    @Override
    public void unsubscribeStudentCourse(Integer studentId, Integer courseId) throws StudentNotEnrolledInCourseException {

    }

    private Course findCourseById(Integer courseId) throws CourseNotFoundException {
        for (Course course : courses) {
            if (course.getId()== courseId) {
                return course;
            }
        }
        throw new CourseNotFoundException("No se encontró el curso con el ID ingresado");
    }

}

