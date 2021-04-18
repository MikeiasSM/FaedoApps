/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao.implement;

import java.io.BufferedReader;
import java.io.File;
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
    
    private Integer id;
    private String nomeArq;
    private String nomeDir;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNomeArq() {
        return nomeArq;
    }

    public void setNomeArq(String nomeArq) {
        this.nomeArq = nomeArq;
    }

    public String getNomeDir() {
        return nomeDir;
    }

    public void setNomeDir(String nomeDir) {
        this.nomeDir = nomeDir;
    }
    
    public static void fazBackup(String arquivo, String diretorio){
        File arq = new File(arquivo);
        if (arq.exists()){
                if (arq.length() > 0)
                        arq.delete();
        }
        try {
                Process p = null;
                String linha = "";
                ProcessBuilder pb = new ProcessBuilder(diretorio+"pg_dump.exe", "-i", "-h", "127.0.0.1", "-U", "database", "-F", "c", "-b", "-v", "-f", arquivo, "postgres");
                pb.environment().put("PGPASSWORD", "admin");
                pb.redirectErrorStream(true);
                p = pb.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((linha = reader.readLine()) != null){
                        System.out.println(linha);
                }
        }catch (Exception e) {
                System.out.println("Erro:"+e);
        }
    }
    public static void realizaRestore(String diretorio) throws IOException, InterruptedException{      
           final List<String> comandos = new ArrayList<String>();      
           comandos.add("C:\\Arquivos de programas\\PostgreSQL\\12\\bin\\pg_restore.exe"); //testado no windows xp
           //comandos.add("-i");      
           comandos.add("-h");      
           comandos.add("localhost");    //ou   comandos.add("192.168.0.1"); 
           comandos.add("-p");      
           comandos.add("5432");      
           comandos.add("-U");      
           comandos.add("postgres");      
           comandos.add("-d");      
           comandos.add("database");     
           //comandos.add(arquivo);     
           comandos.add("-v");      
           //comandos.add("C:\\Acess\\Dados\\bkp_24_03_19.backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
           comandos.add(diretorio);   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
           ProcessBuilder pb = new ProcessBuilder(comandos);      
           pb.environment().put("PGPASSWORD", "admin");     //Somente coloque sua senha         
           try {      
               final Process process = pb.start();      
               final BufferedReader r = new BufferedReader(      
                   new InputStreamReader(process.getErrorStream()));      
               String line = r.readLine();      
               while (line != null) {      
               System.err.println(line);      
               line = r.readLine();      
               }      
               r.close();      
               process.waitFor();    
               process.destroy();  
           } catch (IOException e) {      
               e.printStackTrace();
               JOptionPane.showMessageDialog(null,"Erro ao restaurar.\n"+e, "Erro", JOptionPane.ERROR);
           } catch (InterruptedException ie) {      
               ie.printStackTrace();
               JOptionPane.showMessageDialog(null,"Erro ao restaurar.\n"+ie, "Erro", JOptionPane.ERROR);
           }         
       }
    public static void realizaBackup(String diretorio) throws IOException, InterruptedException{      
           final List<String> comandos = new ArrayList<String>();      
           //comandos.add("C:\\Program Files (x86)\\PostgreSQL\\8.4\\bin\\pg_dump.exe"); 
          //comandos.add("C:\\Program Files\\PostgresPlus\\8.4SS\\bin\\pg_dump.exe"); 
           comandos.add("C:\\Arquivos de programas\\PostgreSQL\\12\\bin\\pg_dump.exe");    // esse é meu caminho  
           //comandos.add("-i");      
           comandos.add("-h");      
           comandos.add("localhost");     //ou  comandos.add("192.168.0.1"); 
           comandos.add("-p");      
           comandos.add("5432");      
           comandos.add("-U");      
           comandos.add("postgres");      
           comandos.add("-F");      
           comandos.add("c");      
           comandos.add("-b");      
           comandos.add("-v");      
           comandos.add("-f");      
           //comandos.add("C:\\Acess\\Dados\\bkp_24_03_19.backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
           comandos.add(diretorio);   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
           comandos.add("database");      
           ProcessBuilder pb = new ProcessBuilder(comandos);      
           pb.environment().put("PGPASSWORD", "admin");      //Somente coloque sua senha         
           try {      
               final Process process = pb.start();      
               final BufferedReader r = new BufferedReader(      
                   new InputStreamReader(process.getErrorStream()));      
               String line = r.readLine();      
               while (line != null) {      
               System.err.println(line);      
               line = r.readLine();      
               }      
               r.close();      
               process.waitFor();    
               process.destroy(); 
           } catch (IOException e) {      
               e.printStackTrace();
               JOptionPane.showMessageDialog(null,"Erro ao gerar backup.\n"+e, "Erro", JOptionPane.ERROR);
           } catch (InterruptedException ie) {      
               ie.printStackTrace();
               JOptionPane.showMessageDialog(null,"Erro ao gerar backup.\n"+ie, "Erro", JOptionPane.ERROR);
           }
    }
    public static void createDb(String nomeDB, String usuario, String senha) throws IOException, InterruptedException{      
           final List<String> comandos = new ArrayList<String>(); 
           //createdb -h localhost -U postgres dados 
           comandos.add("C:\\Arquivos de programas\\PostgreSQL\\12\\bin\\createdb.exe");    // esse é meu caminho  
           //comandos.add("createdb");      
           comandos.add("-h");
           comandos.add("localhost");      
           comandos.add("-U");      
           comandos.add(usuario);      
           comandos.add(nomeDB);      
           ProcessBuilder pb = new ProcessBuilder(comandos);      
           pb.environment().put("PGPASSWORD", senha);       
            try {      
               final Process process = pb.start();      
               final BufferedReader r = new BufferedReader(      
                   new InputStreamReader(process.getErrorStream()));      
               String line = r.readLine();      
               while (line != null) {      
               System.err.println(line);      
               line = r.readLine();      
               }      
               r.close();      
               process.waitFor();    
               process.destroy(); 
            } catch (IOException e) {      
               e.printStackTrace();
               JOptionPane.showMessageDialog(null,"Erro ao criar banco de dados.\n"+e, "Erro", JOptionPane.ERROR);
            } catch (InterruptedException ie) {      
               ie.printStackTrace();
               JOptionPane.showMessageDialog(null,"Erro ao criar banco de dados.\n"+ie, "Erro", JOptionPane.ERROR);
            }
    }
}

