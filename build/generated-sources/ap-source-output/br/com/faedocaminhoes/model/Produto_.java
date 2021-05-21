package br.com.faedocaminhoes.model;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile ListAttribute<Produto, Abastecimento> abastecimentos;
	public static volatile SingularAttribute<Produto, CategoriaProd> categoria;
	public static volatile SingularAttribute<Produto, BigDecimal> valor;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, Usuario> usuario;
	public static volatile SingularAttribute<Produto, Integer> id;

	public static final String ABASTECIMENTOS = "abastecimentos";
	public static final String CATEGORIA = "categoria";
	public static final String VALOR = "valor";
	public static final String NOME = "nome";
	public static final String USUARIO = "usuario";
	public static final String ID = "id";

}

