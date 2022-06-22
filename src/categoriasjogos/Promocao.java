package categoriasjogos;

import java.io.Serializable;

public class Promocao implements JogoCategorizavel,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5741575360858303865L;
	@Override
	public double calcularPreco(double precoOriginal, double desconto)throws Error {
		if(desconto>=0.5 && desconto <=0.7) {
			return precoOriginal*desconto;
		}
		else {
			throw new Error("valor de desconto inválido");
		}
	}

	@Override
	public char getCategoria() {

		return 'p';
	}
	@Override
	public int hashCode() {
		return Integer.parseInt("lancamento");
	}
public Promocao() {}
}
