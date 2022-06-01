package jogos;
final class JogoRegular extends Jogo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2222302155863878735L;
	//unica difereça do pai é o desconto, o metodo verifica se a faixa do desconto aplicado está correto
	public JogoRegular(String nome,double precoOriginal,double desconto)throws Exception {
		super(nome, precoOriginal);
		if(desconto>=0.7 && desconto <=1) {
			this.setDesconto(desconto);
		}
		else {
			throw new Exception("valor de desconto inválido");
		}
		this.setCategoria('R');
	}

}
