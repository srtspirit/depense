package ca.vastier.depense.web.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static java.util.stream.Collectors.toList;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "receipt")
public class ReceiptDto extends AbstractEntity
{
	private LocalDate date;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "receipt_id")
	private List<ExpenseDto> expenses;
	private BigDecimal amount;

	@Builder
	public ReceiptDto(final int id, final Collection<ExpenseDto> expenses, final BigDecimal amount)
	{
		super(id);
		this.amount = amount;
		if (expenses != null)
		{
			this.expenses = expenses.stream().collect(toList());
		}
	}
}
