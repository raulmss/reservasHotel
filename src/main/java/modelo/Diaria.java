package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Diaria
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
public class Diaria implements Serializable {

	   
	@Id
	@GeneratedValue
	private int codigo;
	private Date data;
	private static final long serialVersionUID = 1L;
	private Collection<PessoaFisica> hospedes;
	
	public Diaria() {
		super();
	}   
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}   
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	//Todo o relacionamento many to many precisa de uma tabela de ligação, pois existiram relacionamentos entre duas tabelas
	//onde qualquer elemento de ambas as tabelas podem ter várias relações com elementos da outra tabela.
	@ManyToMany
	@JoinTable(name="hospedagem", 
			joinColumns = @JoinColumn(name="cod_diaria"),
			inverseJoinColumns = @JoinColumn(name="cod_pessoa"))
	public Collection<PessoaFisica> getHospedes() {
		return hospedes;
	}
	public void setHospedes(Collection<PessoaFisica> hospedes) {
		this.hospedes = hospedes;
	}
   
}
