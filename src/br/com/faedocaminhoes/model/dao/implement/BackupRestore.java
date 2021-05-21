/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mikeias
 */

public class BackupRestore {

    public static List<String> realizaRestore(String host, String port, String user, String base, String diretorio, String senha) {
        final List<String> comandos = new ArrayList<String>();
        final List<String> out = new ArrayList<>();
        
        comandos.add("C:\\Arquivos de programas\\PostgreSQL\\12\\bin\\pg_restore.exe");
        comandos.add("-h");
        comandos.add(host);//Host postgres ex. localhost ou 127.0.0.1 
        comandos.add("-p");
        comandos.add(port);//Porta postgres ex. 5432      
        comandos.add("-U");
        comandos.add(user);//Usuario postgres ex. postgres
        comandos.add("-d");
        comandos.add(base);//Nome do banco de dados    
        comandos.add("-v");
        comandos.add(diretorio);//Diretorio do backup ex. C:\bkp.sql

        ProcessBuilder pb = new ProcessBuilder(comandos);
        pb.environment().put("PGPASSWORD", senha);//Senha do postgres requerida        

        try {
            final Process process = pb.start();
            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            String line = r.readLine();
            int c = 0;
            while (line != null) {
                System.err.println(line);
                c = c + 1;
                line = r.readLine();
                out.add("["+c+"] "+line);
            }
            r.close();
            process.waitFor();
            process.destroy();
            return out;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao restaurar.\n" + e, "Erro", JOptionPane.ERROR);
            return null;
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao restaurar.\n" + ie, "Erro", JOptionPane.ERROR);
            return null;
        }
    }

    public static List<String> realizaBackup(String diretorio, String host, String port, String user, String base, String senha) {
        final List<String> comandos = new ArrayList<String>();
        final List<String> out = new ArrayList<String>();

        comandos.add("C:\\Arquivos de programas\\PostgreSQL\\12\\bin\\pg_dump.exe");//Patch do pg_Dump na pasta do postgres  
        comandos.add("-h");
        comandos.add(host);//Host postgres ex. localhost ou 127.0.0.1 
        comandos.add("-p");
        comandos.add(port);//Porta postgres ex. 5432      
        comandos.add("-U");
        comandos.add(user);//Usuario postgres ex. postgres      
        comandos.add("-F");
        comandos.add("c");
        comandos.add("-b");
        comandos.add("-v");
        comandos.add("-f");
        comandos.add(diretorio);//Diretorio do backup ex. C:\bkp.sql
        comandos.add(base);//Nome do banco de dados

        ProcessBuilder pb = new ProcessBuilder(comandos);
        pb.environment().put("PGPASSWORD", senha);//Senha do postgres requerida

        try {
            final Process process = pb.start();
            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            String line = r.readLine();
            int c = 0;
            while (line != null) {
                System.err.println(line);
                c = c + 1;
                line = r.readLine();
                out.add("["+c+"] "+line);
            }
            r.close();
            process.waitFor();
            process.destroy();
            return out;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar backup.\n" + e, "Erro", JOptionPane.ERROR);
            return null;
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar backup.\n" + ie, "Erro", JOptionPane.ERROR);
            return null;
        }
    }

    public static List<String> createDb(String host, String usuario, String base, String senha) {
        final List<String> comandos = new ArrayList<String>();
        final List<String> out = new ArrayList<String>();

        comandos.add("C:\\Arquivos de programas\\PostgreSQL\\12\\bin\\createdb.exe");    // esse é meu caminho  
        comandos.add("-h");
        comandos.add(host);//Host postgres ex. localhost ou 127.0.0.1 
        comandos.add("-U");
        comandos.add(usuario);//Usuario postgres ex. postgres  
        comandos.add(base);//Nome do banco de dados

        ProcessBuilder pb = new ProcessBuilder(comandos);
        pb.environment().put("PGPASSWORD", senha);

        try {
            final Process process = pb.start();
            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            String line = r.readLine();
            int c = 0;
            while (line != null) {
                System.err.println(line);
                c = c + 1;
                line = r.readLine();
                out.add("["+c+"] "+line);
            }
            r.close();
            process.waitFor();
            process.destroy();
            return out;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao criar banco de dados.\n" + e, "Erro", JOptionPane.ERROR);
            return null;
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao criar banco de dados.\n" + ie, "Erro", JOptionPane.ERROR);
            return null;
        }
    }
}

