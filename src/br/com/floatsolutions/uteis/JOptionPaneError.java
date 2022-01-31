/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.uteis;

import java.awt.Component;
import java.awt.Dimension;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Poison
 */
public class JOptionPaneError {

    public static void showErrorDialog(Component c, String error_message, Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.println("Erro ao executar processo!");
        t.printStackTrace(pw);
        pw.flush();

        JTextArea ta = new  JTextArea(sw.toString(), 15, 60);
        JScrollPane sp = new  JScrollPane(ta);
        sp.setPreferredSize(new Dimension(450, 220));
        JOptionPane.showMessageDialog(c, sp,error_message, JOptionPane.ERROR_MESSAGE);
    }
}
