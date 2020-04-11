package br.com.alura.jpa.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String banco;
	private Integer agencia;
	private Integer numero;
	private String titular;
	private BigDecimal saldo;
	
	public Conta() {
	}
	
	public Conta(String banco, Integer agencia, Integer numero, String titular, BigDecimal saldo) {
		this.banco = banco;
		this.agencia = agencia;
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAgencia() {
		return agencia;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", banco=" + banco + ", agencia=" + agencia + ", numero=" + numero + ", titular="
				+ titular + ", saldo=" + saldo + "]";
	}
	
}
