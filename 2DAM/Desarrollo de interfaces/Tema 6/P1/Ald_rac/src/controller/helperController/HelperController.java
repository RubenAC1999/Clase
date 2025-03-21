package controller.helperController;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JFrame;

public class HelperController {

    private JFrame view;
    private HelpBroker hb;

    public HelperController(JFrame view) throws MalformedURLException, HelpSetException {
        this.view = view;
        initHelp();
    }

    private void initHelp() throws MalformedURLException, HelpSetException {
        try {
            File helpFile = new File("help/help_set.hs");
            URL hsURL = helpFile.toURI().toURL();
            HelpSet helpSet = new HelpSet(getClass().getClassLoader(), hsURL);
            this.hb = helpSet.createHelpBroker();
            hb.enableHelpKey(view.getContentPane(), "app", helpSet);
            
        } catch (MalformedURLException | HelpSetException e) {
            e.printStackTrace();
        }

    }

}
