package controller.generationReport;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.DatabaseConnection;
import view.generationReport.GenerationReportDialog;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.JasperReportService;
import model.ReportFormat;
import net.sf.jasperreports.engine.JRException;

public class GenerationReportController {

    private final GenerationReportDialog view;
    private DatabaseConnection database;

    public GenerationReportController(GenerationReportDialog view, DatabaseConnection database) {
        this.view = view;
        this.database = database;
        this.view.addTestButtonActionListener(this.getTestButtonActionListener());
        this.view.addGenerateButtonActionListener(this.getGenerateButtonActionListener());
        initComponents();
    }

    private void initComponents() {
        view.setHostTextField("192.168.250.5");
        view.setDatabaseTextField("aldComputerService");
        view.setUsernameTextField("admin");
        view.setPasswordTextField("abc123.");
    }

    public ActionListener getTestButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    database.setHost(view.getHostTextField());
                    database.setDbname(view.getDatabaseTextField());
                    database.setUser(view.getUsernameTextField());
                    database.setPass(view.getPasswordTextField());

                    database.connect();
                    view.setStatusLabel("Base de datos encontrada");
                    view.setStatusLabelColor(new Color(73, 133, 77));

                } catch (SQLException ex) {
                    view.setStatusLabel("Error al conectar a la base de datos.");
                    view.setStatusLabelColor(new Color(161, 44, 40));
                    ex.printStackTrace();
                } catch (NullPointerException nullex) {
                    view.setStatusLabel("You must complete all the fields");
                    view.setStatusLabelColor(new Color(161, 44, 40));
                    nullex.printStackTrace();
                }

            }
        };

        return al;
    }

    public ActionListener getGenerateButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    database.setHost(view.getHostTextField());
                    database.setDbname(view.getDatabaseTextField());
                    database.setUser(view.getUsernameTextField());
                    database.setPass(view.getPasswordTextField());

                    database.connect();
                    JasperReportService.setConnection(database);

                    String currentDirectory = System.getProperty("user.dir");
                    String sourceFile = currentDirectory + "/resources/" + view.getResourceNameTextField();
                    String destFile = currentDirectory + "/reports/" + view.getResourceNameTextField() + ".pdf";
                    
                    Map<String, Object> parameters = null;

                    JasperReportService.exportReport(sourceFile, destFile, parameters, ReportFormat.PDF);
                    JasperReportService.viewReport(sourceFile, parameters);
                    view.dispose();

                } catch (JRException ex) {
                    Logger.getLogger(GenerationReportController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(GenerationReportController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        };

        return al;
    }

}
