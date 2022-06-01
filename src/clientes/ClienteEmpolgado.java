package clientes;
import java.time.LocalDate;

import jogos.Jogo;
import lojal.XulambGames;

final class ClienteEmpolgado extends ClienteCadastrado {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3352652735268326172L;
	private static double mensalidade=10;
	//construtor da classe
	public ClienteEmpolgado(String nome, String nomeUsuario, String senha, XulambGames referencia) {
		super(nome, nomeUsuario, senha, referencia);
		this.setTipoCLiente('E');
	}
	//unica diferença de atrubto do pai, que é a mensalidade
	public double getMensalidade() {
		return ClienteEmpolgado.mensalidade;
		
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
			return precoTotal *0.9;
		}
		else {
			throw new Exception("carrinho não foi criado ainda");
		}
	}
}
