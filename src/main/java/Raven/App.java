package Raven;

/**
 * Hello world!
 *
 */

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Scanner;

public class App {
    final static int WORLD_WITDH = 20;
    final static int WORLD_HEIGHT = 10;
    static int x = 10;
    static int y = 0;


    static char[][] screen = new char[WORLD_WITDH][WORLD_HEIGHT];
    static char[][] map = new char[WORLD_WITDH][WORLD_HEIGHT];

    public static void main(String[] args) {
        createMap();
        Renderer renderer = new LanternaRenderer();
        // Renderer renderer = new ConsoleRenderer();

        while(true) {
            System.out.println("Hello World");
            //clearMap();
            drawScreen();
            renderer.printScreen();
            // char move = read();
            char move = renderer.waitKey();
            if(move == 'w')
            {
                tryMoveTo(x,y-1);
            }
            else if(move == 's') {
                tryMoveTo(x,y+1);
            }
            else if(move == 'a') {
                tryMoveTo(x-1,y);
            }
            else if(move == 'd') {
                tryMoveTo(x+1,y);
            }
        }
    }




    public static void drawPlayer()
    {
        screen[x][y] = '@';
    }





    public static void clearMap() {
        for (int ly = 0; ly < WORLD_HEIGHT; ly++)
        {
            for (int lx = 0; lx < WORLD_WITDH; lx++)
            {
                map[lx][ly] = ' ';
            }
        }
    }

    public static void buildHorizontalWall(int y)
    {
        for(int lx = 0; lx < WORLD_WITDH; lx++)
        {
            map[lx][y] = '#';
        }
    }

    public static void buildVerticalWall(int x)
    {
        for(int ly = 0; ly < WORLD_HEIGHT; ly++)
        {
            map[x][ly] = '#';
        }
    }

    public static void buildWall(int x, int y)
    {
        map[x][y] = '#';
    }

    public static void createMap() {
        clearMap();
        buildHorizontalWall(0);
        buildHorizontalWall(WORLD_HEIGHT-1);
        buildVerticalWall(0);
        buildVerticalWall(WORLD_WITDH-1);
        buildWall(5,5);
    }

    public static void drawScreen() {
        for (int ly = 0; ly < WORLD_HEIGHT; ly++)
        {
            for (int lx = 0; lx < WORLD_WITDH; lx++)
            {
                screen[lx][ly] = map[lx][ly];
            }
        }
        drawPlayer();
    }

    public static void tryMoveTo(int newX,int newY)
    {
        if (canMoveTo(newX,newY))
        {
            x = newX;
            y = newY;
        }
    }
    public static boolean canMoveTo(int targetX,int targetY)
    {
        if (targetX < 0 || targetX > WORLD_WITDH-1)
        {
            return false;
        }
        if (targetY < 0 || targetY > WORLD_HEIGHT-1)
        {
            return false;
        }
        if (map[targetX][targetY] == '#') {
            return false;
        }
        return true;
    }
}
