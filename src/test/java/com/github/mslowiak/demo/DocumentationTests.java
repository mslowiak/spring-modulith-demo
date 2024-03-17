package com.github.mslowiak.demo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.docs.Groupings;

class DocumentationTests {

    ApplicationModules applicationModules = ApplicationModules.of(Application.class);

    @Test
    void renderDocumentation() {
        var canvasOptions = Documenter.CanvasOptions
                .withoutDefaultGroupings()
                .groupingBy(Groupings.SpringGroupings.getGroupings())
                .revealInternals();

        var docOptions = Documenter.DiagramOptions.defaults()
                .withStyle(Documenter.DiagramOptions.DiagramStyle.C4); // can be also C4

        new Documenter(applicationModules)
                .writeDocumentation(docOptions, canvasOptions)
                .writeIndividualModulesAsPlantUml();
    }

}


