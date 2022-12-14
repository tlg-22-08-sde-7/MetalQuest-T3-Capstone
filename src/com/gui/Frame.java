package com.gui;

import com.metalquest.controller.GUIControllerPane;
import com.metalquest.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame{
    /*
     * This frame, Frame holds all JPanels that are used within the game.
     * Currently, child, or subsequent, panels are called in a cascading fashion starting with SplashPane.
     * Each panel has a RemovePanelAction class that removes the panel from the container (if needed) and calls
     * its child panel.
     *  EG:
     *   AddSplashPanel -> RemoveSplashPanel -> AddGameplayPanel, AddDescriptionPanel, AddInventoryPanel, AddDirectionsPanel
     * Each panel serves as its own container, controlling the flow of layered panels within it.
     */
    //private final String gameTitle = "Metal Quest";
    private static Frame frame;
    private final int frameWidth = 800;
    private final int frameHeight = 500;
    private final SplashPane splashPane = new SplashPane("", 0, 0, frameWidth, frameHeight);
    private final GameplayPane gameplayPane = new GameplayPane();
    private final InventoryPane inventoryPane = InventoryPane.getInstance();
    private final DescriptionPane descriptionPane = DescriptionPane.getInstance();
    private final DirectionsPane directionsPane = new DirectionsPane();
    private final com.metalquest.controller.GUIControllerPane GUIControllerPane = new GUIControllerPane();
    private Action removeSplashPanelAction;
    private Action upAction, downAction, rightAction, leftAction;
    private KeyStroke escapeKey, upKey, downKey, leftKey, rightKey;
    private final GridBagConstraints gbc = new GridBagConstraints();
    private final Player player = Player.getPlayer();
    private int rounds = 0;

    // C-Tor
    private Frame() {
        init();

        addSplashPanel();

        setLabelText();
    }

    // Get singleton Instance
    public static Frame getInstance() {
        if (frame == null) {
            frame = new Frame();
        }

        return frame;
    }

    // Business Methods
    public void switchToFinalGame() {
        // Remove panes
        this.remove(GUIControllerPane);
        this.revalidate();
        this.repaint();

        JTextField textField = new JTextField();
        textField.addKeyListener(new Keychecker());

        this.setSize(500, 500);

        this.add(textField);
        this.add(new FallingLettersPane());

        textField.requestFocus();
        this.revalidate();
        this.repaint();
    }

    public void endGame() {
        if (++rounds >= 5) {
            this.getContentPane().removeAll();
            player.setLocation("Concert");
            descriptionPane.setLabelText("Your fame is: " + Player.getPlayer().getFame() + "! " +
                    "Thanks for playing!");
            this.add(GUIControllerPane);
            this.revalidate();
            this.repaint();
        }
    }

    static class Keychecker extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {

            String ch = "" + event.getKeyChar();

            FallingLettersPane.checkKey(ch);
        }
    }

    private void setLabelText() {
        descriptionPane.setLabelText("Room: " + player.getLocation().getRoom() + " " + player.getLocation().getDescription());
    }

    // Splash panel
    private void addSplashPanel() {
        // Add welcomePanel to GUIControllerPane
        GUIControllerPane.setLayout(new GridLayout(1, 1));

        GUIControllerPane.add(splashPane);

        // Add escape key binding to GUIControllerPane
        GUIControllerPane.getInputMap().put(escapeKey, "removeAction");
        GUIControllerPane.getActionMap().put("removeAction", removeSplashPanelAction);

        // Revalidate and repaint
        revalidate();
        repaint();
    }

    // Action classes
    private class RemoveSplashPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Remove welcome panel from GUIControllerPane
            GUIControllerPane.remove(splashPane);

            // Remove keybindings
            GUIControllerPane.getInputMap().remove(escapeKey);
            GUIControllerPane.getActionMap().remove("removeAction");

            GUIControllerPane.setLayout(new GridBagLayout());

            // Add game frames
            addInventoryPanel();
            addGameplayPanel();
            addDescriptionPanel();
            addDirectionsPanel();

            descriptionPane.setLabelText(player.toString());

            // Add direction bindings to GUIControllerPane
            // up
            GUIControllerPane.getInputMap().put(upKey, "upAction");
            GUIControllerPane.getActionMap().put("upAction", upAction);

            // down
            GUIControllerPane.getInputMap().put(downKey, "downAction");
            GUIControllerPane.getActionMap().put("downAction", downAction);

            // left
            GUIControllerPane.getInputMap().put(leftKey, "leftAction");
            GUIControllerPane.getActionMap().put("leftAction", leftAction);

            // right
            GUIControllerPane.getInputMap().put(rightKey, "rightAction");
            GUIControllerPane.getActionMap().put("rightAction", rightAction);

            revalidate();
            repaint();
        }
    }

    private class UpAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.moveLocation("north", player);
            gameplayPane.enterRoom();
            descriptionPane.setLabelText(player.toString());

            // TODO: Remove this and add it in the method where the user successfully picks up an item
            //.addItemToInventoryList("Example item from up key");
        }
    }

    private class DownAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.moveLocation("south", player);
            gameplayPane.enterRoom();
            descriptionPane.setLabelText(player.toString());

            // TODO: Remove this and add it in the method where the user successfully picks up an item
            //inventoryPane.addItemToInventoryList("Example item from down key");
        }
    }

    private class LeftAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.moveLocation("west", player);
            gameplayPane.enterRoom();
            descriptionPane.setLabelText(player.toString());

            // TODO: Remove this and add it in the method where the user successfully picks up an item
            //inventoryPane.addItemToInventoryList("Example item from left key");
        }
    }

    private class RightAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.moveLocation("east", player);
            gameplayPane.enterRoom();
            descriptionPane.setLabelText(player.toString());

            // TODO: Remove this and add it in the method where the user successfully picks up an item
            //inventoryPane.addItemToInventoryList("Example item from right key");
        }
    }

    // Gameplay panel
    private void addGameplayPanel() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = .10;
        gbc.weighty = .25;
        GUIControllerPane.add(gameplayPane, gbc);
        gbc.weightx = .1;
        gbc.weighty = .1;

    }

    // Inventory panel
    private void addInventoryPanel() {
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        GUIControllerPane.add(inventoryPane, gbc);
    }

    // Description panel
    private void addDescriptionPanel() {
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        GUIControllerPane.add(descriptionPane, gbc);
    }


    // Directions panel
    private void addDirectionsPanel() {
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        GUIControllerPane.add(directionsPane, gbc);
    }


    // Helper Methods
    private void init() {
        // Assignments
        escapeKey = KeyStroke.getKeyStroke("ESCAPE");
        upKey = KeyStroke.getKeyStroke("UP");
        downKey = KeyStroke.getKeyStroke("DOWN");
        leftKey = KeyStroke.getKeyStroke("LEFT");
        rightKey = KeyStroke.getKeyStroke("RIGHT");

        removeSplashPanelAction = new RemoveSplashPanelAction();
        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();

        ImageIcon imageIcon = new ImageIcon(
                "C:\\StudentWork\\MetalQuest\\MetalQuest-T3-Capstone\\resources\\images\\rockstar.png"); // creates Image Icon

        // Set configurations
        this.setSize(frameWidth, frameHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits app
        this.setVisible(true); //make frame visible
        this.setIconImage(imageIcon.getImage()); // change icon of frame
        this.getContentPane().setBackground(Color.black); // change color of background

        // Add masterPanel to Frame
        this.add(GUIControllerPane);
    }
}
