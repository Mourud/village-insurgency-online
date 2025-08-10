package com.villageinsurgency.game.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    @GetMapping("/public/ping") public String pub() { return "public-ok"; }
    @GetMapping("/private/ping") public String priv() { return "private-ok"; }

}
