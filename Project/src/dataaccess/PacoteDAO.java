package dataaccess;

import Negocio.Componentes.Pacote;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
 */
public class PacoteDAO implements List<Pacote> {
    private Connection conn;
    
    @Override
    public int size() {
        this.conn = Connect.connect();
        if(this.conn!=null) {
            try {
                int i = 0;
                Statement stm = this.conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT COUNT(Id) FROM Pacote");
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
    public boolean add(Pacote p) {
        this.conn = Connect.connect();
        if(this.conn!=null) {
            try {
                Statement stm = this.conn.createStatement();
                stm.executeUpdate("DELETE FROM ComponentePacote WHERE IdPacote='"+p.getDescricao()+"'");
                stm.executeUpdate("DELETE FROM Pacote WHERE Id='"+p.getDescricao()+"'");
                String sql = "INSERT INTO Pacote VALUES ('"+p.getDescricao()+"','"+p.getPreco()+"')";
                stm.executeUpdate(sql);
                for(String c: p.getComponentes())
                    stm.executeUpdate("INSERT INTO ComponentePacote VALUES ('"+c+"','"+p.getDescricao()+")");
                return true;
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
    @SuppressWarnings("empty-statement")
    public Pacote get(int index) {
        this.conn = Connect.connect();
        if(this.conn!=null) {
            try {
                Statement stm = this.conn.createStatement();
                Pacote p = null;
                int i;
                ResultSet rs = stm.executeQuery("SELECT * FROM Pacote");
                for(i = 0; i<index && rs.next() ; i++);
                if(i==index) {
                    Statement s = this.conn.createStatement();
                    ResultSet c = s.executeQuery("SELECT IdComponente FROM ComponentePacote WHERE IdPacote='"+rs.getString(1)+"'");
                    List<String> comp = new ArrayList<>();
                    while(c.next()) {
                        comp.add(c.getString(1));
                    }
                    p = new Pacote(rs.getString(1),Double.parseDouble(rs.getString(2)),comp);
                }
                return p;
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
    public boolean isEmpty() {
        throw new NullPointerException("public boolean isEmpty() not implemented!");
    }

    @Override
    public boolean contains(Object o) {
        throw new NullPointerException("public boolean contains(Object o) not implemented!");
    }

    @Override
    public Iterator<Pacote> iterator() {
        throw new NullPointerException("public Iterator<Pacote> iterator() not implemented!");
    }

    @Override
    public Object[] toArray() {
        throw new NullPointerException("public Object[] toArray() not implemented!");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new NullPointerException("public <T> T[] toArray(T[] a) not implemented!");
    }

    @Override
    public boolean remove(Object key) {
        throw new NullPointerException("public boolean remove(Object key) not implemented!");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new NullPointerException("public boolean containsAll(Collection<?> c) not implemented!");
    }

    @Override
    public boolean addAll(Collection<? extends Pacote> c) {
        throw new NullPointerException("public boolean addAll(Collection<? extends Pacote> c) not implemented!");
    }

    @Override
    public boolean addAll(int index, Collection<? extends Pacote> c) {
        throw new NullPointerException("public boolean addAll(int index, Collection<? extends Pacote> c) not implemented!");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new NullPointerException("public boolean removeAll(Collection<?> c) not implemented!");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new NullPointerException("public boolean retainAll(Collection<?> c) not implemented!");
    }

    @Override
    public void clear() {
        throw new NullPointerException("public void clear() not implemented!");
    }

    @Override
    public Pacote set(int index, Pacote element) {
        throw new NullPointerException("public Pacote set(int index, Pacote element) not implemented!");
    }

    @Override
    public void add(int index, Pacote element) {
        throw new NullPointerException("public void add(int index, Pacote element) not implemented!");
    }

    @Override
    public Pacote remove(int index) {
        throw new NullPointerException("public Pacote remove(int index) not implemented!");
    }

    @Override
    public int indexOf(Object o) {
        throw new NullPointerException("public int indexOf(Object o) not implemented!");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new NullPointerException("public int lastIndexOf(Object o) not implemented!");
    }

    @Override
    public ListIterator<Pacote> listIterator() {
        throw new NullPointerException("public ListIterator<Pacote> listIterator() not implemented!");
    }

    @Override
    public ListIterator<Pacote> listIterator(int index) {
        throw new NullPointerException("public ListIterator<Pacote> listIterator(int index) not implemented!");
    }

    @Override
    public List<Pacote> subList(int fromIndex, int toIndex) {
        throw new NullPointerException("public List<Pacote> subList(int fromIndex, int toIndex) not implemented!");
    }
}