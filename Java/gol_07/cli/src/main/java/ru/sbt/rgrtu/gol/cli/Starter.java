package ru.sbt.rgrtu.gol.cli;

import ru.sbt.rgrtu.gol.boardfilling.BitmapFilling;
import ru.sbt.rgrtu.gol.boardfilling.Filling;
import ru.sbt.rgrtu.gol.boardfilling.RandomFilling;
import ru.sbt.rgrtu.gol.boardfilling.TxtFilling;
import ru.sbt.rgrtu.gol.config.Configuration;
import ru.sbt.rgrtu.gol.config.ConfigurationPropertiesLoader;
import ru.sbt.rgrtu.gol.config.ConfigurationProvider;
import ru.sbt.rgrtu.gol.controller.Controller;
import ru.sbt.rgrtu.gol.controller.FrameByFrameController;
import ru.sbt.rgrtu.gol.game.Gol;
import ru.sbt.rgrtu.gol.controller.TimedController;
import ru.sbt.rgrtu.gol.presentation.AtAndSpacePresentation;
import ru.sbt.rgrtu.gol.presentation.ColoredPresentation;
import ru.sbt.rgrtu.gol.presentation.Presentation;
import ru.sbt.rgrtu.gol.presentation.SmilePresentation;

import java.io.IOException;

public class Starter {

    public static void main(String[] args) throws IOException {
        //ConfigurationProvider cpl = createHardCodedConfigurationProvider();
        //ConfigurationProvider cpl = createInlineConfigurationProvider();
        ConfigurationProvider cpl = createConfigurationPropertiesLoader();

        //Filling fill = new TxtFilling();
        //Filling fill = new RandomFilling(20180921);
        Filling fill = new BitmapFilling("bitmap.bmp");
        Gol gol = new Gol(cpl, fill);
        //Presentation presentation = new AtAndSpacePresentation(gol);
        Presentation presentation = new SmilePresentation(gol);
        //Presentation presentation = new ColoredPresentation(gol);

        //Controller controller = new FrameByFrameController(gol, presentation);
        Controller controller = new TimedController(gol, presentation, 100);
        controller.run();
    }

    private static ConfigurationProvider createConfigurationPropertiesLoader() {
        return new ConfigurationPropertiesLoader("config.properties");
    }

    private static ConfigurationProvider createHardCodedConfigurationProvider() {
        return new HardCodedConfigurationProvider();
    }

    private static ConfigurationProvider createInlineConfigurationProvider() {
        return () -> {
            Configuration configuration = new Configuration();
            configuration.setSizeX(150);
            configuration.setSizeY(100);
            configuration.setSpeed(1000);
            return configuration;
        };
    }
}
