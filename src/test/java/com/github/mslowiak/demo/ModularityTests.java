package com.github.mslowiak.demo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModularityTests {

    ApplicationModules applicationModules = ApplicationModules.of(Application.class);

    @Test
    void verifyModularity() {
        System.out.println(applicationModules.toString());

        applicationModules.verify();
    }

}

