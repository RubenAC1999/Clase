package main;

import controller.FrontController;
import java.net.MalformedURLException;
import java.sql.SQLException;
import javax.help.HelpSetException;
import model.Ald;
import model.DatabaseConnection;
import view.MainJFrame;


public class Main {
    public static void main(String[] args) throws SQLException, MalformedURLException, HelpSetException {
        MainJFrame mainView = new MainJFrame();
        Ald ald = Ald.getModel();
        DatabaseConnection database = DatabaseConnection.getModel();
        FrontController controller = new FrontController(mainView, ald, database);
        mainView.setVisible(true);
    }
    
}
