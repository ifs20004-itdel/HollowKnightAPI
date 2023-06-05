package com.artefact.HollowKnight.controller;

import com.artefact.HollowKnight.filter.JwtAuthFilter;
import com.artefact.HollowKnight.model.Hero;
import com.artefact.HollowKnight.response.ResponseHandler;
import com.artefact.HollowKnight.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/heroes")
@CrossOrigin(origins = "*")
public class HeroController {
    @Autowired
    private HeroService service;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<Hero>> getAllHeroes(){
        return new ResponseEntity<>(service.allHero(), HttpStatus.OK);
    }
    private static final Logger logger = Logger.getLogger(JwtAuthFilter.class.getName());

    @GetMapping("/{heroId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Optional<Hero>> getSingleHero(@PathVariable String heroId){
        return new ResponseEntity<>(service.singleHero(heroId), HttpStatus.OK);
    }

    @PostMapping("/add_hero")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Object> addSingleHero(@RequestBody Hero hero){
        try{
            return ResponseHandler.responseBuilder(
                    "Hero added successfully",
                    HttpStatus.OK,
                    service.saveHero(hero));
        }catch (RuntimeException e){
            return ResponseHandler.responseBuilder(
                    "Hero failed to added",
                    HttpStatus.FORBIDDEN,
                    e.getMessage());
        }
    }
}
