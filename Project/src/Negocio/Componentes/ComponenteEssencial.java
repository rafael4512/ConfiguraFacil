package Negocio.Componentes;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
 */
public class ComponenteEssencial extends Componente {
    public ComponenteEssencial(String n, Double preco, String ID, int qt, String desc, String type) {
        super(n, preco, ID, qt, desc,type);
    }

    public ComponenteEssencial(Componente c) {
        super(c);
    }
}