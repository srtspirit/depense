package ca.vastier.depense.web.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "expense")
public class ExpenseDto
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_expense_seq_gen")
	@SequenceGenerator(name = "pk_expense_seq_gen", sequenceName = "pk_expense")
	private long id;
	private LocalDate date;
	private String purchase;
	@ManyToOne()
	@JoinColumn(name = "article_id")
	private ArticleDto article;
	private BigDecimal amount;
}
