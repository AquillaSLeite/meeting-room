package com.meeting.room.api.meetingroomapi.controller;

import com.meeting.room.api.meetingroomapi.controller.docs.RoomControllerDocs;
import com.meeting.room.api.meetingroomapi.dto.request.RoomRequestDto;
import com.meeting.room.api.meetingroomapi.dto.response.RoomResponseDto;
import com.meeting.room.api.meetingroomapi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.meeting.room.api.meetingroomapi.controller.UtilController.generatedUri;

@RestController
@RequestMapping("api/v1/rooms")
@Validated
public class RoomController implements RoomControllerDocs {

    @Autowired
    RoomService roomService;

    @GetMapping
    public ResponseEntity<Page<RoomResponseDto>> index(Pageable page) {
        return ResponseEntity.ok().body(this.roomService.findAll(page));
    }

    @GetMapping("{id}")
    public ResponseEntity<RoomResponseDto> show(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.roomService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RoomResponseDto> store(@RequestBody @Valid RoomRequestDto roomRequestDto) {
        RoomResponseDto roomResponseDto = this.roomService.store(roomRequestDto);

        return ResponseEntity.created(generatedUri(roomResponseDto.getId())).body(roomResponseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<RoomResponseDto> update(@PathVariable Long id, @RequestBody @Valid RoomRequestDto roomRequestDto) {
        return ResponseEntity.ok().body(this.roomService.update(id, roomRequestDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        this.roomService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
