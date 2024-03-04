package com.intelygenz.api.v1.controller;

import com.intelygenz.dto.NumbersDto;
import com.intelygenz.service.FetchNumbersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class NumbersFetchController {

    private final FetchNumbersService fetchNumbersService;
    @Autowired
    public NumbersFetchController(FetchNumbersService fetchNumbersService){
        this.fetchNumbersService = fetchNumbersService;
    }
    @Operation(summary = "Gets the list of available books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the books",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
    })
    @GetMapping(path = "/numbersSorted", produces = {"application/json"})
    public ResponseEntity<List<List<Integer>>> getNumbersSorted() {

        log.info("GET /api/v1/numbersSorted");
        return ResponseEntity.ok(fetchNumbersService.getSortedNumbers());
    }

    @Operation(summary = "Get numbers list by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the number",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NumbersDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Numbers not found",
                    content = @Content) })
    @GetMapping(path = "/numbers/{numberIds}", produces = {"application/json"})
    public ResponseEntity<List<List<Integer>>> getNumbersSortedById( @PathVariable @NotNull List<Long> numberIds) {
        log.info("GET /api/v1/numbers", numberIds);
        return ResponseEntity.ok(fetchNumbersService.getSortedNumbersById(numberIds));
    }
}
