package Negocio.Configuracoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
 */
public class Configuracao {
    private final String ID;
    private final List<String> componentes;
    private double preco;

    public Configuracao(String id) {
	this.ID = id;
	this.componentes = new ArrayList<>();
	this.preco = 0;
    }
    
    public Configuracao(String id, double preco, List<String> comp) {
        this.ID = id;
        this.preco = preco;
        this.componentes = comp;
    }
    
    public void addPacote(List<String> p, double preco) {
        this.preco += preco;
        p.forEach(s->{this.componentes.add(s);});
    }

    public void addComponente(String c, double preco) {
	this.componentes.add(c);
	this.preco += preco;
    }

    public void remComponente(String c, double preco) {
	this.componentes.remove(c);
	this.preco -= preco;
    }

    public String getID() {
	return ID;
    }

    public List<String> getComponentes() {
        return this.componentes;
    }

    public List<String> getComponentesOpcionais() {
        List<String> res = new ArrayList<>();
        this.componentes.stream().filter((c) -> (c.substring(0,1).equals("o"))).forEachOrdered((c) -> {
            res.add(c);
        });
        Collections.sort(res,((String id1, String id2)->id1.compareTo(id2)));
        return res;
    }

    public double getPreco() {
        return preco;
    }
}