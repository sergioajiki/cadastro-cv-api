package com.cadastrorh.cadastroRHapi.advice;

import com.cadastrorh.cadastroRHapi.dto.ErrorMessageDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Problem (
        int status,
        String message,
        String detail,
        List<ErrorMessageDto> errors
) {}
