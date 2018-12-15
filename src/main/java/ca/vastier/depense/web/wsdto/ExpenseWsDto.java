package ca.vastier.depense.web.wsdto;

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
public class ExpenseWsDto
{
	private long id;
	private LocalDate date;
	private String purchase;
	private ArticleWsDto article;
	private BigDecimal amount;
}
