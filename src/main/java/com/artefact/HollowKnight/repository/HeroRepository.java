package com.artefact.HollowKnight.repository;

import com.artefact.HollowKnight.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero,Integer> {
    Optional<Hero> findHeroById(String heroId);
}
