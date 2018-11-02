package com.frazer.game.states;

import com.frazer.game.GamePanel;
import com.frazer.game.utils.KeyHandler;
import com.frazer.game.utils.MouseHandler;
import com.frazer.game.utils.Vector2f;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager
{
    private ArrayList<GameState> states;

    private static Vector2f map;

    private static final int PLAY = 0;
    private static final int MENU = 1;
    private static final int PAUSE = 2;
    private static final int GAMEOVER = 3;

    public GameStateManager()
    {
        map = new Vector2f(GamePanel.width, GamePanel.height);
        Vector2f.setWorldVar(map.x, map.y);

        states = new ArrayList<>();

        states.add(new PlayState(this));
    }

    public void pop(int state)
    {
        states.remove(state);
    }

    private void add(int state)
    {
        if (state == PLAY)
            states.add(new PlayState(this));

        if (state == MENU)
            states.add(new MenuState(this));

        if (state == PAUSE)
            states.add(new PauseState(this));

        if (state == GAMEOVER)
            states.add(new GameOverState(this));
    }

    public void addAndPop(int state)
    {
        states.remove(0);
        add(state);
    }

    public void update()
    {
        Vector2f.setWorldVar(map.x, map.y);

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
