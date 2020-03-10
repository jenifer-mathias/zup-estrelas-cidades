package br.com.zup.estrelas.cidades.pojo;

public class Cidade {
	private int cep;
	private String nome;
	private int nro_habitantes;
	private boolean capital;
	private String estado;
	private Double renda_per_capta;
	private String data_fundacao;
	
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNro_habitantes() {
		return nro_habitantes;
	}
	public void setNro_habitantes(int nro_habitantes) {
		this.nro_habitantes = nro_habitantes;
	}
	public boolean isCapital() {
		return capital;
	}
	public void setCapital(boolean capital) {
		this.capital = capital;
	}
	public String Estado() {
		return estado;
	}
	public void setEstado(String string) {
		this.estado = string;
	}
	public Double getRenda_per_capta() {
		return renda_per_capta;
	}
	public void setRenda_per_capta(Double renda_per_capta) {
		this.renda_per_capta = renda_per_capta;
	}
	public String getData_fundacao() {
		return data_fundacao;
	}
	public void setData_fundacao(String data_fundacao) {
		this.data_fundacao = data_fundacao;
	}
	
	
}
	
	