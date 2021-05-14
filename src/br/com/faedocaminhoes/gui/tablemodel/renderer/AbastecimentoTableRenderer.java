/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.gui.tablemodel.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Poison
 */
public class AbastecimentoTableRenderer extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        final JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
        c.setOpaque(true);
                
        c.setFont(new Font("Segoe UI", 0, 12));
        c.setBackground(new Color(235, 245, 251));
        
        if(row % 2 == 0){
            c.setBackground(new Color(214, 234, 248));
            c.setForeground(Color.BLACK);
        }else{
            c.setBackground(new Color(235, 245, 251));
            c.setForeground(Color.BLACK);
        }    
        
        if(isSelected){
            c.setBackground(new Color(214, 234, 248));
            c.setForeground(Color.BLACK);
        }    
        
        return c;
    }
}
