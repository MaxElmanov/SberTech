package ru.sbt.rgrtu.gol.web;

import ru.sbt.rgrtu.gol.boardfilling.BitmapFilling;
import ru.sbt.rgrtu.gol.boardfilling.Filling;
import ru.sbt.rgrtu.gol.boardfilling.RandomFilling;
import ru.sbt.rgrtu.gol.boardfilling.TxtFilling;
import ru.sbt.rgrtu.gol.config.ConfigurationPropertiesLoader;
import ru.sbt.rgrtu.gol.config.ConfigurationProvider;
import ru.sbt.rgrtu.gol.game.Gol;
import ru.sbt.rgrtu.gol.presentation.Presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GolServlet extends HttpServlet {

    private Gol gol;
    private Filling fill;
    private HtmlPresentation presentation;

    @Override
    public synchronized void init() throws ServletException {
        super.init();
        try { initGol(); }
        catch (IOException e) { e.printStackTrace(); }
    }

    private void initGol() throws IOException {
        ConfigurationProvider cpl = new ConfigurationPropertiesLoader("config.properties");
        fill = new BitmapFilling();
        Gol gol = new Gol(cpl, fill);
        gol.init();
        Presentation presentation = new HtmlPresentation(gol, true);

        this.presentation = (HtmlPresentation)presentation;
        this.gol = gol;
    }

    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        presentation.setResponse(response);
        gol.nextStep();
        presentation.show();
    }

}
