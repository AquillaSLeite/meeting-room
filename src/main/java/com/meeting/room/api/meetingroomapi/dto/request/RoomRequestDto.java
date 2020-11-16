package com.meeting.room.api.meetingroomapi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meeting.room.api.meetingroomapi.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequestDto {

    @NotBlank
    @Size(min = 5, max = 100)
    private String name;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date startHour;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date endHour;

    public Room toResource(){
        return new Room(null, this.name, this.date, this.startHour, this.endHour);
    }
}
