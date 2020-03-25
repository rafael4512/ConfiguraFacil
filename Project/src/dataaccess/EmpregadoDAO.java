package dataaccess;

import Negocio.Empregados.Empregado;

import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.sql.*;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
 */
public class EmpregadoDAO implements Map<String, Empregado> {
    private Connection conn;
    
    @Override
    public Empregado get (Object key) {
        this.conn = Connect.connect();
        if(this.conn!=null) {
            try {
                Empregado e = null;
                Statement stm = this.conn.createStatement();
                String sql = "SELECT * FROM Empregado WHERE UserName ='"+(String)key+"'";
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next())
                    e = new Empregado(rs.getString(1),rs.getString(2));
                return e;
            }
            catch (SQLException e) {
                throw new NullPointerException(e.getMessage());
            }
            finally {
                Connect.close(this.conn);
            }
        }
        throw new NullPointerException("Conexao invalida");
    }
    
    @Override
    public Empregado put (String key, Empregado value) {
        this.conn = Connect.connect();
        if(this.conn!=null) {
            try {
                Empregado e = null;
                Statement stm = this.conn.createStatement();
                stm.executeUpdate("DELETE FROM Empregado WHERE UserName='"+key+"'");
                String sql = "INSERT INTO Empregado VALUES ('"+key+"','"+value.getPassword()+"')";
                int i = stm.executeUpdate(sql);
                if (i>0)
                    e = new Empregado(value.getUserName(),value.getPassword());
                return e;
            }
            catch (SQLException e) {
                throw new NullPointerException(e.getMessage());
            }
            finally {
                Connect.close(this.conn);
            }
        }
        throw new NullPointerException("Conexao invalida");
    }
    
    @Override
    public int size () {
        this.conn = Connect.connect();
        if(this.conn!=null) {
            try {    
                int i = 0;
                Statement stm = this.conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT COUNT(UserName) FROM Empregado");
                if(rs.next()) i = Integer.parseInt(rs.getString(1));
                return i;
            }
            catch (SQLException e) {
                throw new NullPointerException(e.getMessage());
            }
            finally {
                Connect.close(this.conn);
            }
        }
        throw new NullPointerException("Conexao invalida");
    }
    
    @Override
    public void clear () {
        throw new NullPointerException("public void clear() not implemented!");
    }

    @Override
    public boolean containsKey (Object key) {
        throw new NullPointerException("public boolean containsKey (Object key) not implemented!");
    }

    @Override
    public boolean containsValue (Object value) {
        throw new NullPointerException("public boolean containsValue (Object value) not implemented!");
    }

    @Override
    public Set<Map.Entry<String,Empregado>> entrySet () {
        throw new NullPointerException("public Set<Map.Entry<String,Empregado>> entrySet () not implemented!");
    }

    @Override
    public boolean equals (Object o) {
        if(o==null || !(o instanceof Empregado)) return false;
        throw new NullPointerException("public boolean equals (Object o) not implemented!");
    }

    @Override
    public int hashCode() {
        throw new NullPointerException("public int hashCode() not implemented!");
    }

    @Override
    public boolean isEmpty () {
        throw new NullPointerException("public boolean isEmpty() not implemented!");
    }

    @Override
    public Set<String> keySet () {
        throw new NullPointerException("public Set<String> keySet () not implemented!");
    }

    @Override
    public void putAll (Map<? extends String,? extends Empregado> t) {
        throw new NullPointerException("public void putAll (Map<? extends String,? extends Empregado> t) not implemented!");
    }

    @Override
    public Empregado remove (Object key) {
        throw new NullPointerException("public Empregado remove (Object key) not implemented!");
    }

    @Override
    public Collection<Empregado> values () {
        throw new NullPointerException("public Collection<Empregado> values () not implemented!");
    }
}
