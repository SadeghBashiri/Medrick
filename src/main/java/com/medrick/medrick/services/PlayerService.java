package com.medrick.medrick.services;

import com.medrick.medrick.dto.PlayerDto;
import com.medrick.medrick.entities.Player;
import com.medrick.medrick.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player savePlayer(PlayerDto playerDto) {
        Player player = new Player();
        player.setName(playerDto.getName());
        player.setScore(playerDto.getScore());
        return playerRepository.save(player);
    }
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> findTop100ByOrderByIdDesc() {
        return playerRepository.findTop100ByOrderByIdDesc();
    }
}
