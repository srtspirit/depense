package ca.vastier.depense.web.dto;

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
public class ExpenseDto
{
	private int id;
	private LocalDate date;
	private String purchase;
	private ArticleDto article;
	private BigDecimal amount;
}
