package br.com.faedocaminhoes.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ {

	public static volatile SingularAttribute<Pessoa, String> telefone;
	public static volatile SingularAttribute<Pessoa, Integer> tipo_pessoa;
	public static volatile ListAttribute<Pessoa, Abastecimento> abastecimentos;
	public static volatile ListAttribute<Pessoa, Veiculo> vehicles;
	public static volatile SingularAttribute<Pessoa, String> nome;
	public static volatile SingularAttribute<Pessoa, Integer> id;
	public static volatile SingularAttribute<Pessoa, String> cpf_cnpj;
	public static volatile SingularAttribute<Pessoa, String> email;

	public static final String TELEFONE = "telefone";
	public static final String TIPO_PESSOA = "tipo_pessoa";
	public static final String ABASTECIMENTOS = "abastecimentos";
	public static final String VEHICLES = "vehicles";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String CPF_CNPJ = "cpf_cnpj";
	public static final String EMAIL = "email";

}

