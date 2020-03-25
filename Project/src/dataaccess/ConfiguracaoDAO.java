package dataaccess;

import Negocio.Configuracoes.Configuracao;

import java.sql.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
 */
public class ConfiguracaoDAO implements List<Configuracao> {
    private Connection conn;
    
    @Override
    @SuppressWarnings("empty-statement")
    public int size() {
        this.conn = Connect.connect();
        if(this.conn!=null) {
            try {
                int i = 0;
                Statement stm = this.conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT Id FROM Configuracao");
                for(;rs.next();i++);
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
    public boolean add(Configuracao conf) {
        this.conn = Connect.connect();
        if(this.conn!=null) {
            try {
                Statement stm = this.conn.createStatement();
                stm.executeUpdate("INSERT INTO Configuracao VALUES ('"+conf.getID()+"',"+conf.getPreco()+")");
                for(String c: conf.getComponentes())
                    stm.executeUpdate("INSERT INTO ComponenteConfiguracao VALUES ('"+c+"','"+conf.getID()+"')");
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
    public boolean remove (Object key) {
        this.conn = Connect.connect();
        if(this.conn!=null) {
            try {
                boolean res = false;
                Statement stm = this.conn.createStatement();
                Configuracao o = (Configuracao) key;
                int i1 = stm.executeUpdate("DELETE FROM ComponenteConfiguracao WHERE IdConfiguracao='"+o.getID()+"'");
                int i2 = stm.executeUpdate("DELETE FROM Configuracao WHERE Id='"+o.getID()+"'");
                if (i1 > 0 && i2 > 0) res = true;
                return res;
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
    public Configuracao get (int index) {
        this.conn = Connect.connect();
        if(this.conn!=null) {
            try {
                Statement stm = this.conn.createStatement();
                Configuracao conf = null;
                int i;
                ResultSet rs = stm.executeQuery("SELECT * FROM Configuracao");
                for(i = 0; i<index && rs.next() ; i++);
                if(i==index) {
                    Statement stm2 = this.conn.createStatement();
                    ResultSet c = stm2.executeQuery("SELECT IdComponente FROM ComponenteConfiguracao WHERE IdConfiguracao='"+rs.getString(1)+"'");
                    List<String> comp = new ArrayList<>();
                    while(c.next()) {
                        comp.add(c.getString(1));
                    }
                    conf = new Configuracao(rs.getString(1),Double.parseDouble(rs.getString(2)),comp);
                }
                return conf;
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
    public void add (int i,Configuracao conf) {
        throw new NullPointerException("public void add (int i,Configuracao conf) not implemented!");
    }

    @Override
    public void clear () {
        throw new NullPointerException("public void clear () nor implemented!");
    }

    @Override
    public boolean contains (Object o) {
        throw new NullPointerException("public boolean contains (Object o) not implemented!");
    }

    @Override
    public List<Configuracao> subList (int inicio, int fim) {
        throw new NullPointerException("public List<Configuracao> subList (int i, int f) not implemented!");
    }

    @Override
    public boolean isEmpty () {
        throw new NullPointerException("public boolean isEmpty not implemented!");
    }

    @Override
    public int lastIndexOf (Object o) {
        throw new NullPointerException("public int lastIndexOf (Object o) not implemented!");
    }

    @Override
    public Iterator<Configuracao> iterator () {
        throw new NullPointerException("public Iterator<Configuracao> iterator () not implemented!");
    }

    @Override
    public void forEach (Consumer<? super Configuracao> action) {
        throw new NullPointerException("public void forEach (Consumer<? super Configuracao> action) not implemented!");
    }

    @Override
    public Configuracao[] toArray () {
        throw new NullPointerException("public Configuracao[] toArray () not implemented!");
    }

    @Override
    public <Configuracao> Configuracao[] toArray (Configuracao[] a) {
        throw new NullPointerException("public <Configuracao> Configuracao[] toArray (Configuracao[] a) not implemented!");
    }

    @Override
    public ListIterator<Configuracao> listIterator () {
        throw new NullPointerException("public ListIterator<Configuracao> listIterator () not implemented!");
    }

    @Override
    public ListIterator<Configuracao> listIterator (int index) {
        throw new NullPointerException("public ListIterator<Configuracao> listIterator (int index) not implemented!");
    }

    @Override
    public boolean containsAll (Collection<?> c) {
        throw new NullPointerException("public boolean containsAll (Collection<?> c) not implemented!");
    }

    @Override
    public boolean addAll (Collection<? extends Configuracao> c) {
        throw new NullPointerException("public boolean addAll (Collection<? extends Configuracao> c) not implemented!");
    }

    @Override
    public boolean addAll (int index, Collection<? extends Configuracao> c) {
        throw new NullPointerException("public boolean addAll (int index, Collection<? extends Configuracao> c) not implemented!");
    }

    @Override
    public boolean removeAll (Collection<?> c) {
        throw new NullPointerException("public boolean removeAll (Collection<?> c) not implemented!");
    }

    @Override
    public boolean removeIf (Predicate<? super Configuracao> filter) {
        throw new NullPointerException("public boolean removeIf (Predicate<? super Configuracao> filter) not implemented!");
    }

    @Override
    public boolean retainAll (Collection<?> c) {
        throw new NullPointerException("public boolean retainAll (Collection<?> c) not implemented!");
    }

    @Override
    public void replaceAll(UnaryOperator<Configuracao> operator) {
        throw new NullPointerException("public void replaceAll(UnaryOperator<Configuracao> operator) not implemented!");
    }

    @Override
    public void sort(Comparator<? super Configuracao> c) {
        throw new NullPointerException("public void sort(Comparator<? super Configuracao> c) not implemented!");
    }

    @Override
    public Configuracao set (int index, Configuracao element) {
        throw new NullPointerException("public Configuracao set (int index, Configuracao element) not implemented!");
    }

    @Override
    public Configuracao remove (int index) {
        throw new NullPointerException("public Configuracao remove (int index) not implemented!");
    }

    @Override
    public int indexOf (Object o) {
        throw new NullPointerException("public int indexOf (Object o) not implemented!");
    }

    @Override
    public Spliterator<Configuracao> spliterator () {
        throw new NullPointerException("public Spliterator<Configuracao> spliterator () not implemented!");
    }

    @Override
    public Stream<Configuracao> stream () {
        throw new NullPointerException("public Stream<Configuracao> stream () not implemented!");
    }

    @Override
    public Stream<Configuracao> parallelStream () {
        throw new NullPointerException("public Stream<Configuracao> parallelStream () not implemented!");
    }
}
