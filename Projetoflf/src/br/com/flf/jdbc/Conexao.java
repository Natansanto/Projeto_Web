package br.com.flf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";    
    //Foi utilizado um outro banco com o nome{Livro} 
    private static final String URL = "jdbc:postgresql://localhost:5432/Livro";
    private static final String DRIVER = "org.postgresql.Driver";
    
    public Connection abrir() throws Exception {
        Class.forName(DRIVER);  
        
        Connection conn = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
        return conn; 
    }
    public void close(Connection conn) throws Exception {
        conn.close();
    } 

}


