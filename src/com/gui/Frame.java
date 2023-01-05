package com.gui;

import com.metalquest.controller.GUIControllerPane;
import com.metalquest.model.Player;
import com.metalquest.model.TextParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
    private final int frameWidth = 800;
    private final int frameHeight = 500;
    private final SplashPane splashPane = new SplashPane("", 0, 0, frameWidth, frameHeight);
    private final GameplayPane gameplayPane = new GameplayPane();
    private final InventoryPane inventoryPane = new InventoryPane();
    private final DescriptionPane descriptionPane = DescriptionPane.getInstance();
    private final DirectionsPane directionsPane = new DirectionsPane();
    private final com.metalquest.controller.GUIControllerPane GUIControllerPane = new GUIControllerPane();
    private Action removeSplashPanelAction;
    private Action upAction, downAction, rightAction, leftAction;
    private KeyStroke escapeKey, upKey, downKey, leftKey, rightKey;
    private final GridBagConstraints gbc = new GridBagConstraints();
    private final Player player = Player.getPlayer();

    enum Locations {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    // C-Tor
    Frame() {
        init();

        addSplashPanel();

        enterLivingRoom();
    }

    // Business Methods
    private String captureLocationRequest(Locations location) {
        String direction = null;

        switch (location) {
            case UP:
                break;
            case DOWN:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
            default:
                direction = "ERROR: an invalid location was passed to Frame.changeLocation. This" +
                        " is an application error";
        }

        return direction;
    }


    private void enterLivingRoom() {
        // gameplay panel


        // description panel


        // direction panel

        //this.pack();
    }

    private void enterKitchen() {

    }

    private void enterBackyard() {

    }

    private void enterMasterBedroom() {

    }

    private void enterBathroom() {

    }

    private void enterGarage() {

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
            descriptionPane.setLabelText("Room: " + player.getLocation().getRoom() + " " + player.getLocation().getDescription());
        }
    }

    private class DownAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.moveLocation("south", player);
            gameplayPane.enterRoom();
            descriptionPane.setLabelText("Room: " + player.getLocation().getRoom() + " " + player.getLocation().getDescription());
        }
    }

    private class LeftAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.moveLocation("west", player);
            gameplayPane.enterRoom();
            descriptionPane.setLabelText("Room: " + player.getLocation().getRoom() + " " + player.getLocation().getDescription());
        }
    }

    private class RightAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.moveLocation("east", player);
            gameplayPane.enterRoom();
            descriptionPane.setLabelText("Room: " + player.getLocation().getRoom() + " " + player.getLocation().getDescription());
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

    private class RemoveGameplayPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: fill this method
            /*
                // Remove welcome panel from masterPanel
                masterPanel.remove(splashPane);

                // Remove keybindings
                masterPanel.getInputMap().remove(escapeKey);
                masterPanel.getActionMap().remove("removeAction");

                repaint();

                // Call next frame
                addSettingsPanel();
             */
        }
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

    private class RemoveInventoryPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: fill this method
            /*
                // Remove welcome panel from masterPanel
                masterPanel.remove(splashPane);

                // Remove keybindings
                masterPanel.getInputMap().remove(escapeKey);
                masterPanel.getActionMap().remove("removeAction");

                repaint();

             */
                // Call next frame
                addGameplayPanel();
        }
    }


    // Description panel
    private void addDescriptionPanel() {
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        GUIControllerPane.add(descriptionPane, gbc);

    }

    private class RemoveDescriptionPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: fill this method
            /*
                // Remove welcome panel from masterPanel
                masterPanel.remove(splashPane);

                // Remove keybindings
                masterPanel.getInputMap().remove(escapeKey);
                masterPanel.getActionMap().remove("removeAction");

                repaint();

                // Call next frame
                addSettingsPanel();
             */
        }
    }

    // Directions panel
    private void addDirectionsPanel() {
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        GUIControllerPane.add(directionsPane, gbc);
    }

    private class RemoveDirectionsPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: fill this method
            /*
                // Remove welcome panel from masterPanel
                masterPanel.remove(splashPane);

                // Remove keybindings
                masterPanel.getInputMap().remove(escapeKey);
                masterPanel.getActionMap().remove("removeAction");

                repaint();

                // Call next frame
                addSettingsPanel();
             */
        }
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


        //this.setTitle(gameTitle);
        this.setSize(frameWidth, frameHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits app
        this.setVisible(true); //make frame visible
        this.setIconImage(imageIcon.getImage()); // change icon of frame
        this.getContentPane().setBackground(Color.black); // change color of background


        // Add masterPanel to Frame
        this.add(GUIControllerPane);
    }
}
