package com.yassine.Gestion_Formation.exceptions;

public class ClasseNotFoundException extends RuntimeException {

    public ClasseNotFoundException(Long id) {
        super("Classe not found with ID: " + id);
    }
}
