package jogos;
public class JogoPromocao extends Jogo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6251114839945839025L;
	//unica difereça do pai é o desconto, o metodo verifica se a faixa do desconto aplicado está correto
	public JogoPromocao(String nome,double precoOriginal,double desconto)throws Exception {
		super(nome, precoOriginal);
		if(desconto>=0.3 && desconto <=0.5) {
			this.setDesconto(desconto);
		}
		else {
			throw new Exception("valor de desconto inválido");
		}
		this.setCategoria('p');

	}
}
