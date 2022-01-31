/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.gui.tablemodel.renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Mikeias
 */
public class TableTituloRenderer extends DefaultTableCellRenderer{

    private final String entrada = "ENTRADA (+)";
    private final String saida = "SAIDA (-)";
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        final JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
        c.setOpaque(true);
        
        c.setOpaque(true);
        
        Object texto = table.getValueAt(row, 6);
        
        table.setSelectionBackground(new Color(253, 254, 254));
        table.setSelectionForeground(Color.BLACK);
        
        if(table.getSelectedRow() > -1){
            c.setBackground(Color.WHITE);
            c.setForeground(Color.BLACK);
        }
        
        if(texto != null && saida.equals(texto.toString())){
            c.setBackground(new Color(253, 237, 236));
            c.setForeground(Color.BLACK);
            
            if(row % 2 == 0){
                c.setBackground(new Color(250, 219, 216)); // Background padrao para Saidas
                c.setForeground(Color.BLACK);
            }else{
                c.setBackground(new Color(253, 237, 236));
                c.setForeground(Color.BLACK);
            }
            
        }else if(texto != null && entrada.equals(texto.toString())){
            c.setBackground(new Color(234, 250, 241));
            c.setForeground(Color.BLACK);
            
            if(row % 2 == 0){
                c.setBackground(new Color(213, 245, 227)); // Background padrao para Entradas
                c.setForeground(Color.BLACK);
            }else{
               c.setBackground(new Color(234, 250, 241));
               c.setForeground(Color.BLACK);
            }
        }else{
            c.setBackground(new Color(229, 232, 232 ));
        }
        
        if(isSelected){
            c.setBackground(new Color(229, 232, 232 ));
            c.setForeground(Color.BLACK);
        }else{
            
        }
        
        return c;
    }
}
