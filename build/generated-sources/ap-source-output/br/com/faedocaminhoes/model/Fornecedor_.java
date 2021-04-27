package br.com.faedocaminhoes.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Fornecedor.class)
public abstract class Fornecedor_ {

	public static volatile SingularAttribute<Fornecedor, String> fantasia;
	public static volatile SingularAttribute<Fornecedor, String> telefone;
	public static volatile ListAttribute<Fornecedor, Abastecimento> abastecimentos;
	public static volatile SingularAttribute<Fornecedor, Integer> id;
	public static volatile SingularAttribute<Fornecedor, String> razao;
	public static volatile SingularAttribute<Fornecedor, String> cpf_cnpj;
	public static volatile SingularAttribute<Fornecedor, String> email;

	public static final String FANTASIA = "fantasia";
	public static final String TELEFONE = "telefone";
	public static final String ABASTECIMENTOS = "abastecimentos";
	public static final String ID = "id";
	public static final String RAZAO = "razao";
	public static final String CPF_CNPJ = "cpf_cnpj";
	public static final String EMAIL = "email";

}

