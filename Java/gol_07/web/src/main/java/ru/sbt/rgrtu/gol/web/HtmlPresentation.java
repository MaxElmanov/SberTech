package ru.sbt.rgrtu.gol.web;

import ru.sbt.rgrtu.gol.game.Gol;
import ru.sbt.rgrtu.gol.presentation.Presentation;

import javax.servlet.http.HttpServletResponse;

public class HtmlPresentation implements Presentation {

    private static final String PAGE_TEMPLATE =
    "<html>\n" +
        "<head>\n" +
            "<style>\n" +
                "body {background-color: black; color:gray}\n" +
                "table {border-spacing: 0px;}\n" +
                "td { height:10px; width:10px; border: 1px solid; border-color: 202020; }\n" +
                ".alive {background-color: green;}\n" +
                ".dead {background-color: black;}\n" +
            "</style>\n" +
        "%1$s\n" +
        "</head>\n" +
        "<body>\n" +
            "%2$s%3$s\n" +
        "</body>\n" +
    "</html>"
    ;
    private static final String RELOAD =
    "<script type=\"text/javascript\">\n" +
            "window.onload=function(){setTimeout(function() { location.reload(true); }, 500);};" +
    "</script>\n"
    ;
    private static final String HEADER_TEMPLATE =
    "<h1>Generation: %1$05d</h1>"
    ;
    private static final String BOARD_TEMPLATE =
    "<table>\n" +
        "<tbody>\n" +
            "%1$s\n" +
        "</tbody>\n" +
    "</table>"
    ;
    private static final String ROW_TEMPLATE =
    "<tr>%1$s</tr>\n"
    ;
    private static final String LIVE_CELL =
    "<td class=\"alive\"></td>"
    ;
    private static final String DEAD_CELL =
    "<td class=\"dead\"></td>"
    ;

    private final Gol gol;
    private final boolean reload;

    private HttpServletResponse response;

    /**
     * Create new instance.
     * @param gol provider of game data
     * @param reload insert reloading script
     */
    public HtmlPresentation(Gol gol, boolean reload) {
        this.gol = gol;
        this.reload = reload;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void show() {
        String header = String.format(HEADER_TEMPLATE, gol.getGeneration());
        StringBuilder rows = new StringBuilder();
        for (int y = 0; y < gol.getSizeY(); y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < gol.getSizeX(); x++) {
                row.append(gol.getPoint(x,y) ? LIVE_CELL : DEAD_CELL);
            }
            rows.append(String.format(ROW_TEMPLATE, row)).append("\n");
        }
        String board = String.format(BOARD_TEMPLATE, rows);

        String out = String.format(PAGE_TEMPLATE, (reload ? RELOAD : ""), header, board);
        try {
            response.setContentType("text/html");
            response.getWriter().write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
