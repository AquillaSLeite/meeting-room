package com.meeting.room.api.meetingroomapi.repository;

import com.meeting.room.api.meetingroomapi.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
