package ca.vastier.depense.web.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "receipt")
public class ReceiptDto
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_receipt_seq_gen")
	@SequenceGenerator(name = "pk_receipt_seq_gen", sequenceName = "pk_receipt")
	private long id;

	private LocalDate date;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "receipt_id")
	private List<ExpenseDto> expenses;
	private BigDecimal amount;
}
