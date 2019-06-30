package Raven;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

import static Raven.App.WORLD_HEIGHT;

public class LanternaRenderer implements Renderer {
    static Terminal terminal;

    LanternaRenderer() {
        try {
            terminal = new DefaultTerminalFactory().createTerminal();
        } catch (IOException e) {
            System.out.println("Failed init terminal");
        }
    }

    public void printScreen() {
        try {
            for (int ly = 0; ly < App.WORLD_HEIGHT; ly++)
            {
                for (int lx = 0; lx < App.WORLD_WITDH; lx++)
                {
                    terminal.setCursorPosition(lx,ly);
                    terminal.putCharacter(App.screen[lx][ly]);


                    // System.out.print(screen[lx][ly]);
                }

                // System.out.println();
            }
            terminal.flush();
        } catch (IOException e) {

        }
    }

    public char waitKey() {
        try {

            KeyStroke keyStroke;
            while (true) {

                keyStroke = terminal.pollInput();

                if(keyStroke!=null) {
                    if(keyStroke.getCharacter() != null) {
                        System.out.println(keyStroke);
                        return keyStroke.getCharacter();
                    }
                }
            }
        } catch (IOException e) {
            return ' ';
        }
    }

    /*

    public void testWindow() throws IOException, InterruptedException {
        terminal = new DefaultTerminalFactory().createTerminal();




        char lastChar = 'a';
        int c = 1;
        while(true) {
            terminal.clearScreen();

            terminal.putCharacter('a');
            terminal.putCharacter(lastChar);
            terminal.flush();
            c ++ ;
            System.out.println(c);
            lastChar = waitKey();
            System.out.println(" Lastchar "+lastChar);

        }
    }
     */
}
