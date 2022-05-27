package lojal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import jogos.Jogo;
public class XulambGames implements Serializable {
/**
	 * 
	 */

	private static final long serialVersionUID = -7141840469374892582L;
	//atributos da classe
private TreeSet<Jogo> tabelaDeJogos;
private int numeroTotalVendas;
private double mediaDeVendas;
private String codigo;

//metodos get e sets
public double getMediaDeVendas() {
	return mediaDeVendas;
}

public int getNumeroTotalVendas() {
	return numeroTotalVendas;
}

public void addNumeroTotalVendas(int numeroTotalVendas) {
	this.numeroTotalVendas = this.numeroTotalVendas+numeroTotalVendas;
}
public Set<Jogo> getTabelaDeJogos() {
	return tabelaDeJogos;
}
public void setTabelaDeJogos(TreeSet<Jogo> tabelaDeJogos) {
	this.tabelaDeJogos = tabelaDeJogos;
}

public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public void setMediaDeVendas() {
	double total=0;
	for(Jogo item : this.tabelaDeJogos){
	   total=total+item.getPreco();
	}
	 this.mediaDeVendas=total/this.numeroTotalVendas;
}
//metodo para adicionar jogo para tabela de jogos
public void addJogoParaTabela(Jogo novoJogo) {
	this.tabelaDeJogos.add(novoJogo);
}

/*metodo construtor ele cria um aquivo com o codigo passado por parametro e instancia uma treeset
 * para colocar os jogos a serem adicionados
 */
public XulambGames(String codigoLoja) {
	this.setTabelaDeJogos(new TreeSet<>());
	this.codigo=codigoLoja;
	File file=new File("codigoLoja.txt");
	try {
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(this);
		oos.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
//metodo para fechar a loja, ele salva todos os dados no arquivo previamente criado
public void fecharLoja(String codigo) {
	String txt=codigo+".txt";
	try {
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(txt));
		oos.writeObject(this);
		oos.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//metodo que imprime os jogos mais e menos vendidos
public String getExtremos() {
	return ("Jogo mais vendido= "+this.tabelaDeJogos.last()+" Jogo menos vendido= "+this.tabelaDeJogos.first());
}
}