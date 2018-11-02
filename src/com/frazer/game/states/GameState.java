package com.frazer.game.states;

import com.frazer.game.utils.KeyHandler;
import com.frazer.game.utils.MouseHandler;

import java.awt.Graphics2D;

public abstract class GameState
{
    private GameStateManager gsm;

    GameState(GameStateManager gsm)
    {
        this.gsm = gsm;
    }

    public abstract void update();
    public abstract void input(MouseHandler mouse, KeyHandler key);
    public abstract void render(Graphics2D g);
}
