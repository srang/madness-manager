package com.github.srang.madness.service;

import com.github.srang.madness.model.entities.Tournament;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.srang.madness.model.repositories.TournamentRepository;

/**
 * Created by srang on 1/11/17.
 */
@Log
@Service
public class TournamentService {

    @Autowired
    TournamentRepository tourneyRepo;

    public void next() {
        Tournament t = tourneyRepo.getActiveTournament();
        t.setState(t.getState().getNextId());
        tourneyRepo.save(t);
    }
}
