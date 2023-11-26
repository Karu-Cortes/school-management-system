package org.adaschool.schoolmanagementsystem.service;

import org.adaschool.schoolmanagementsystem.model.entity.Course;
import org.adaschool.schoolmanagementsystem.model.entity.Student;
import org.adaschool.schoolmanagementsystem.model.exception.CourseNotFoundException;
import org.adaschool.schoolmanagementsystem.model.exception.StudentAlreadyInscribedException;
import org.adaschool.schoolmanagementsystem.model.exception.StudentNotEnrolledInCourseException;
import org.adaschool.schoolmanagementsystem.model.exception.StudentNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcademicManager implements IServiciosAcademicos{

    //creación de listas de las entidades Student y Course
    private List<Student> students;
    private List<Course> courses;

    //Creación de HashMap para mantener la lista de estudiantes inscritos en cada curso

    Map<Student, List<Course>> enrolledStudents;

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

    /* este metodo nos permite validar y crear un nuevo estudiante, verifiamos que
    el estudiante no se encuentre en la colección students que contiene (contains) el estudiante student  y agregamos
    con Students.add(student) esos datos.
    * a la final se envia el mensaje de confirmación, donde por medio de los get traemos los datos de nombre y apellido*/

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

        Course course = findCourseById(courseId);

        if (course == null) {
            System.out.println("No se encontró el curso con el ID ingresado");
            return;
        }

        List<Course> studentCourses = enrolledStudents.get(student);
        if (studentCourses != null && studentCourses.contains(course)) {
            throw new StudentAlreadyInscribedException("El estudiante ya está inscrito en el curso");
        }

        if (studentCourses == null) {
            studentCourses = new ArrayList<>();
            enrolledStudents.put(student, studentCourses);
        }

        studentCourses.add(course);

        System.out.println("El estudiante " + student.getName() + " " + student.getFirstName() +
                " se ha inscrito en el curso " + course.getName() + " de forma exitosa");

    }

    @Override
    public void unsubscribeStudentCourse(Integer studentId, Integer courseId) throws StudentNotEnrolledInCourseException, CourseNotFoundException, StudentNotFoundException {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        List<Course> studentCourses = enrolledStudents.get(student);

        if (studentCourses == null || !studentCourses.contains(course)) {
            throw new StudentNotEnrolledInCourseException("El estudiante no está inscrito en el curso");
        }

        studentCourses.remove(course);

        System.out.println("El estudiante " + student.getName() + " " + student.getFirstName() +
                " se ha desinscrito del curso " + course.getName() + " de forma exitosa");
    }

    private Course findCourseById(Integer courseId) throws CourseNotFoundException {
        for (Course course : courses) {
            if (course.getId()== courseId) {
                return course;
            }
        }
        throw new CourseNotFoundException("No se encontró el curso con el ID ingresado");
    }

    private Student findStudentById(Integer studentId) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        throw new StudentNotFoundException("No se encontró el estudiante con el ID ingresado");
    }
}

