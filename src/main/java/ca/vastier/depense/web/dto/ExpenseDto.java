package ca.vastier.depense.web.dto;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class ExpenseDto extends AbstractEntity
{
	private LocalDate date;
	private String purchase;
	@ManyToOne()
	@JoinColumn(name = "article_id")
	private ArticleDto article;
	private BigDecimal amount;
}
