package br.unisul.javabean;

import javax.persistence.*;


@Entity
@Table(name="ALUNOS")
public class Aluno {
	@Id
	@Column(name="MATRICULA_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long matricula;
	
	@Column(name="NOME")
	private String nome;

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
