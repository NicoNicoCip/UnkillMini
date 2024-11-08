package io.github.pws.unkillmini.Program.rendering;

import java.io.IOException;

import io.github.pws.unkillmini.Program.backbone.MiniUtils;

public class Window
{
    public static final int width = 120;
    public static final int height = 32;
    public static final String apkName = "Unkill Mini";

    public static String[][] pixels;
    public static String[][] pixelsForeground;
    public static String[][] pixelsBackground;
    
    private static String suffix = "";

    public static final void compose()
    {
        setWindowsTitle(apkName);
        pixels = new String[height][width];
        pixelsForeground = new String[height][width];
        pixelsBackground = new String[height][width];

        for (int xx = 0; xx < pixels.length; xx++)
        {
            for (int yy = 0; yy < pixels[xx].length; yy++)
            {
                pixels[xx][yy] = "";
                pixelsForeground[xx][yy] = "";
                pixelsBackground[xx][yy] = "";
            }
        }
    }

    public static final void fillBlanks()
    {
        for (int xx = 0; xx < pixels.length; xx++)
        {
            for (int yy = 0; yy < pixels[xx].length; yy++)
            {
                if(pixels[xx][yy] == "") pixels[xx][yy] = " ";
                if(pixelsForeground[xx][yy] == "") pixelsForeground[xx][yy] = Color.rgbFG(0, 0, 0);
                if(pixelsBackground[xx][yy] == "") pixelsBackground[xx][yy] = Color.rgbBG(0, 0, 0);
            }
        }
    }
    
    public static final void populateWithPixels(String[][] populator, int posX, int posY)
    {
        for (int xx = 0; xx < populator.length; xx++)
        {
            for (int yy = 0; yy < populator[xx].length; yy++)
            {
                if(posX < 0) posX = 0;
                if(posY < 0) posY = 0;
                pixels[posY + xx][posX + yy] = populator[xx][yy];
            }
        }
    }
    
    public static final void setPopulatorForeground(String[][] populator, int posX, int posY, String color)
    {
        for (int xx = 0; xx < populator.length; xx++)
        {
            for (int yy = 0; yy < populator[xx].length; yy++)
            {
                if(posX < 0) posX = 0;
                if(posY < 0) posY = 0;
                pixelsForeground[posY + xx][posX + yy] = color;
            }
        }
    }
    
    public static final void setPopulatorBackground(String[][] populator, int posX, int posY, String color)
    {
        for (int xx = 0; xx < populator.length; xx++)
        {
            for (int yy = 0; yy < populator[xx].length; yy++)
            {
                if(posX < 0) posX = 0;
                if(posY < 0) posY = 0;
                pixelsBackground[posY + xx][posX + yy] = color;
            }
        }
    }

    public static final void draw()
    {
        StringBuilder sb = new StringBuilder();
        System.out.print("\033[0;0H");
        for (int xx = 0; xx < pixels.length; xx++)
        {
            for (int yy = 0; yy < pixels[xx].length; yy++)
            {
                if(pixels[xx][yy] == null) pixels[xx][yy] = "§";
                sb.append(pixelsForeground[xx][yy]).append(pixelsBackground[xx][yy]).append(pixels[xx][yy]);
            }
            sb.append(Color.RESET);
        }

        sb.append(suffix + "\n");
        System.out.print(sb.toString());
        suffix = "";
        System.out.flush();
    }
    
    public static void clear()
    {
        try { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {}
    }
    
    public static void pause()
    {
        try { new ProcessBuilder("cmd", "/c", "PAUSE").inheritIO().start().waitFor();  
        } catch (IOException | InterruptedException e) {}
    }
    
    public static void print(String _suffix)
    {
        suffix += "\n" + _suffix;
    }

    public static void hideCursor() 
    {
        System.out.print("\033[?25l");
    }
    
    public static void showCursor() 
    {
        System.out.print("\033[?25h");
    }

    public static void setWindowsTitle(String title) 
    {
        try { new ProcessBuilder("cmd", "/c", "title " + title).inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {}

    }
}
