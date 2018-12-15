package ca.vastier.depense.web.controllers;

import java.util.ArrayList;

import ca.vastier.depense.generated.model.Receipt;
import ca.vastier.depense.services.ReceiptService;
import ca.vastier.depense.web.dto.ExpenseDto;
import ca.vastier.depense.web.dto.ReceiptDto;
import ca.vastier.depense.web.wsdto.ReceiptWsDto;
import lombok.Setter;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController("receipt")
public class ReceiptController
{
	@Setter
	@Autowired
	private ReceiptService receiptService;
	@Setter
	@Autowired
	private ModelMapper modelMapper;

	
	@RequestMapping(method = RequestMethod.POST)
	public ReceiptWsDto createReceipt(@RequestBody final ReceiptWsDto receipt)
	{
		final ReceiptDto receiptDto = modelMapper.map(receipt, ReceiptDto.class);
		final ReceiptDto result = receiptService.createReceipt(receiptDto);

		return modelMapper.map(result, ReceiptWsDto.class);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ReceiptDto getReceiptById(@PathVariable("id") final String id)
	{
		//TODO #11
		// not a real implementation
		final ObjectContext context = ServerRuntime.builder().addConfig("cayenne-project.xml").build().newContext();
		final Receipt receipt = context.selectFirst(ObjectSelect.query(Receipt.class).where(Receipt.ID.eq(Integer.parseInt(id))));

		final ReceiptDto receiptDto = ReceiptDto.builder().id(receipt.getId()).expenses(new ArrayList<ExpenseDto>()).build();
		receiptDto.getExpenses().add(ExpenseDto.builder().purchase(receipt.getExpense().get(0).getPurchase()).build());

		return receiptDto;
	}
}
