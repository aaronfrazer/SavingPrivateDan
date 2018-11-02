package com.frazer.game.states;

import com.frazer.game.utils.KeyHandler;
import com.frazer.game.utils.MouseHandler;

import java.awt.Graphics2D;
import java.awt.Color;

public class PlayState extends GameState
{
    PlayState(GameStateManager gsm)
    {
        super(gsm);
    }

    public void update()
    {

    }

    public void input(MouseHandler mouse, KeyHandler key)
    {
        if (key.up.down)
        {
            System.out.println("W is being pressed");
        }
    }

    public void render(Graphics2D g)
    {
        g.setColor(Color.RED);
        g.fillRect(100, 100, 64, 64);
    }
}
