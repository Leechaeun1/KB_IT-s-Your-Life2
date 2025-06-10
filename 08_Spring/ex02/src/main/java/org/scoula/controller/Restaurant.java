package org.scoula.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class Restaurant {
//    @Autowired
//    private Chef chef;

    private final Chef chef;
}
