package com.meeting.room.api.meetingroomapi.service;

import com.meeting.room.api.meetingroomapi.dto.request.RoomRequestDto;
import com.meeting.room.api.meetingroomapi.dto.response.RoomResponseDto;
import com.meeting.room.api.meetingroomapi.exception.RoomNotFoundException;
import com.meeting.room.api.meetingroomapi.model.Room;
import com.meeting.room.api.meetingroomapi.repository.RoomRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.meeting.room.api.meetingroomapi.dto.response.RoomResponseDto.*;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public Page<RoomResponseDto> findAll(final Pageable page) {
        final PageRequest pageRequest = PageRequest.of(page.getPageNumber(), page.getPageSize(), page.getSort());

        final List<RoomResponseDto> roomResponseDto = roomRepository
                .findAll(pageRequest)
                .stream()
                .map(RoomResponseDto::fromResource)
                .collect(Collectors.toList());

        return new PageImpl<>(roomResponseDto, pageRequest, page.getPageSize());
    }

    public RoomResponseDto findById(Long id){
        return fromResource(this.verifyIfExistsById(id));
    }

    public RoomResponseDto store(RoomRequestDto roomRequestDto) {
        Room room = this.roomRepository.save(roomRequestDto.toResource());
        return fromResource(room);
    }

    public RoomResponseDto update(Long id, RoomRequestDto roomRequestDto) {
        Room room = this.verifyIfExistsById(id);
        BeanUtils.copyProperties(roomRequestDto.toResource(), room, "id");

        return fromResource(this.roomRepository.save(room));
    }

    public void delete(Long id){
        this.roomRepository.delete(this.verifyIfExistsById(id));
    }

    private Room verifyIfExistsById(Long id){
        return this.roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
    }
}
