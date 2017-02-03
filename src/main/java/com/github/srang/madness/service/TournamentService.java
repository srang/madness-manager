package com.github.srang.madness.service;

import com.github.srang.madness.model.entities.Tournament;
import com.github.srang.madness.model.repositories.TournamentRepository;
import com.github.srang.madness.model.types.State;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean isState(String state) {
        Tournament t = tourneyRepo.getActiveTournament();
        return t.getState().state().equals(State.StateType.valueOf(state));
    }
}
