package jogos;
final class JogoLancamento extends Jogo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4694833994496127879L;
//unica difere�a do pai � o desconto
	public JogoLancamento(String nome,double precoOriginal){
		super(nome, precoOriginal);
		this.setDesconto(0.1);
		this.setCategoria('L');
		
	}

	
}
