/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.gui.tablemodel;

import br.com.faedocaminhoes.model.Cidade;
import br.com.faedocaminhoes.model.Empresa;
import br.com.faedocaminhoes.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Poison
 */
public class EmpresaTableModel extends AbstractTableModel{

    private final List<Empresa> dados = new ArrayList<>();
    private final String[] colunas = {"Código",
                                      "Razão Social", 
                                      "Nome Fantasia", 
                                      "CNPJ", 
                                      "Insc. Estadual", 
                                      "Logradouro", 
                                      "Bairro", 
                                      "Cidade", 
                                      "Telefone", 
                                      "E-mail", 
                                      "Usuario"};

    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
       return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {
        switch(colunaIndex){
            case 0:
                return dados.get(linhaIndex).getId();
            case 1:
                return dados.get(linhaIndex).getRazao();
            case 2:
                return dados.get(linhaIndex).getFantasia();
            case 3:
                return dados.get(linhaIndex).getCpf_cnpj();
            case 4:
                return dados.get(linhaIndex).getInscricao_estadual();
            case 5:
                return dados.get(linhaIndex).getLogradouro();
            case 6:
                return dados.get(linhaIndex).getBairro();
            case 7:
                return dados.get(linhaIndex).getCidade();
            case 8:
                return dados.get(linhaIndex).getTelefone();
            case 9:
                return dados.get(linhaIndex).getEmail();
            case 10:
                return dados.get(linhaIndex).getUsuario();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object valor, int linhaIndex, int coluna) {
        switch(coluna){
            case 0:
                dados.get(linhaIndex).setId((Integer) valor);
            case 1:
                dados.get(linhaIndex).setRazao((String) valor);
            case 2:
                dados.get(linhaIndex).setFantasia((String) valor);
            case 3:
                dados.get(linhaIndex).setCpf_cnpj((String) valor);
            case 4:
                dados.get(linhaIndex).setInscricao_estadual((String) valor);
            case 5:
                dados.get(linhaIndex).setLogradouro((String) valor);
            case 6:
                dados.get(linhaIndex).setBairro((String) valor);
            case 7:
                dados.get(linhaIndex).setCidade((Cidade) valor);
            case 8:
                dados.get(linhaIndex).setTelefone((String) valor);
            case 9:
                dados.get(linhaIndex).setEmail((String) valor);
            case 10:
                dados.get(linhaIndex).setUsuario((Usuario) valor);
            }
    }
    
    public void addRow(Empresa obj){
        this.dados.add(obj);
        this.fireTableDataChanged();
    }
        
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
    
    public void removeAll(){
        this.dados.clear();
        this.fireTableDataChanged();
    }
    
    public Empresa getObject(int linha){
        Empresa empresa = this.dados.get(linha);
        return empresa;
    }
}
