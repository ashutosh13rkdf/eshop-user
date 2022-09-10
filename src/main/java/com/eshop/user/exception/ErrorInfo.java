package com.eshop.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {
    private int errorCode;
    private String errorMsg;
    private String errorDetails;
    private Map<String, String> errors;

    public ErrorInfo(int errorCode, String errorMsg, String errorDetails) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.errorDetails = errorDetails;
    }

    public ErrorInfo(int errorCode, String errorMsg, Map<String, String> errors) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.errors = errors;
    }
}