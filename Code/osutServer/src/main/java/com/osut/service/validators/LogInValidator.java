package com.osut.service.validators;

import com.osut.entity.Writer;

public class LogInValidator {

    public boolean validateLogIn(Writer writer, String password) {
        if (writer == null) {
            return false;
        }

        if (!writer.getPassword().equals(password)) {
            return false;
        }

        return true;
    }
}
