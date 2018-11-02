package com.frazer.game.states;

import com.frazer.game.utils.KeyHandler;
import com.frazer.game.utils.MouseHandler;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager
{
    private ArrayList<GameState> states;

    public GameStateManager()
    {
        states = new ArrayList<>();

        states.add(new PlayState(this));
    }

    public void update()
    {
        for (GameState state : states)
        {
            state.update();
        }
    }

    public void input(MouseHandler mouse, KeyHandler key)
    {
        for (GameState state : states)
        {
            state.input(mouse, key);
        }
    }

    public void render(Graphics2D g)
    {
        for (GameState state : states)
        {
            state.render(g);
        }
    }
}
