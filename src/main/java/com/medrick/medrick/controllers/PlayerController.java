package com.medrick.medrick.controllers;

import com.medrick.medrick.dto.PlayerDto;
import com.medrick.medrick.entities.Player;
import com.medrick.medrick.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("game")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

//    @PostMapping(value = "/score")
//    public ResponseEntity<Object> register(@RequestBody @Valid PlayerDto playerDto) {
//        Player savePlayer = playerService.savePlayer(playerDto);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savePlayer.getId()).toUri();
//
//        return ResponseEntity.created(location).build();
////        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
//    }

    @RequestMapping(value = "/score", method = RequestMethod.POST)
    public Player register2(@RequestBody @Valid PlayerDto playerDto) {
        Player savePlayer = playerService.savePlayer(playerDto);
        return savePlayer;
    }

    @GetMapping("/score")
    public List<Player> getPlayersByOrderDesc() {
        return playerService.findTop100ByOrderByIdDesc();
    }
}
