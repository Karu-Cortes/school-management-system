package org.adaschool.schoolmanagementsystem;

import org.adaschool.schoolmanagementsystem.model.entity.Course;
import org.adaschool.schoolmanagementsystem.model.entity.Student;
import org.adaschool.schoolmanagementsystem.model.enums.Status;
import org.adaschool.schoolmanagementsystem.model.enums.Version;
import org.adaschool.schoolmanagementsystem.model.exception.CourseNotFoundException;
import org.adaschool.schoolmanagementsystem.model.exception.StudentAlreadyInscribedException;
import org.adaschool.schoolmanagementsystem.model.exception.StudentNotEnrolledInCourseException;
import org.adaschool.schoolmanagementsystem.model.exception.StudentNotFoundException;
import org.adaschool.schoolmanagementsystem.service.AcademicManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SchoolManagementSystemApplication {

	public static void main(String[] args) throws StudentAlreadyInscribedException, StudentNotEnrolledInCourseException {
		AcademicManager academicManager = new AcademicManager();

		Student student = new Student(1, "Andrea", "Gonzalez", LocalDate.of(2000, 1, 15), Status.GRADUADO);
		Student student2 = new Student(2, "Cecilia", "Torres", LocalDate.of(1993, 3, 21), Status.INACTIVO);
		Course course = new Course(1, "Java", "Curso sobre fundamentos en Java SE", 3, Version.VERSION1);
		Course course2 = new Course(2, "Base de datos", "Curso sobre fundamentos en Base de datos", 3, Version.VERSION2);

		academicManager.enrollStudent(student);
		academicManager.addCourse(course);
		academicManager.enrollStudent(student2);
		academicManager.addCourse(course2);

		try {
			academicManager.registerStudentCourse(student, 1);
			academicManager.registerStudentCourse(student, 2);
			academicManager.registerStudentCourse(student2, 1);
			academicManager.registerStudentCourse(student2, 2);
			academicManager.registerStudentCourse(student, 3); //disparar la excepciones

		} catch (StudentAlreadyInscribedException |CourseNotFoundException  e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			academicManager.unsubscribeStudentCourse(1, 1);
			academicManager.unsubscribeStudentCourse(1, 2);
			academicManager.unsubscribeStudentCourse(2, 1);
			academicManager.unsubscribeStudentCourse(2, 2);
			academicManager.unsubscribeStudentCourse(1, 3); //disparar la excepciones

		} catch (StudentNotFoundException | StudentNotEnrolledInCourseException | CourseNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
        }

    }
}

