package ca.vastier.depense.web.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class AbstractEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_seq_gen")
	@SequenceGenerator(name = "pk_seq_gen", sequenceName = "pk_sequence", allocationSize = 5)
	private int id;
}
