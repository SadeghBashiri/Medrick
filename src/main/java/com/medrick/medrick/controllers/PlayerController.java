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

//    @GetMapping
//    public List<Player> getPlayers() {
//        return playerService.getPlayers();
//    }

//    @PostMapping("score")
//    public void register(@RequestBody Player player){
//        playerService.savePlayer(player);
//    }

    @PostMapping(value = "/score1")
    public ResponseEntity<Object> register(@RequestBody @Valid PlayerDto playerDto) {
        Player savePlayer = playerService.savePlayer(playerDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savePlayer.getId()).toUri();

        return ResponseEntity.created(location).build();
//        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/score2", method = RequestMethod.POST)
    public Player register2(@RequestBody @Valid PlayerDto playerDto) {
        Player savePlayer = playerService.savePlayer(playerDto);
        return savePlayer;
    }

    @PostMapping("/score3")
    public String register3(@RequestBody @Valid PlayerDto playerDto, Errors errors) throws Exception{
        if (errors.hasErrors()) {
            // Extract ConstraintViolation list from body errors
            List<ConstraintViolation<?>> violationsList = new ArrayList<>();
            for (ObjectError e : errors.getAllErrors()) {
                violationsList.add(e.unwrap(ConstraintViolation.class));
            }

            String exceptionMessage = "";

            // Construct a helpful message for each input violation
            for (ConstraintViolation<?> violation : violationsList) {
                exceptionMessage += violation.getPropertyPath() + " " + violation.getMessage() + "\n";
            }
            throw new Exception(String.format("Request input is invalid:\n%s", exceptionMessage));
        }

        return ":)";
//        Player savePlayer = playerService.savePlayer(playerDto);
//        return ResponseEntity.ok("User is valid");
    }

    @GetMapping("/score")
    public List<Player> getPlayersByOrderDesc() {
        return playerService.findTop100ByOrderByIdDesc();
    }
}
