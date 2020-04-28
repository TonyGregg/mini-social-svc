package com.genil.learning.minisocialsvc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Antony Genil on 4/27/2020 at 11:01 AM, for project - mini-social-svc.
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String errorMessage;
    private int errorCode;
}
