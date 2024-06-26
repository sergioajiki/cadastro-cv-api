package com.cadastrorh.cadastroRHapi.advice;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.cadastrorh.cadastroRHapi.dto.ErrorMessageDto;
import com.cadastrorh.cadastroRHapi.exception.DuplicateEntryException;
import com.cadastrorh.cadastroRHapi.exception.InvalidEmailFormatException;
import com.cadastrorh.cadastroRHapi.exception.InvalidLoginException;
import com.cadastrorh.cadastroRHapi.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GeneralControllerAdvice {
    private final MessageSource messageSource;

    @Autowired
    public GeneralControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleNotFoundException(NotFoundException exception) {
        Problem problem = new Problem(
                HttpStatus.NOT_FOUND.value(),
                "Information Not Found",
                exception.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleInvalidEmailFormat(InvalidEmailFormatException exception) {
        Problem problem = new Problem(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Email Format",
                exception.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleDuplicateEntryException(DuplicateEntryException exception) {
        Problem problem = new Problem(
                HttpStatus.CONFLICT.value(),
                "Duplicate Entry Info",
                exception.getLocalizedMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Problem> handleNotFoundField(MethodArgumentNotValidException exception) {
        List<ErrorMessageDto> problemList = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(e -> {
            String detail = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorMessageDto messageDetail = new ErrorMessageDto(
                    e.getField(),
                    detail
            );
            problemList.add(messageDetail);
        });
        Problem problem = new Problem(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Parameters",
                "Invalid Request Body",
                problemList
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);

    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleInvalidLoginException(InvalidLoginException exception) {
        Problem problem = new Problem(
                HttpStatus.UNAUTHORIZED.value(),
                "Unauthorized Login",
                exception.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(problem);
    }

    @ExceptionHandler
    public ResponseEntity<Problem> JWTDecodeException(
            JWTDecodeException exception,
            HttpServletRequest request) {
        Problem problem = new Problem(
                HttpStatus.FORBIDDEN.value(),
                "Token invalid",
                "Invalid token format",
                // exception.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(problem);
    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleTokenExpiredException(
            TokenExpiredException exception,
            HttpServletRequest request) {
        Problem problem = new Problem(
                HttpStatus.FORBIDDEN.value(),
                "Token invalid or expired",
                exception.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(problem);
    }

    @ExceptionHandler
    public ResponseEntity<Problem> handlerInsufficientAuthenticationException(
            InsufficientAuthenticationException exception,
            HttpServletRequest request) {
        Problem problem = new Problem(
                HttpStatus.FORBIDDEN.value(),
                "Access Denied",
                "Authorization is required to access this resource",
                // exception.getLocalizedMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(problem);
    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleNotCaught(Exception exception) {
        Problem problem = new Problem(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                exception.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problem);
    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleSignatureVerificationException(SignatureVerificationException exception) {
        Problem problem = new Problem(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "The Token's Signature resulted invalid",
                exception.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problem);
    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleInvalidType(MethodArgumentTypeMismatchException exception) {
        Problem problem = new Problem(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Type Format",
                exception.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }
}
