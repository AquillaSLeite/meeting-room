package com.meeting.room.api.meetingroomapi.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class StandardError {

    private Instant timestamp;
    private Integer status;
    private String path;
    private String expcetionName;
    private Map<String, String> errors = new HashMap<>();

    public StandardError(Instant timestamp, Integer status, String path, String expcetionName) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
        this.expcetionName = expcetionName;
    }
}

