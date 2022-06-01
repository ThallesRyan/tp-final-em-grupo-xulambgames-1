package jogos;
final class JogoPremium extends Jogo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1823761206313479992L;
	//unica difereça do pai é o desconto
	public JogoPremium(double precoOriginal, String nome){
		super(nome, precoOriginal);
		this.setCategoria('P');
	}
}
