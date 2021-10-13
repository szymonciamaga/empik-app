package pl.empik.empik.handlers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final String ERROR_MESSAGE_DELIMITER = " - ";

    @ExceptionHandler(BindException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public List<String> handleValidationException(final BindException exception) {
        return createErrorList(exception.getBindingResult());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleEntityNotFoundException(final EntityNotFoundException exception) {
        return exception.getMessage();
    }

    private final Function<FieldError, String> errorMessageFormatter =
            error -> error.getField() + ERROR_MESSAGE_DELIMITER + error.getDefaultMessage();

    private List<String> createErrorList(final BindingResult bindingResult) {
        return bindingResult
                .getAllErrors()
                .stream()
                .filter(error -> error instanceof FieldError)
                .map(objectError -> (FieldError) objectError)
                .map(errorMessageFormatter)
                .collect(Collectors.toList());
    }
}
