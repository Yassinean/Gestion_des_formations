package com.yassine.Gestion_Formation.exceptions;

public class FormateurNotFoundException extends RuntimeException {

    public FormateurNotFoundException(Long id) {
        super("Formateur not found with id: " + id);
    }
}
