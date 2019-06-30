package Raven;

import javax.swing.*;
import java.util.Scanner;

public class ConsoleRenderer implements Renderer {
    public void printScreen() {
        for (int ly = 0; ly < App.WORLD_HEIGHT; ly++)
        {
            for (int lx = 0; lx < App.WORLD_WITDH; lx++)
            {
                System.out.print(App.screen[lx][ly]);
            }
            System.out.println();
        }
    }

    public char waitKey()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Press any key to continue . . . ");
        String input = scan.nextLine();
        if(input.length() != 0) {
            return input.charAt(0);
        }
        return ' ';
    }
}
