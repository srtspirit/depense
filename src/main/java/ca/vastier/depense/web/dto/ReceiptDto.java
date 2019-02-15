package ca.vastier.depense.web.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
public class ReceiptDto extends AbstractEntity
{
	private LocalDate date;
	@OneToMany(cascade = CascadeType.ALL, targetEntity = ExpenseDto.class)
	@JoinColumn(name = "receipt_id")
	private List<ExpenseDto> expenses;
	private BigDecimal amount;
}
