package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Frame extends JFrame{
    /*
     * This frame, Frame holds all JPanels that are used within the game.
     * Currently, child, or subsequent, panels are called in a cascading fashion starting with SplashPanel.
     * Each panel has a RemovePanelAction class that removes the panel from the container (if needed) and calls
     * its child panel.
     *  EG:
     *   AddSplashPanel -> RemoveSplashPanel -> AddGameplayPanel, AddDescriptionPanel, AddInventoryPanel, AddDirectionsPanel
     * Each panel serves as its own container, controlling the flow of layered panels within it.
     */
    private final String gameTitle = "Metal Quest";
    private final int frameWidth = 1500;
    private final int frameHeight = 1000;
    private final SplashPanel splashPanel = new SplashPanel(gameTitle, 0, 0, frameWidth, frameHeight);
    private final GameplayPanel gameplayPanel =
            new GameplayPanel(gameTitle, 20, 20, (int) (frameWidth * .65), (int) (frameHeight * .63));
    private final InventoryPanel inventoryPanel =
            new InventoryPanel(gameTitle, 1030, 20, (int) (frameWidth * .30), (int) (frameHeight * .63));
    private final DescriptionPanel descriptionPanel =
            new DescriptionPanel(gameTitle, 20, 675, (int) (frameWidth * .65), (int) (frameHeight * .25));
    private final DirectionsPanel directionsPanel =
            new DirectionsPanel(gameTitle, 1030, 675, (int) (frameWidth * .30), (int) (frameHeight * .25));
    private final MasterPanel masterPanel = new MasterPanel(gameTitle, 0, 0, frameWidth, (int) (frameHeight * .95));
    private Action removeSplashPanelAction;
    private KeyStroke escapeKey;

    // C-Tor
    Frame() {
        init();

        addSplashPanel();
    }

    // Business Methods
    // Splash panel
    private void addSplashPanel() {
        // Add welcomePanel to masterPanel
        masterPanel.add(splashPanel);

        // Add escape key binding to master panel
        masterPanel.getInputMap().put(escapeKey, "removeAction");
        masterPanel.getActionMap().put("removeAction", removeSplashPanelAction);
    }

    private class RemoveSplashPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Remove welcome panel from masterPanel
            masterPanel.remove(splashPanel);

            // Remove keybindings
            masterPanel.getInputMap().remove(escapeKey);
            masterPanel.getActionMap().remove("removeAction");

            repaint();

            // Add game frames
            addSettingsPanel();
            addGameplayPanel();
            addDescriptionPanel();
            addDirectionsPanel();
        }
    }

    // Settings panel
    private void addSettingsPanel() {
        // TODO: fill this method
        masterPanel.add(inventoryPanel);
    }

    private class RemoveSettingsPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: fill this method
            /*
                // Remove welcome panel from masterPanel
                masterPanel.remove(splashPanel);

                // Remove keybindings
                masterPanel.getInputMap().remove(escapeKey);
                masterPanel.getActionMap().remove("removeAction");

                repaint();

             */
                // Call next frame
                addGameplayPanel();
        }
    }

    // Gameplay panel
    private void addGameplayPanel() {
        masterPanel.add(gameplayPanel);
    }

    private class RemoveGameplayPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: fill this method
            /*
                // Remove welcome panel from masterPanel
                masterPanel.remove(splashPanel);

                // Remove keybindings
                masterPanel.getInputMap().remove(escapeKey);
                masterPanel.getActionMap().remove("removeAction");

                repaint();

                // Call next frame
                addSettingsPanel();
             */
        }
    }

    // Description panel
    private void addDescriptionPanel() {
        masterPanel.add(descriptionPanel);
    }

    private class RemoveDescriptionPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: fill this method
            /*
                // Remove welcome panel from masterPanel
                masterPanel.remove(splashPanel);

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
        masterPanel.add(directionsPanel);
    }

    private class RemoveDirectionsPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: fill this method
            /*
                // Remove welcome panel from masterPanel
                masterPanel.remove(splashPanel);

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
        removeSplashPanelAction = new RemoveSplashPanelAction();
        ImageIcon imageIcon = new ImageIcon(
                "C:\\StudentWork\\MetalQuest\\MetalQuest-T3-Capstone\\resources\\images\\rockstar.png"); // creates Image Icon

        // Set configurations
        this.setTitle(gameTitle);
        this.setSize(frameWidth, frameHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits app
        this.setResizable(false); // prevents frame from
        this.setVisible(true); //make frame visible
        this.setLayout(null);
        this.setIconImage(imageIcon.getImage()); // change icon of frame
        this.getContentPane().setBackground(Color.black); // change color of background

        // Add masterPanel to Frame
        this.add(masterPanel);
    }
}
