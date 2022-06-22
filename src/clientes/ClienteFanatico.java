package clientes;
import java.time.LocalDate;

import jogos.Jogo;
import lojal.XulambGames;

public final class ClienteFanatico extends ClienteCadastrado {
/**
	 * 
	 */
	private static final long serialVersionUID = -5405906526910462335L;
private static double mensalidade=25;
//construtor da classe
	public ClienteFanatico(String nome, String nomeUsuario, String senha, XulambGames referencia) {
		super(nome, nomeUsuario, senha, referencia);
		this.setTipoCLiente('F');
	}	
	//unica diferença de atrubto do pai, que é a mensalidade
public double getMensalidade() {
	return ClienteFanatico.mensalidade;
}
//overide no finalizar a compra com a diferença do desconto
public double finalizarCompra()throws Exception {
	if(this.getCarrinhoAtual()!=null) {
		 for(Jogo item : this.getCarrinhoAtual().getJogos()){
			 item.addVendas();
			 this.getReferencia().addNumeroTotalVendas(item.getNumeroVendas());
		 }
		double precoTotal=this.getCarrinhoAtual().getPrecoTotal();
		LocalDate dataAtual = LocalDate.now();
		this.getCarrinhoAtual().setDataDeCompra(dataAtual);
		this.getHistoricoDeCompras().add(this.getCarrinhoAtual());
		limparCarrinhoAtual();
		return precoTotal *0.7;
	}
	else {
		throw new Exception("carrinho não foi criado ainda");
	}
}

@Override
public String toString() {
	StringBuilder espacos = new StringBuilder("");
	while(this.getNomeUsuario().length() + espacos.length() + 8 != 37) {
		espacos.append(" ");
	}
	return (this.getNomeUsuario() + espacos + "Fanático\n");
}
}
