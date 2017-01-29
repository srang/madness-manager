package com.github.srang.madness.model.ephemeral;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by srang on 1/8/17.
 */
@Data
@AllArgsConstructor
public class Alert {
    String message;
    String level;
}
