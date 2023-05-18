package com.artefact.HollowKnight.service;

import com.artefact.HollowKnight.model.Hero;
import com.artefact.HollowKnight.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService {
    @Autowired
    private HeroRepository repository;

    public List<Hero> allHero(){ return repository.findAll();}

    public Optional<Hero> singleHero(String heroId){ return repository.findHeroById(heroId);
    }
}
