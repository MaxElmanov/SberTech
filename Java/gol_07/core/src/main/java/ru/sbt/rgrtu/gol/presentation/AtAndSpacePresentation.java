package ru.sbt.rgrtu.gol.presentation;

import ru.sbt.rgrtu.gol.game.Gol;

public class AtAndSpacePresentation extends AbstractPresentation implements Presentation {

    //private final Gol gol;

    public AtAndSpacePresentation(Gol gol) {
        super(gol);
        //this.gol = gol;
    }

    @Override
    public void show() {
        super.show("@");
    }
}
