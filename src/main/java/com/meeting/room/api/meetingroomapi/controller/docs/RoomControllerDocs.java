package com.meeting.room.api.meetingroomapi.controller.docs;

import com.meeting.room.api.meetingroomapi.dto.request.RoomRequestDto;
import com.meeting.room.api.meetingroomapi.dto.response.RoomResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api("Manages rooms")
public interface RoomControllerDocs {

    @ApiOperation(value = "Returns a list of all rooms registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all rooms registered in the system"),
    })
    ResponseEntity<Page<RoomResponseDto>> index(Pageable page);

    @ApiOperation(value = "Returns room found by a given id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success room found in the system"),
            @ApiResponse(code = 404, message = "Room with given name not found.")
    })
    ResponseEntity<RoomResponseDto> show(@PathVariable Long id);

    @ApiOperation(value = "Room creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success room creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    ResponseEntity<RoomResponseDto> store(@RequestBody @Valid RoomRequestDto roomRequestDto);

    @ApiOperation(value = "Update a room found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success room update in the system"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value."),
            @ApiResponse(code = 404, message = "Room with given id not found.")
    })
    ResponseEntity<RoomResponseDto> update(@PathVariable Long id, @RequestBody @Valid RoomRequestDto roomRequestDto);

    @ApiOperation(value = "Delete a room found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success room deleted in the system"),
            @ApiResponse(code = 404, message = "Room with given id not found.")
    })
    ResponseEntity<?> destroy(@PathVariable Long id);
}
