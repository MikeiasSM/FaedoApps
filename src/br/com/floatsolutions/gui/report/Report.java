/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.gui.report;

import br.com.floatsolutions.uteis.JPaneError;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Poison
 */
public class Report {
    
    public static void geraReport(List dataSetList, HashMap<String, Object> parameters, String patchReport){
    
        try{
            //Seto arquivo Jasper do repósitorio Next/Report
            InputStream src = new FileInputStream(patchReport);

            //Crio um DataSet a partir do list passado por parametro
            JRBeanCollectionDataSource jb = new JRBeanCollectionDataSource(dataSetList);

            //Gero o relatório com os dataset, parametros e o src passado por parâmetro
            JasperPrint jasperprint = JasperFillManager.fillReport(src, parameters, jb);
            
            //Cria uma view e mostra o relatório criado na tela
            JasperViewer view = new JasperViewer(jasperprint, false);
            //Seta o titulo da view
            view.setTitle("Next Software ₢");
            //Seta a view como maximizada
            view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            //Seta a view como visivel
            view.setVisible(true);
            
        }catch(FileNotFoundException | JRException e){
            JPaneError.showErrorDialog(null, "Erro ao criar relatório!", e);
            e.printStackTrace();
        }
    
    }
}
