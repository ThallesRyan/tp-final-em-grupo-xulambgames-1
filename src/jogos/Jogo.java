package jogos;
import java.io.Serializable;

public abstract class  Jogo implements Comparable<Jogo>,Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 2760006039823000143L;
private static double precoOriginal;
//atributos da classe
private int numeroVendas;
private double preco;
private char categoria;
private String nome;
private double desconto;

//construtor da classe.
public Jogo(String nome, double precoOriginal) {
this.setNome(nome);
	this.setPrecoOriginal(precoOriginal);
	this.setPreço();
}
//gets e sets da classe

public void setDesconto(double desconto) {
	this.desconto=desconto;
}

public void setCategoria(char categoria) {
	this.categoria=categoria;
}
public void setNome(String nome) {
	this.nome=nome;
}
public int getNumeroVendas() {
	return numeroVendas;
}

public void addVendas() {
	this.numeroVendas++;
}
public void setNumeroVendas(int numeroVendas) {
	this.numeroVendas = numeroVendas;
}
public double getPrecoOriginal() {
	return Jogo.precoOriginal;
}
public double getPreco() {
	return this.preco;
}
public char getCategoria() {
	return this.categoria;
	
}
public String getNome(){
return this.nome;
}
public void setPrecoOriginal(double precoOriginal) {
	Jogo.precoOriginal=precoOriginal;
}
/*metodo set do preço funciona diferente, ele verifica se o objeto tem desconto, se sim, ele aplica
 * o desconto
 */

public void setPreço() {
	if(this.categoria!='P') {
		this.preco=Jogo.precoOriginal*this.desconto;
	}
	else {
		this.preco=Jogo.precoOriginal;
	}
}
@Override
public String toString() {
	return this.nome;
}
//Overide no equals e no compareTo para funcionar no treeset
@Override
public boolean equals(Object jogoComparado) {
	if(this.numeroVendas==((Jogo) jogoComparado).getNumeroVendas())
		return true;
	return false;
}
@Override
public int compareTo(Jogo jogoComparado) {
	if(this.numeroVendas==jogoComparado.numeroVendas) {
		return 0;
	}
	else if(this.numeroVendas<jogoComparado.numeroVendas) {
		return -1;
	}
	return 1;
}
}


