/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package apresentacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class Controle_Estoque {

    public static void main(String[] args)throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/dbconsultorio", "root", "");
        System.out.println("Conectado!");
        conexao.close();    
     }
    
}
