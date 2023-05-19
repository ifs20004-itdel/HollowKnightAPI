package com.artefact.HollowKnight.controller;

import com.artefact.HollowKnight.model.Hero;
import com.artefact.HollowKnight.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/heroes")
@CrossOrigin(origins = "*")
public class HeroController {
    @Autowired
    private HeroService service;
    @GetMapping
    public ResponseEntity<List<Hero>> getAllHeroes(){
        return new ResponseEntity<>(service.allHero(), HttpStatus.OK);
    }
}
