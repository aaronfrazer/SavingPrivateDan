package com.frazer.game.utils;

import com.frazer.game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyHandler implements KeyListener
{
    private static List<Key> keys = new ArrayList<>();

    public class Key
    {
        int presses, absorbs;
        public boolean down;
        boolean clicked;

        Key()
        {
            keys.add(this);
        }

        void toggle(boolean pressed)
        {
            if (pressed != down)
            {
                down = pressed;
            }
            if (pressed)
            {
                presses++;
            }
        }

        void tick()
        {
            if (absorbs < presses)
            {
                absorbs++;
                clicked = true;
            } else
            {
                clicked = false;
            }
        }
    }

    public Key up = new Key();
    private Key down = new Key();
    private Key left = new Key();
    private Key right = new Key();
    private Key attack = new Key();
    private Key menu = new Key();
    private Key enter = new Key();
    private Key escape = new Key();

    public KeyHandler(GamePanel game)
    {
        game.addKeyListener(this);
    }

    public void releaseAll()
    {
        for (Key key : keys)
        {
            key.down = false;
        }
    }

    public void tick()
    {
        for (Key key : keys)
        {
            key.tick();
        }
    }

    private void toggle(KeyEvent e, boolean pressed)
    {
        if (e.getKeyCode() == KeyEvent.VK_W)
            up.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_S)
            down.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_A)
            left.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_D)
            right.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            attack.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_E)
            menu.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            enter.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            escape.toggle(pressed);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        // Do nothing
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        toggle(e, true);
    }
}
