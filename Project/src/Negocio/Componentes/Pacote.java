package Negocio.Componentes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
 */
public class Pacote {
    private final List<String> componentes;
    private final String descricao;
    private final double preco;
    
    public Pacote(String desc, double preco, List<String> comp) {
        this.descricao = desc;
        this.preco = preco;
        this.componentes = comp;
    }
    
    public Pacote(Pacote p) {
        this.descricao = p.getDescricao();
        this.preco = p.getPreco();
        this.componentes = new ArrayList<>();
        p.getComponentes().forEach(a->{this.componentes.add(a);});
    }

    public List<String> getComponentes() {
    	return this.componentes;
    }

    public String getDescricao() {
    	return this.descricao;
    }

    public double getPreco() {
        return this.preco;
    }
    
    public Pacote clone(Pacote p) {
        return new Pacote(p);
    }
}