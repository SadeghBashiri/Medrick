package com.medrick.medrick.repositories;

import com.medrick.medrick.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findTop100ByOrderByIdDesc();
}
