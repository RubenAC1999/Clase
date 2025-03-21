package model;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.view.JasperViewer;


public class JasperReportService {
    private static DatabaseConnection connection;
    
    public static JasperReport compileReport(String path) throws JRException {
        return JasperCompileManager.compileReport(path);
    }
    
     private static JasperPrint fillReport(JasperReport report, Map<String, Object> parameters, Connection connection) throws JRException {
        return JasperFillManager.fillReport(report, parameters, connection);
    }
     
    public static void exportReport(String sourceFileName, String destFileName, Map<String, Object> parameters, ReportFormat format) throws JRException, SQLException  {
        JasperReport report = compileReport(sourceFileName);
        
        JasperPrint print = JasperReportService.fillReport(report, parameters, connection.getConnection());
        
        switch(format) {
            case format.HTML -> JasperExportManager.exportReportToHtmlFile(print, destFileName);
            case format.PDF -> JasperExportManager.exportReportToPdfFile(print, destFileName);
            case format.XML -> JasperExportManager.exportReportToXmlFile(print, destFileName, false);
        }
    }
    
    public static void viewReport(String sourceFileName, Map<String, Object> parameters) throws JRException, SQLException {
        JasperReport report = compileReport(sourceFileName);
        JasperPrint print = JasperReportService.fillReport(report, parameters, connection.getConnection());
        JasperViewer.viewReport(print, false);
        
    }
    
    
   
    
    public static void setConnection(DatabaseConnection dbConnection) {
        connection = dbConnection;
    }
    
}
