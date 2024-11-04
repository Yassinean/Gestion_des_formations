package com.yassine.Gestion_Formation.exceptions;

public class FormationNotFoundException extends RuntimeException {

    public FormationNotFoundException(Long id) {
        super("Formation not found with ID: " + id);
    }
}

