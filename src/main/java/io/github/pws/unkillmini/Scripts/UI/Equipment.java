/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.unkillmini.Scripts.UI;

import io.github.pws.unkillmini.Assets.Sprites.spr_equipment;
import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.backbone.Item;
import io.github.pws.unkillmini.Program.backbone.MiniUtils;
import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.UI;
import io.github.pws.unkillmini.Program.rendering.Window;

public class Equipment extends UI
{
    public static boolean open = false;
    public static boolean charms = false;
    
    public static Item[] equippedItems = new Item[7];
    private static int slotIndex = 0;
    private static spr_equipment spr = new spr_equipment();

    @Override
    public void start() 
    {
    }

    @Override
    public void update() 
    {
        //boolean larm = false, rarm = false, legs = false, chest = false, head = false, weapon = false;
        
        if(Input.getPressedKey("r"))
        {
            open = !open;
            if(open) addNewFocus("equ");
            
            /*
            if(open && Input.check(Commands.check + " left arm"))
                larm = true;
            else if(open && Input.check(Commands.check + " right arm"))
                rarm = true;
            else if(open && Input.check(Commands.check + " legs"))
                legs = true;    
            else if(open && Input.check(Commands.check + " chest"))
                chest = true;
            else if(open && Input.check(Commands.check + " head"))
                head = true;
            else if(open && Input.check(Commands.check + " weapon"))
                weapon = true;
            else if(open && Input.check(Commands.check + " charms"))
                charms = true;
            else if(open && Input.check(Commands.check))
            {
                Window.print("-Checks------------");
                Window.print("left arm, right arm, chest, legs, head, weapon and charms");
            */
        }
        
        if(open && prevFocused[0] == "equ")
        {
            if(Input.getPressedKey() == Input.LEFT || Input.getPressedKey() == Input.DOWN)
                slotIndex++;
            else if (Input.getPressedKey() == Input.RIGHT || Input.getPressedKey() == Input.UP)
                slotIndex--;
        }


        slotIndex = MiniUtils.ClampInt(slotIndex, 0, 7);

        spr.x = 23;
        spr.y = 28;
        spr.background = Color.rgbBG(126, 167, 168);

        if(open)
        {
            spr.pixels = spr_equipment.buttonPressed;
            spr.foregorund = Color.rgbFG(255, 255, 255);
            spr.populate();
            
            spr.y = 5;
            spr.pixels = spr_equipment.eqBorder;
            spr.populate();
            
            spr.x = 25;
            spr.y = 7;
            spr.pixels = spr_equipment.eqSlots;
            spr.foregorund = Color.rgbFG(201, 212, 212);
            spr.populate();
            
            char cBor = ' ';
            String borderBG = Color.rgbBG(133, 185, 186);
            String borderFG = Color.rgbFG(255, 255, 255);
            
            String selectBG = Color.rgbBG(133, 185, 186);
            String selectFG = Color.rgbFG(255, 255, 255);

            if(slotIndex == 1)
            {
                String area =     
                """
                *%@@@@@@@@@@&/
                *%@@@@@@@@@@&/
                *%@@@@@@@@@@&/
                """;

                selectArea(area, 65, 12, cBor, borderBG, borderFG, selectBG, selectFG);
                appendCheck(equippedItems[0], "left arm");
            }
            else if(slotIndex == 2)
            {
                String area =
                """
                .(@@@@@@@@@@@#,
                .(@@@@@@@@@@@#,
                .(@@@@@@@@@@@#,
                """;

                selectArea(area, 27, 12, cBor, borderBG, borderFG, selectBG, selectFG);
                appendCheck(equippedItems[1], "right arm");
            }
            else if(slotIndex == 3)
            {
                String area =
                """
                *%@@@#,   *%@@@#,
                *%@@@#,   *%@@@#,
                *%@@@#,   *%@@@#,
                *%@@@#,   *%@@@#,
                *%@@@#,   *%@@@#,
                *%@@@#,   *%@@@#,
                """;

                selectArea(area, 45, 21, cBor, borderBG, borderFG, selectBG, selectFG);
                appendCheck(equippedItems[2], "legs");
            }
            else if(slotIndex == 0)
            {
                String area =
                """
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                """;

                selectArea(area, 45, 12, cBor, borderBG, borderFG, selectBG, selectFG);
                appendCheck(equippedItems[3], "chest");
            }
            else if(slotIndex == 4)
            {
                String area =
                """
                .(@@@@@@@@&/
                .(@@@@@@@@&/
                .(@@@@@@@@&/
                .(@@@@@@@@&/
                """;

                selectArea(area, 47, 7, cBor, borderBG, borderFG, selectBG, selectFG);
                appendCheck(equippedItems[4], "head");
            }
            else if(slotIndex == 5)
            {
                String area =
                "           /&%*\n"+
                "           /&%*\n"+
                "        *%@@@%*\n"+
                ".(@#,.(@@@@@@%*\n"+
                ".(@@@@@@@@&/   \n"+
                "   *%@@@#,     \n"+
                ".(@#,.(@@@&/   \n";

                selectArea(area, 67, 18, cBor, borderBG, borderFG, selectBG, selectFG);
                appendCheck(equippedItems[5], "weapon");
            }
            else if(slotIndex == 6)
            {
                String area =
                "     *%&/     \n"+
                "  .(@#,.(@#,  \n"+
                "*%@@@#,.(@@@&/\n"+
                "*%&/ *%&/ *%&/\n"+
                "*%&/      *%&/\n"+
                "  .(@#,.(@#,  \n"+
                "     *%&/     \n";

                selectArea(area, 25, 18, cBor, borderBG, borderFG, selectBG, selectFG);
                appendTotem();
            }
        }
        else 
        {
            spr.pixels = spr_equipment.button;
            spr.foregorund = Color.rgbFG(0, 0, 0);
            spr.populate();
        }
    }

    @Override
    public void end() 
    {
    }
    
    private static void appendTotem()
    {
        if(equippedItems[6] == null)
        {
            Window.print("There are no currently equiped totems.");
        }
        else
        {
            String area = 
            """
            ######################
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            ######################
            """;
            
            selectArea(area, 51, 8, ' ', 
            Color.rgbBG(133, 185, 186), Color.rgbFG(0, 0, 0), 
            Color.rgbBG(133, 185, 186), Color.rgbFG(255, 255, 255));
            /*
            it will add the item into an list of totems that works like the inventory items when the command is done.
            it will print an inventory right in the middle of the exquipment tab and will work just like the inventory,
            except with other commands and wi stay on as long as that command is not "eq. ch. totems" or another ch command
            */
            if(slotIndex == 6)
            {
                
            }
        }
    }
    
    private static void appendCheck(Item it, String slot)
    {
        if(it == null)
        {
            //Window.print("There is no currently equiped item on the " + slot);
        }
        else
        {
            //Window.print(it.name + " | " + it.description);
        }
    }
    
    private static void selectArea(String area, int poX, int poY, char cBor, String borderBG, String borderFG, String selectBG, String selectFG)
    {
        String[] lamda = new String[area.split("\n").length + 2];
        String[] temp = area.split("\n");
        
        for(int s = 0; s < lamda.length; s++) 
        {
            if(s == 0 || s == lamda.length-1)
            {
                lamda[s] = String.valueOf(cBor);
                for(@SuppressWarnings("unused") char c : temp[0].toCharArray())
                {
                    lamda[s] += String.valueOf(cBor);
                }
                lamda[s] += String.valueOf(cBor)+"\n";
            }
            else
            {
                lamda[s] = String.valueOf(cBor) + temp[s-1] + String.valueOf(cBor) + "\n";
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : lamda) sb.append(s);
        
        spr.background = borderBG;
        spr.foregorund = borderFG;
        spr.x = poX-1;
        spr.y = poY-1;
        spr.pixels = sb.toString();
        spr.populate();
        
        spr.background = selectBG;
        spr.foregorund = selectFG;
        spr.x = poX;
        spr.y = poY;
        spr.pixels = area;
        spr.populate();
    }
}
