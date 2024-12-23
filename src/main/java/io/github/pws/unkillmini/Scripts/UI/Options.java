package io.github.pws.unkillmini.Scripts.UI;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import io.github.pws.unkillmini.Application;
import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.UI;
import io.github.pws.unkillmini.Assets.Sprites.spr_options;

public class Options extends UI
{
    public static boolean open;
    private static spr_options spr = new spr_options();

    @Override
    public void start()
    {
        Manager.input.addMapping(NativeKeyEvent.VC_ESCAPE, "Options");
    }

    @Override
    public void update()
    {
        if(Manager.input.isPressed("Options"))
        {
            open = !open;
            if(open) addNewFocus("opt");
            else addNewFocus("null");
        }

        spr.position.x = 100;
        spr.position.y = 28;
        spr.background = Color.rgbBG(126, 167, 168);

        if(open)
        {
            spr.pixels = spr_options.border;
            spr.foreground = Color.rgbFG(255, 255, 255);
            spr.populate();
        }
        else 
        {
            spr.pixels = spr_options.border;
            spr.foreground = Color.rgbFG(0, 0, 0);
            spr.populate();
        }
    }

    @Override
    public void end()
    {

    }
}
