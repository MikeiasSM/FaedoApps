package br.com.faedocaminhoes.model;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, LocalDate> dataCad;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, Usuario> usuario;
	public static volatile SingularAttribute<Usuario, Integer> id;
	public static volatile SingularAttribute<Usuario, String> senha1;
	public static volatile SingularAttribute<Usuario, String> senha2;

	public static final String DATA_CAD = "dataCad";
	public static final String NOME = "nome";
	public static final String USUARIO = "usuario";
	public static final String ID = "id";
	public static final String SENHA1 = "senha1";
	public static final String SENHA2 = "senha2";

}

