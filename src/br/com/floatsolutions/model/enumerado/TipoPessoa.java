/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model.enumerado;

/**
 *
 * @author Mikeias
 */
public enum TipoPessoa {

	FISICA(1, "FISICA"),
	JURIDICA(2, "JURIDICA");

	private int cod;
	private String descricao;
	
	private TipoPessoa(int cod, String descricao){
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPessoa toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (TipoPessoa x: TipoPessoa.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+cod);
		
	}
	
}

