package Negocio.Empregados;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
 */
public class Empregado {
    private final String userName;
    private final String password;

    public Empregado(String name, String pass) {
    	this.userName = name;
	this.password = pass;
    }

    public Empregado(Empregado e) {
	this.userName = e.getUserName();
	this.password = e.getPassword();
    }

    public String getUserName() {
    	return this.userName;
    }

    public String getPassword() {
    	return this.password;
    }

    public boolean validaPass(String pass) {
	return this.password.equals(pass);
    }
    
    public Empregado clone(Empregado e) {
        return new Empregado(e);
    }
}