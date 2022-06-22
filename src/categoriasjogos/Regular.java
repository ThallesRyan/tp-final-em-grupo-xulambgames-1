package categoriasjogos;

import java.io.Serializable;

public class Regular implements JogoCategorizavel,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8580726288800815316L;
	@Override
	public double calcularPreco(double precoOriginal, double desconto) throws Exception {
		if(desconto>=0.7 && desconto <=1) {
			return precoOriginal*desconto;
		}
		else {
			throw new Exception("valor de desconto inválido");
		}
	}

	@Override
	public char getCategoria() {
		// TODO Auto-generated method stub
		return 'R';
	}
	@Override
	public int hashCode() {
		return Integer.parseInt("regular");
	}
	public Regular() {}

}
