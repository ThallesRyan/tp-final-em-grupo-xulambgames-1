package lojal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import categoriasjogos.JogoCategorizavel;
import categoriasjogos.Lancamento;
import categoriasjogos.Premium;
import categoriasjogos.Promocao;
import categoriasjogos.Regular;
import clientes.ClienteCadastrado;
import jogos.Jogo;
public class XulambGames implements Serializable {
/**
	 * 
	 */

	private static final long serialVersionUID = -7141840469374892582L;
	//atributos da classe
private TreeSet<Jogo> tabelaDeJogos;
private LinkedList<ClienteCadastrado> clientes;
private int numeroTotalVendas;
private double mediaDeVendas;
private Map<String,JogoCategorizavel> estadosDePrecos;
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
public void addJogoParaTabela(String nome, double precoOriginal, String categoria,double desconto )throws Error {
    if(this.estadosDePrecos.containsKey(categoria.toLowerCase())) {
    	JogoCategorizavel categoriaAux=this.estadosDePrecos.get(categoria.toLowerCase());
    	Jogo novoJogo=new Jogo(nome, precoOriginal, categoriaAux,desconto);
    	this.tabelaDeJogos.add(novoJogo);
    }
    else {
    	throw new Error("Categoria invalida");
    }
	
}
public void mudarCategoria(String categoria, Jogo jogoMudado)throws Exception {
	if(this.estadosDePrecos.containsKey(categoria.toLowerCase())) {
    	jogoMudado.setCategoria(this.estadosDePrecos.get(categoria.toLowerCase()));
    }
    else {
    	throw new Exception("Categoria invalida");
    }
	
}

public Jogo getJogo(String nome) throws Exception {
	Jogo jogoEncontrado = null;
	TreeSet<Jogo> jogos = this.tabelaDeJogos;
	for(Jogo jogo : jogos) {
		if(jogo.getNome().toLowerCase().equals(nome.toLowerCase().trim())) {
			jogoEncontrado = jogo;	
		}
	}
	
	if(jogoEncontrado == null) {
		throw new Exception("Jogo não encontrado");
	}else System.out.println("Jogo adicionado ao carrinho!");
	 
	return jogoEncontrado;
}
/*metodo construtor ele cria um aquivo com o codigo passado por parametro e instancia uma treeset
 * para colocar os jogos a serem adicionados
 */
public XulambGames(String codigoLoja) {
	this.estadosDePrecos=new HashMap<String,JogoCategorizavel>();
	Lancamento lancamento=new Lancamento();
	Premium premium=new Premium();
	Promocao promocao=new Promocao();
	Regular regular=new Regular();
	this.estadosDePrecos.put("lancamento", lancamento);
	this.estadosDePrecos.put("promocao",promocao);
	this.estadosDePrecos.put("premium",premium);
	this.estadosDePrecos.put("regular",regular);
	this.setTabelaDeJogos(new TreeSet<>());
	this.codigo=codigoLoja;
	this.clientes = new LinkedList<>();
	File file=new File(codigoLoja+".txt");
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
	Optional<Jogo> maiorJogo=tabelaDeJogos.stream().max((j1, j2)->extremosComparator(j1,j2));
	Optional<Jogo> menorJogo=tabelaDeJogos.stream().min((j1, j2)->extremosComparator(j1,j2));
	return("Menor jogo="+menorJogo + "\nMaior Jogo="+maiorJogo);
}
private int extremosComparator(Jogo jogoComparado1, Jogo jogoComparado2 ) {
	if (jogoComparado1.getPreco() > jogoComparado2.getPreco()) {
		return 1;
	}
	else if (jogoComparado1.getPreco() == jogoComparado2.getPreco()) {
		return 0;
	}
	else{
		return -1;
	}
	}

public LinkedList<ClienteCadastrado> getClientes() {
	return clientes;
}

public void addClientes(ClienteCadastrado cliente) {
	this.clientes.add(cliente);
}

public void setClientes(LinkedList<ClienteCadastrado> novaLista) {

	this.clientes = novaLista;
}

public String relatorioClientes() {
	StringBuilder relatorio = new StringBuilder("");
	
	relatorio.append("============== CLIENTES DA LOJA ===============\n\n");
	relatorio.append("Nome de usuário");
	relatorio.append(" =========== ");
	relatorio.append("Tipo de Cliente\n\n");
	for(ClienteCadastrado cliente : this.getClientes()) {
		relatorio.append(cliente + "\n");
	}
	relatorio.append("===============================================");
	return relatorio.toString();
}
}
