package com.meeting.room.api.meetingroomapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BusinessException extends RuntimeException {
    private String field;
    private String error;
    private Integer code;
    private String exception;
}
