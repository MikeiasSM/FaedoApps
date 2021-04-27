package br.com.faedocaminhoes.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Abastecimento.class)
public abstract class Abastecimento_ {

	public static volatile SingularAttribute<Abastecimento, Veiculo> veiculo;
	public static volatile SingularAttribute<Abastecimento, Integer> n_requisicao;
	public static volatile SingularAttribute<Abastecimento, BigDecimal> vlr_total;
	public static volatile SingularAttribute<Abastecimento, Pessoa> pessoa;
	public static volatile SingularAttribute<Abastecimento, Produto> produto;
	public static volatile SingularAttribute<Abastecimento, BigDecimal> vlr_unitario;
	public static volatile SingularAttribute<Abastecimento, Integer> n_cupom;
	public static volatile SingularAttribute<Abastecimento, Integer> id;
	public static volatile SingularAttribute<Abastecimento, Fornecedor> fornecedor;
	public static volatile SingularAttribute<Abastecimento, BigDecimal> quantidade;
	public static volatile SingularAttribute<Abastecimento, String> responsavel;
	public static volatile SingularAttribute<Abastecimento, LocalDate> data_abastecimento;

	public static final String VEICULO = "veiculo";
	public static final String N_REQUISICAO = "n_requisicao";
	public static final String VLR_TOTAL = "vlr_total";
	public static final String PESSOA = "pessoa";
	public static final String PRODUTO = "produto";
	public static final String VLR_UNITARIO = "vlr_unitario";
	public static final String N_CUPOM = "n_cupom";
	public static final String ID = "id";
	public static final String FORNECEDOR = "fornecedor";
	public static final String QUANTIDADE = "quantidade";
	public static final String RESPONSAVEL = "responsavel";
	public static final String DATA_ABASTECIMENTO = "data_abastecimento";

}

