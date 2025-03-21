package controller;

import controller.clockNotifications.ClockNotificationsController;
import controller.computerManagementController.ComputerManagementController;
import controller.establishmentDetailsController.EstablishmentDetailsController;
import controller.generationReport.GenerationReportController;
import controller.helperController.HelperController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpSetException;
import model.Ald;
import model.DatabaseConnection;
import view.MainJFrame;
import view.clockNotifications.ClockNotificationsDialog;
import view.computerManagement.ComputerManagementDialog;
import view.establishmentDetails.EstablishmentDetailsDialog;
import view.generationReport.GenerationReportDialog;

public class FrontController {
    private final MainJFrame view;
    private Ald ald;
    private DatabaseConnection database;
    private HelperController helper;

    public FrontController(MainJFrame view, Ald ald, DatabaseConnection database) throws MalformedURLException, HelpSetException {
        this.view = view;
        this.ald = ald;
        this.database = database;
        this.helper = new HelperController(view);
        this.view.setFocus();
        this.view.addEstablishmentDetailsMenuItemActionListener(this.getEstablishmentDetailsActionListener());
        this.view.addComputerManagementMenuItemActionListener(this.getComputerManagementMenuItemActionListener());
        this.view.addQuitMenuItemActionListener(this.getQuitMenuItemActionListener());
        this.view.addNotificationsMenuItemActionListener(this.getNotificationsMenuItemActionListener());
        this.view.addGenerateReportMenuItemActionListener(this.getGenerateReportMenuItemActionListener());
    }

    private ActionListener getEstablishmentDetailsActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EstablishmentDetailsDialog dialog = new EstablishmentDetailsDialog(view, true);
                EstablishmentDetailsController controller = new EstablishmentDetailsController(dialog, ald);
                dialog.setVisible(true);
            }

        };

        return al;
    }

    private ActionListener getComputerManagementMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComputerManagementDialog dialog = new ComputerManagementDialog(view, true);
                ComputerManagementController controller = new ComputerManagementController(dialog, ald);
                dialog.setVisible(true);
            }

        };

        return al;
    }

    private ActionListener getQuitMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                System.exit(0);
            }
        };

        return al;
    }

    private ActionListener getNotificationsMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClockNotificationsDialog dialog = new ClockNotificationsDialog(view, true);
                ClockNotificationsController controller = new ClockNotificationsController(dialog, view);
                dialog.setVisible(true);
            }
        };

        return al;
    }

    private ActionListener getGenerateReportMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        GenerationReportDialog databaseDialog = new GenerationReportDialog(view, true);
                        GenerationReportController databaseController = new GenerationReportController(databaseDialog, database);
                        databaseDialog.setVisible(true);
        };
    };
        
        return al;
    }
}
