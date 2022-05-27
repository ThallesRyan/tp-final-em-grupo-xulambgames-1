package clientes;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

import carrinho.Carrinho;
import jogos.Jogo;
import lojal.XulambGames;

public class ClienteCadastrado implements Serializable {
/**
	 * 
	 */
	
	//Atributos da classe;
	private static final long serialVersionUID = -7805228302506628227L;
private String nome;
private String nomeUsuario;
private String senha;
private char tipoCliente;
private LinkedList<Carrinho> historicoDeCompras;
private Carrinho carrinhoAtual;
private XulambGames referencia;
	
//construtor da classe.
	public ClienteCadastrado(String nome, String nomeUsuario, String senha, XulambGames referencia) {
		this.nome=nome;
		this.nomeUsuario=nomeUsuario;
		this.senha=senha;
		this.tipoCliente='C';
		this.historicoDeCompras=new LinkedList<Carrinho>();	
		this.setReferencia(referencia);
	}
	
	//Metodos gets/sets
public XulambGames getReferencia() {
		return referencia;
}

public void setReferencia(XulambGames referencia) {
		this.referencia = referencia;
}
public void setNome(String nome) {
	this.nome=nome;
}
public void setNomeUsuario(String nomeUsuario) {
	this.nomeUsuario=nomeUsuario;
}
public void setSenha(String senha) {
	this.senha=senha;
}
public void setTipoCLiente(char tipoCliente) {
	this.tipoCliente=tipoCliente;
}
public void limparCarrinhoAtual() {
	this.carrinhoAtual=null;
}
public String getNome() {
	return this.nome;
}
public String getNomeUsuario() {
	return this.nomeUsuario;
}
public String getSenha() {
	return this.senha;
}
public char getTipoCliente() {
	return this.tipoCliente;
}
public LinkedList<Carrinho> getHistoricoDeCompras(){
	return this.historicoDeCompras;
}
public Carrinho getCarrinhoAtual() {
	return this.carrinhoAtual;
}
/*Metodo para iniciar a compra. Ele verifica se j� existe alguma compra inicializada, se n�o,
 ele inicializa um carrinho e o coloca como compra atual
*/

public void iniciarCompra()throws Exception {
	if(this.carrinhoAtual==null) {
		this.carrinhoAtual=new Carrinho();
	}
	else {
		throw new Exception("Carrinho j� existente");
	}
}
/*Metodo que adiciona um jogo para o carrinho, ele verifica se existe alguma compra inicializada
 * se sim, ele adiciona um jogo para o carrinho da tal
 */
public void addJogo(Jogo novoJogo)throws Exception {
	if(this.carrinhoAtual != null) {
		this.carrinhoAtual.addJogo(novoJogo);
	}
	else {
		throw new Exception("Compra n�o inicializada");
	}
}
/* Metodo que finaliza a compra.Ele primeiro verifica se existe alguma compra pendente, se sim
 * ele adiciona o contador de vendas de seus respectivos jogos, atualiza o contador de vendas da 
 * loja, calcula o pre�o total, salva o carrinho no historico com a data de finaliza��o e retorna
 * o pre�o total
 */
public double finalizarCompra()throws Exception {
	if(this.carrinhoAtual!=null) {
		 for(Jogo item : this.carrinhoAtual.getJogos()){
			 item.addVendas();
			 this.getReferencia().addNumeroTotalVendas(item.getNumeroVendas());
		 }
		double precoTotal=this.carrinhoAtual.getPrecoTotal();
		LocalDate dataAtual = LocalDate.now();
		this.carrinhoAtual.setDataDeCompra(dataAtual);
		this.historicoDeCompras.add(this.carrinhoAtual);
		limparCarrinhoAtual();
		return precoTotal;
	}
	else {
		throw new Exception("carrinho n�o foi criado ainda");
	}
}
@Override
public String toString() {
	return ("nome do cliente: "+this.nome+"  Nome de Usuario: "+this.nomeUsuario);
}

}
