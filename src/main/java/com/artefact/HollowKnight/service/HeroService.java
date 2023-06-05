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

    public Optional<Hero> singleHero(String heroId){
        return repository.findHeroByHeroId(heroId);
    }

    public Hero saveHero(Hero hero) {
        if(repository.findHeroByHeroId(hero.getHeroId()).isPresent()){
            throw new RuntimeException("Data already exists");
        };
        return repository.save(hero);
    }
}
