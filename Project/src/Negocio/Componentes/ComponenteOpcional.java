package Negocio.Componentes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
 */
public class ComponenteOpcional extends Componente {
    private final List<String> incompativeis;
    private final List<String> necessidades;

    public ComponenteOpcional (String nome, Double preco, String ID, int quantidade, String descricao, String type, List<String> i, List<String> n) {
        super(nome,preco,ID,quantidade,descricao,type);
        this.incompativeis = new ArrayList<>();
        i.forEach(co->{this.incompativeis.add(co);});
        this.necessidades = new ArrayList<>();
        n.forEach(co->{this.necessidades.add(co);});
    }

    

    public ComponenteOpcional(ComponenteOpcional co) {
        super(co);
        this.incompativeis = new ArrayList<>();
        co.getIncompativeis().forEach(c->{this.incompativeis.add(c);});
        this.necessidades = new ArrayList<>();
        co.getNecessidades().forEach(c->{this.necessidades.add(c);});
    }

    public List<String> getIncompativeis() {
        return this.incompativeis;
    }

    public List<String> getNecessidades() {
        return this.necessidades;
    }

    public ComponenteOpcional clone() {
        return new ComponenteOpcional(this);
    }
}