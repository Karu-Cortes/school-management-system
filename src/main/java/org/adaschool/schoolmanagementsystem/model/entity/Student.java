package org.adaschool.schoolmanagementsystem.model.entity;

public class Student {
    public class Student extends Person {

        //Atributos
        private Status status;

        //Constructor
        public Student(int id, String name, String firstName, LocalDate dateOfBirth, Status status) {
            super(id, name, firstName, dateOfBirth);
            this.status = status;
        }

        //getters y setters


        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }


    }

}
