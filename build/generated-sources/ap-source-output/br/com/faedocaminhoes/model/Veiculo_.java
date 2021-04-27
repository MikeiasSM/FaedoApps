package br.com.faedocaminhoes.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Veiculo.class)
public abstract class Veiculo_ {

	public static volatile ListAttribute<Veiculo, Pessoa> persons;
	public static volatile SingularAttribute<Veiculo, Fabricante> provider;
	public static volatile ListAttribute<Veiculo, Abastecimento> abastecimentos;
	public static volatile SingularAttribute<Veiculo, String> cor;
	public static volatile SingularAttribute<Veiculo, Integer> id;
	public static volatile SingularAttribute<Veiculo, String> modelo;
	public static volatile SingularAttribute<Veiculo, String> placa;

	public static final String PERSONS = "persons";
	public static final String PROVIDER = "provider";
	public static final String ABASTECIMENTOS = "abastecimentos";
	public static final String COR = "cor";
	public static final String ID = "id";
	public static final String MODELO = "modelo";
	public static final String PLACA = "placa";

}

