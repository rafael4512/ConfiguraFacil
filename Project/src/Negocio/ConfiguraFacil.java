package Negocio;

import Negocio.Componentes.*;
import Negocio.Configuracoes.*;
import Negocio.Empregados.*;
import dataaccess.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
 */
public class ConfiguraFacil {
    private final ConfiguracaoDAO configuracoes;
    private final PacoteDAO pacotes;
    private final ComponenteDAO componentes;
    private final EmpregadoDAO empregados;
    private int quantidadeAtual = 0;
    private int quantidadeConf = 0;
    
    public ConfiguraFacil() {
        this.empregados = new EmpregadoDAO();
        this.componentes = new ComponenteDAO();
        this.configuracoes = new ConfiguracaoDAO();
        this.pacotes = new PacoteDAO();
        this.componentes.values().forEach((c)->{
            this.quantidadeAtual += c.getQuantidade();
        });
        this.quantidadeConf = this.configuracoes.size();
    }
    
    /**
     * Remover uma configuração já produzida e decrementar a quantidade de configurações em fila de espera
     * @param conf
     */
    public void RemConfig(Configuracao conf) {
        this.configuracoes.remove(conf);
        this.quantidadeConf -= 1;
    }
    
    /**
     * Adicionar stock de um dado componente
     * @param name
     * @param quantidade
     * @return res
     * @throws ArmCheioException
     */
    public List<String> AddCompStock(String name, int quantidade) throws ArmCheioException{
    	if((this.quantidadeAtual+quantidade) > 10000) {
            throw new ArmCheioException();
	}
	else {
            try {
                for(Componente c: this.componentes.values())
                    if(c.getNome().equals(name)) {
                        c.atualizaStock(quantidade);
                        this.componentes.put(c.getID(),c);
                        this.quantidadeAtual += quantidade;
                        break;
                    }
                List<Configuracao> prodRealizadas = calculaProducoes();
                List<String> res = new ArrayList<>();
                prodRealizadas.forEach(a->{
                    res.add(a.getID());
                    a.getComponentes().forEach(c->{RemCompStock(c);});
                    RemConfig(a);
                });
                return res;
            }
            catch (NullPointerException e){
                return null;
            }
        }
    }
    
    /**
     * Calcular quais as seguintes configurações a serem produzidas
     * @return res
     */
    public List<Configuracao> calculaProducoes() {
        List<Configuracao> res = new ArrayList<>();
        List<Configuracao> todas = new ArrayList<>();
        int i = 1;
        while(i <= this.configuracoes.size()) {
            todas.add(this.configuracoes.get(i));
            i++;
        }
        Collections.sort(todas,(Object id1,Object id2)->((Configuracao)id1).getID().compareTo(((Configuracao)id2).getID()));
        for(Configuracao conf: todas) {
            boolean possivel = true;
            for(String c: conf.getComponentes()) {
                if(possivel && this.componentes.get(c).getQuantidade() == 0) {
                    possivel = false;
                    break;
                }
            }
            if (possivel)
                res.add(conf);
            else break;
        }
        return res;
    }
    
    /**
     * Todos os componentes da Fabrica ordenados por identificador
     * @return res
     */  
    public List<Componente> getSortComponentes() {
        List<Componente> res = new ArrayList<>();
        this.componentes.values().forEach((c)->{res.add(c);});
        Collections.sort(res,(Object id1,Object id2)->((Componente)id1).getID().compareTo(((Componente)id2).getID()));
        return res;
    }
    
    /**
     * Componente identificado pelo ID
     * @param ID
     * @return componente
     */
    public Componente getComponente(String ID) {
        return this.componentes.get(ID);
    }
    
    /**
     * Dado um nome de um componente devolver o componente
     * @param nome
     * @return c
     */
    public Componente getComponenteNome(String nome) {
        for(Componente c: this.componentes.values())
            if(c.getNome().equals(nome))
                return c;
        return null;
    }

    /**
     * Remove stock a um certo componente
     * @param id
     */
    public void RemCompStock(String id) {
	Componente c = this.componentes.get(id);
        c.atualizaStock(-1);
        this.componentes.put(id,c);
        this.quantidadeAtual -= 1;
    }

    /**
     * Criar Configuracao
     * @return conf
     */
    public Configuracao criarConfiguracao() {
        int id;
        Configuracao c = this.configuracoes.get(this.configuracoes.size());
        if(c == null)
            id = 1;
        else {
            id = Integer.parseInt(c.getID());
            id += 1;
        }
	return new Configuracao(Integer.toString(id));
    }

    /**
     * Obter lista de todos os Componentes Opcionais
     * @return res
     */
    public List<Componente> getComponentesOpcionais() {
	List<Componente> res = new ArrayList<>();
        this.componentes.values().stream().filter((c) -> (c.getID().substring(0,1).equals("o"))).forEachOrdered((c) -> {
            res.add(c);
        });
        Collections.sort(res,(Componente id1,Componente id2)->id1.getID().compareTo(id2.getID()));
	return res;
    }

    /**
     * Obter lista de todos os Componentes Essenciais oredenados por identificador
     * @return res
     */
    public List<Componente> getComponentesEssenciais() {
    	List<Componente> res = new ArrayList<>();
        this.componentes.values().stream().filter((c) -> (c.getID().substring(0,1).equals("e"))).forEachOrdered((c) -> {
            res.add(c);
        });
        Collections.sort(res,(Componente id1,Componente id2)->id1.getID().compareTo(id2.getID()));
	return res;
    }
    
    /**
     * Verificar se componentes opcionais escolhidos são iguais a um pacote existente
     * @param conf
     * @return resultado
     */
    public String verificaCompPacote(Configuracao conf) {
	int res, i = 1;
	String resultado = null;
	List<String> listComp = conf.getComponentesOpcionais();
        while(i <= this.pacotes.size()){
            Pacote p = this.pacotes.get(i);
            List<String> listC = p.getComponentes();
            if (listComp.size() == listC.size()) {
                res = 1;
		for(String c: listComp) {
                    if(!listC.contains(c)) {
                        res = 0;
                        break;
                    }
                }
                if(res == 1) {
                    resultado = p.getDescricao();
                    break;
                }                           
            }
            i++;
	}
	return resultado;
    }

    /**
     * Calcular as necessidades para o componente escolhido para uma certa configuração
     * @param conf
     * @param c
     * @return res
     */
    public List<String> calculaNecessidades(Configuracao conf, ComponenteOpcional c){
	List<String> res = new ArrayList<>();
	List<String> comp = conf.getComponentesOpcionais();
        c.getNecessidades().stream().filter(ness->(!comp.contains(ness))).forEachOrdered(ness->{
            res.add(ness);
        });
        return res;
    }

    /**
     * Calcular as incompatibilidades para os componentes escolhidos para uma certa configuração
     * @param conf
     * @param lc
     * @return res
     */
    public List<String> calculaIncompatibilidades(Configuracao conf, List<String> lc){
    	List<String> res = new ArrayList<>();
    	List<String> comp = conf.getComponentesOpcionais();
        lc.stream().map(c->(ComponenteOpcional)this.componentes.get(c)).forEachOrdered(co->{
            co.getIncompativeis().stream().filter(ci->(comp.contains(ci))).forEachOrdered(ci->{
                res.add(ci);
            });
        });
	return res;
    }

    /**
     * Inserir configuração na fila
     * @param c
     * @throws ConfCheiaException
     */
    public void insereConfiguracao(Configuracao c) throws ConfCheiaException {
        if((this.quantidadeConf+1) < 100) {
            this.configuracoes.add(c);
            this.quantidadeConf += 1;
        }
        else {
            throw new ConfCheiaException();
        }
    }

    /**
     * Adicionar componentes numa configuração
     * @param conf 
     * @param c
     * @return conf
     */
    public Configuracao addComponente(Configuracao conf, List<String> c) {
        c.forEach(comp->{
            conf.addComponente(comp,this.componentes.get(comp).getPreco());
        });
        return conf;
    }
    
    /**
     * Adiciona todos os componentes de um pacote a uma configuração
     * @param conf
     * @param nome
     * @return conf
     */
    public Configuracao addPacote(Configuracao conf, String nome) {
        int i = 1;
        while(i <= this.pacotes.size()) {
            Pacote p = this.pacotes.get(i);
            if(p.getDescricao().equals(nome)) {
                conf.addPacote(p.getComponentes(),p.getPreco());
                break;
            }
            i++; 
        }
        return conf;
    }
    
    /**
     * Remover todos os componentes dados pela lista
     * @param c
     * @param comp
     * @return c
     */
    public Configuracao remComponentes(Configuracao c, List<String> comp) {
        comp.forEach(co->{
            c.remComponente(co,this.componentes.get(co).getPreco());
        });
        return c;
    }
    
    /**
     * Remover todos os componentes opcionais de uma configuração
     * @param c
     * @return c
     */
    public Configuracao remCompOp(Configuracao c) {
        List<String> res = new ArrayList<>();
        for(String s: c.getComponentes())
            if(s.substring(0,1).equals("o"))
                res.add(s);
        c = remComponentes(c,res);
        return c;
    }
    
    /**
     * Remover o componente essencial com um certo tipo de uma configuração
     * @param conf
     * @param tipo
     * @return conf
     */
    public Configuracao remComp(Configuracao conf, String tipo) {
        Componente res = null;
        for(String s: conf.getComponentes()) {
            res = this.componentes.get(s);
            if(res.getTipo().equals(tipo))
                break;
        }
        if(res != null)
            conf.remComponente(res.getID(),res.getPreco());
        return conf;
    }
    
    /**
     * Fazer login no sistema
     * @param user
     * @param pass
     * @return boolean
     * @throws LoginException
     */
    public boolean login(String user, String pass) throws LoginException {
        if(this.empregados.get(user) == null) 
            throw new LoginException("Dados Inválidos");
        return this.empregados.get(user).validaPass(pass);
    }
    
    /**
     * Retirar o nome de todos os componentes pertencentes ao nome de pacote dado
     * @param nome
     * @return res
     */
    public List<String> getNomeCompPacote(String nome) {
        int i = 1;
        List<String> res = new ArrayList<>();
        while(i <= this.pacotes.size()) {
            Pacote p = this.pacotes.get(i);
            if(p.getDescricao().equals(nome)) {
                p.getComponentes().forEach(s->{ 
                    res.add(this.componentes.get(s).getNome());
                });
                break;
            }
            i++;
        }
        return res;
    }
}