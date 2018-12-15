package ca.vastier.depense.web.dto;

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
public class ReceiptDto
{
	private int id;

	private LocalDate date;
	private List<ExpenseDto> expenses;
}
