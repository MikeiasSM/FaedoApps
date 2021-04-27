package br.com.faedocaminhoes.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CategoriaProd.class)
public abstract class CategoriaProd_ {

	public static volatile SingularAttribute<CategoriaProd, String> sigla;
	public static volatile ListAttribute<CategoriaProd, Produto> produtos;
	public static volatile SingularAttribute<CategoriaProd, String> nome;
	public static volatile SingularAttribute<CategoriaProd, Integer> id;

	public static final String SIGLA = "sigla";
	public static final String PRODUTOS = "produtos";
	public static final String NOME = "nome";
	public static final String ID = "id";

}

