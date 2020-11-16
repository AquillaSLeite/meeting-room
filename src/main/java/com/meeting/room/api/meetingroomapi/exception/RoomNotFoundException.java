package com.meeting.room.api.meetingroomapi.exception;

public class RoomNotFoundException extends BusinessException {
    public RoomNotFoundException(Long id) {
        super("id", String.format("Room with id %s not found in the system.", id), 404, "RoomNotFoundException");
    }
}
