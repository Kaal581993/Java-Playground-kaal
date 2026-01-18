package app.utility;

import app.exceptions.ValidationException;

@FunctionalInterface
public interface Validation <T>{

    void validate(T value) throws ValidationException;
}
