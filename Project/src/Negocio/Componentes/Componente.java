package Negocio.Componentes;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
 */
public abstract class Componente {
    private final String nome;
    private final Double preco;
    private final String ID;
    private int quantidade;
    private final String descricao;
    private final String tipo;

    public Componente(String n, Double preco, String ID, int qt, String desc, String type) {
	this.nome = n;
	this.preco = preco;
	this.ID = ID;
	this.quantidade = qt;
        this.descricao = desc;
        this.tipo = type;
    }

    public Componente(Componente c) {
	this.nome = c.getNome();
	this.preco = c.getPreco();
	this.ID = c.getID();
	this.quantidade = c.getQuantidade();
        this.descricao = c.getDescricao();
        this.tipo = c.getTipo();
    }

    public String getNome() {
	return nome;
    }

    public Double getPreco() {
	return preco;
    }

    public String getID() {
        return ID;
    }

    public int getQuantidade() {
	return quantidade;
    }

    public String getDescricao() {
	return descricao;
    }
        
    public String getTipo() {
        return this.tipo;
    }

    public void atualizaStock(int quantidade) {
	this.quantidade += quantidade;
    }
}