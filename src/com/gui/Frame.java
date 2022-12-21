package com.gui;

import com.metalquest.model.LocationsEnum;

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
    private final int frameWidth = 800;
    private final int frameHeight = 500;
    private final SplashPanel splashPanel = new SplashPanel(gameTitle, 0, 0, frameWidth, frameHeight);
    private final GameplayPanel gameplayPanel =
            new GameplayPanel(gameTitle, 2, 2, (int) (frameWidth * .65), (int) (frameHeight * .63));
    private final InventoryPanel inventoryPanel =
            new InventoryPanel(gameTitle, 546, 2, (int) (frameWidth * .30), (int) (frameHeight * .63));
    private final DescriptionPanel descriptionPanel =
            new DescriptionPanel(gameTitle, 2, 338, (int) (frameWidth * .65), (int) (frameHeight * .25));
    private final DirectionsPanel directionsPanel =
            new DirectionsPanel(gameTitle, 546, 338, (int) (frameWidth * .30), (int) (frameHeight * .25));
    private final MasterPanel masterPanel = new MasterPanel(gameTitle, 0, 0, frameWidth, (int) (frameHeight * .95));
    private Action removeSplashPanelAction;
    private KeyStroke escapeKey;
    private final GridBagConstraints gbc = new GridBagConstraints();


    // C-Tor
    Frame() {
        init();

        addSplashPanel();

        enterLivingRoom();
    }

    // Business Methods
    private void enterLivingRoom() {
        // gameplay panel


        // description panel
        descriptionPanel.describe(LocationsEnum.KITCHEN);

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
        // Add welcomePanel to masterPanel
        masterPanel.setLayout(new GridLayout(1, 1));

        masterPanel.add(splashPanel);

        // Add escape key binding to master panel
        masterPanel.getInputMap().put(escapeKey, "removeAction");
        masterPanel.getActionMap().put("removeAction", removeSplashPanelAction);


        revalidate();
        repaint();
    }

    private class RemoveSplashPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Remove welcome panel from masterPanel
            masterPanel.remove(splashPanel);

            // Remove keybindings
            masterPanel.getInputMap().remove(escapeKey);
            masterPanel.getActionMap().remove("removeAction");

            masterPanel.setLayout(new GridBagLayout());

            // Add game frames
            addInventoryPanel();
            addGameplayPanel();
            addDescriptionPanel();
            addDirectionsPanel();

            revalidate();
            repaint();
        }
    }

    // Gameplay panel
    private void addGameplayPanel() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = .25;
        gbc.weighty = .25;
        masterPanel.add(gameplayPanel, gbc);

        gbc.weightx = .1;
        gbc.weighty = .1;
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


    // Inventory panel
    private void addInventoryPanel() {
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        masterPanel.add(inventoryPanel, gbc);
    }

    private class RemoveInventoryPanelAction extends AbstractAction {

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


    // Description panel
    private void addDescriptionPanel() {
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;

        masterPanel.add(descriptionPanel, gbc);

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
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        masterPanel.add(directionsPanel, gbc);
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
        //this.setResizable(false); // prevents frame from
        this.setVisible(true); //make frame visible
        ///this.setLayout(null);
        this.setIconImage(imageIcon.getImage()); // change icon of frame
        this.getContentPane().setBackground(Color.black); // change color of background

        // Add masterPanel to Frame
        this.add(masterPanel);
    }
}
