package com.game.repository;

import com.game.entity.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    Optional<Player> findByName(String name);

    @Query(value = "select * from player", nativeQuery = true)
    List<Player> findAll();

    @Query(value = "select * from player where name = :name and id = :id", nativeQuery = true)
    Optional<Player> findByNameAndId(@Param("name") String name,
                                     @Param("id") Long id);
}
