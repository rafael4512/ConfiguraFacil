package dataaccess;

import Negocio.Componentes.Componente;
import Negocio.Componentes.ComponenteEssencial;
import Negocio.Componentes.ComponenteOpcional;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
 */
public class ComponenteDAO implements Map<String, Componente> {
    private Connection conn;
    @Override
    public Componente get(Object key) {
    	this.conn = Connect.connect();
    	if(this.conn!=null) {
            try {
                Componente e = null;
                Statement stm = this.conn.createStatement();
                String sql = "SELECT * FROM Componente WHERE ID ='"+(String)key+"'";
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next()) {
                    if(rs.getString(1).substring(0,1).equals("e"))
                        e = new ComponenteEssencial(rs.getString(3),Double.parseDouble(rs.getString(5)),rs.getString(1),Integer.parseInt(rs.getString(6)),rs.getString(4),rs.getString(2));
                    else {
                        Statement nec = this.conn.createStatement();
                        String ness = "SELECT IdNecessidade FROM ComponenteNecessidade WHERE IdComponente='"+(String)key+"'";
                        ResultSet rsness = nec.executeQuery(ness);
                        List<String> necessidades = new ArrayList<>();
                        while(rsness.next()) {
                            necessidades.add(rsness.getString(1));
                        }
                        Statement inc = this.conn.createStatement();
                        String incom = "SELECT IdIncompatibilidade FROM ComponenteIncompatibilidade WHERE IdComponente='"+(String)key+"'";
                        ResultSet rsincom = inc.executeQuery(incom);
                        List<String> incompativeis = new ArrayList<>();
                        while(rsincom.next()) {
                            incompativeis.add(rsincom.getString(1));
                        }
                        e = new ComponenteOpcional(rs.getString(3),Double.parseDouble(rs.getString(5)),rs.getString(1),Integer.parseInt(rs.getString(6)),rs.getString(4),rs.getString(2),incompativeis,necessidades);
                    }
                }
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
    public Componente put(String key, Componente value) {
    	this.conn = Connect.connect();
        if(this.conn!=null) {
            try {
                Statement stm = this.conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT ID FROM Componente WHERE ID='"+key+"'");
                if(rs.next())
                    stm.executeUpdate("UPDATE Componente SET Quantidade='"+value.getQuantidade()+"' WHERE ID='"+key+"'");
                else {
                    String sql = "INSERT INTO Componente VALUES ('"+key+"','"+value.getTipo()+"','"+value.getNome()+"','"+value.getDescricao()+"','"+value.getPreco()+"','"+value.getQuantidade()+"')";
                    stm.executeUpdate(sql);
                    if(value instanceof ComponenteOpcional) {
                        ComponenteOpcional o = (ComponenteOpcional) value;
                        for(String c: o.getNecessidades()) {
                            String sqlNess = "INSERT INTO ComponenteNecessidade VALUES ('"+key+"','"+c+"')";
                            stm.executeUpdate(sqlNess);
                        }
                        for(String c: o.getIncompativeis()) {
                            String sqlIncom = "INSERT INTO ComponenteIncompatibilidade VALUES ('"+key+"','"+c+"')";
                            stm.executeUpdate(sqlIncom);
                        }
                    }
                }
                return value;
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
    public int size() {
    	this.conn = Connect.connect();
        if(this.conn!=null) {
            try {
                int i = 0;
                Statement stm = this.conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT COUNT(ID) FROM Componente");
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
    public Collection<Componente> values() {
    	this.conn = Connect.connect();
    	if (this.conn != null) {
	    try {
	        Collection<Componente> col = new HashSet<>();
	        Statement stm = this.conn.createStatement();
	        ResultSet rs = stm.executeQuery("SELECT * FROM Componente");
	        while(rs.next()) {
	            if(rs.getString(1).substring(0,1).contains("e"))
	                col.add(new ComponenteEssencial(rs.getString(3),Double.parseDouble(rs.getString(5)),rs.getString(1),Integer.parseInt(rs.getString(6)),rs.getString(4),rs.getString(2)));
	            else {
	                List<String> necessidades = new ArrayList<>();
	                List<String> incompatibilidades = new ArrayList<>();
	                Statement sness = this.conn.createStatement();
	                ResultSet ness = sness.executeQuery("SELECT IdNecessidade FROM ComponenteNecessidade WHERE IdComponente='"+rs.getString(1)+"'");
	                while(ness.next()) {
	                    necessidades.add(ness.getString(1));
	                }
	                Statement sincom = this.conn.createStatement();
	                ResultSet incom = sincom.executeQuery("SELECT IdIncompatibilidade FROM ComponenteIncompatibilidade WHERE IdComponente='"+rs.getString(1)+"'");
	                while(incom.next()) {
	                    incompatibilidades.add(incom.getString(1));
	                }
	                col.add(new ComponenteOpcional(rs.getString(3),Double.parseDouble(rs.getString(5)),rs.getString(1),Integer.parseInt(rs.getString(6)),rs.getString(4),rs.getString(2),incompatibilidades,necessidades));
	            }
                }
	        return col;
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
        throw new NullPointerException("public void clear () not implemented!");
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
    public Set<Map.Entry<String,Componente>> entrySet () {
        throw new NullPointerException("public Set<Map.Entry<String,Componente>> entrySet () not implemented!");
    }

    @Override
    public boolean equals (Object o) {
        if(o==null || !(o instanceof Componente)) return false;
        throw new NullPointerException("public boolean equals (Object o) not implemented!");
    }

    @Override
    public int hashCode () {
    	throw new NullPointerException("public int hashCode () not implemented!");
    }

    @Override
    public boolean isEmpty () {
    	throw new NullPointerException("public boolean isEmpty () not implemented!");
    }

    @Override
    public Set<String> keySet () {
        throw new NullPointerException("public Set<String> keySet () not implemented!");
    }

    @Override
    public void putAll (Map<? extends String,? extends Componente> t) {
        throw new NullPointerException("public void putAll (Map<? extends String,? extends Componente> t) not implemented!");
    }

    @Override
    public Componente remove (Object key) {
        throw new NullPointerException("public Componente remove (Object key) not implemented!");
    }
}
