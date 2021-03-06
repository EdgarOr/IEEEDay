/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieeeday;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Adrián
 */
public class DataBaseHelper {

    private Connection conexion;
    private Statement statement;
    private String servidor;
    private String puerto;
    private String usuario;
    private String pass;

    /**
     * Constructor con datos estándar
     */
    public DataBaseHelper() {
        this("jdbc:mysql://localhost/ieee?autoReconnect=true&useSSL=false", "3306", "root", "");
    }

    /**
     * Constructor con host y puertos estándar
     *
     * @param usuario user de la base de datos
     * @param pass contraseña de la base de datos
     */
    public DataBaseHelper(String usuario, String pass) {
        this("jdbc:mysql://localhost/ieee?autoReconnect=true&useSSL=false", "3306", usuario, pass);
    }

    /**
     * Constructor con servidor estandar
     *
     * @param puerto puerto del servidor mysql
     * @param usuario user de la base de datos
     * @param pass contraseña de la base de datos
     */
    public DataBaseHelper(String puerto, String usuario, String pass) {
        this("jdbc:mysql://localhost/ieee?autoReconnect=true&useSSL=false", puerto, usuario, pass);
    }

    /**
     * Constructor con datos específicos
     *
     * @param servidor Servidor de la base de datos (conexión remota)
     * @param puerto puerto del servidor mysql
     * @param usuario user de la base de datos
     * @param pass contraseña de la base de datos
     */
    public DataBaseHelper(String servidor, String puerto, String usuario, String pass) {
        conexion = null;
        statement = null;
        this.servidor = servidor;
        this.puerto = puerto;
        this.usuario = usuario;
        this.pass = pass;

    }

    /**
     *
     * @return true si la conexión se realizó correctamente, falso de otro modo
     * @throws ClassNotFoundException
     */
    public boolean iniciarConexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection(servidor, usuario, pass);
        return true;
    }

    /**
     *
     * @param query
     * @return un ResultSet con los datos de la consulta
     * @throws SQLException
     */
    public ResultSet resultSetFromQuery(String query) throws SQLException {
        statement = conexion.createStatement();
        return statement.executeQuery(query);
    }
    
    public void query (String porcentaje) throws SQLException, UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();        
        StringBuilder sb = new StringBuilder();
        sb.append("insert into bitacora_memoria(nombre_equipo, porcentaje_memoria, "
                + "fecha_registro) values ('").append(host.getHostName()).append("', ").append(porcentaje).
                append(", now());");
        System.out.println(sb.toString());
        executeQuery(sb.toString());
    }

    public boolean executeQuery(String query) throws SQLException {
        statement = conexion.createStatement();
        statement.execute(query);
        return true;
    }

    
    public boolean cerrarConexion() throws  SQLException{
        conexion.close();
        statement.close();
        return true;
    }
    
    public Connection getConexion() {
        return conexion;
    }

}
