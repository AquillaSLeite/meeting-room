package com.meeting.room.api.meetingroomapi.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meeting.room.api.meetingroomapi.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseDto {

    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date startHour;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date endHour;

    public static RoomResponseDto fromResource(Room room) {
        return new RoomResponseDto(room.getId(),
                                   room.getName(),
                                   room.getDate(),
                                   room.getStartHour(),
                                   room.getEndHour());
    }
}
