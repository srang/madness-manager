package org.srang.madness.manager.model.forms;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by srang on 1/28/17.
 */
@Getter
@Setter
public class TestForm {
    public TestForm() {
        games = new FormMap<>(new Supplier<Map<Integer, GameTouple>>() {
            @Override
            public Map<Integer, GameTouple> get() {
                return new FormMap<Integer, GameTouple>(GameTouple.class);
            }
        });
    }
    Map<Integer, Map<Integer, GameTouple>> games;
}
