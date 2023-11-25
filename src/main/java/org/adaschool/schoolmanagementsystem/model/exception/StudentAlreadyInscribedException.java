package org.adaschool.schoolmanagementsystem.model.exception;

public class StudentAlreadyInscribedException extends Exception{
    public StudentAlreadyInscribedException(String mensaje) {
        super(mensaje);
    }
}
