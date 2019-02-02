package ca.vastier.depense.web.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_seq_gen")
	@SequenceGenerator(name = "pk_seq_gen", sequenceName = "pk_sequence")
	private int id;
}
