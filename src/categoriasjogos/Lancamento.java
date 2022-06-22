package categoriasjogos;

import java.io.Serializable;

public class Lancamento implements JogoCategorizavel,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3041764040437825276L;
	@Override
	public double calcularPreco(double precoOriginal, double desconto)throws Error {
		if(desconto==1.1)
		return precoOriginal;
		throw new Error("valor de desconto inválido");
	}

	@Override
	public char getCategoria() {
		return 'L';
	}
	public int hashCode() {
		return Integer.parseInt("Lancamento");
	}
	public Lancamento() {}
}