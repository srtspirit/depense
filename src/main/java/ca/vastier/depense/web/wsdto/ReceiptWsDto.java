package ca.vastier.depense.web.wsdto;

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
public class ReceiptWsDto
{
	private int id;

	private LocalDate date;
	private List<ExpenseWsDto> expenses;
	private BigDecimal amount;
}
