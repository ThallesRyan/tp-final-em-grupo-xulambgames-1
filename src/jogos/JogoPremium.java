package jogos;
final class JogoPremium extends Jogo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1823761206313479992L;
	//unica difere�a do pai � o desconto
	public JogoPremium(double precoOriginal, String nome){
		super(nome, precoOriginal);
		this.setCategoria('P');
	}
}
