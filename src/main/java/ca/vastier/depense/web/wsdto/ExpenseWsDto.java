package ca.vastier.depense.web.wsdto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class ExpenseWsDto
{
	private int id;
	private LocalDate date;
	private String purchase;
	private ArticleWsDto article;
	private BigDecimal amount;
	private ReceiptWsDto receipt;
}
