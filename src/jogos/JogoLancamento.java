package jogos;
final class JogoLancamento extends Jogo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4694833994496127879L;
//unica difereça do pai é o desconto
	public JogoLancamento(String nome,double precoOriginal){
		super(nome, precoOriginal);
		this.setDesconto(0.1);
		this.setCategoria('L');
		
	}

	
}
