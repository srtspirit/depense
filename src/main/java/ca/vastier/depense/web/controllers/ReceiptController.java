package ca.vastier.depense.web.controllers;

import ca.vastier.depense.exceptions.EntityNotFoundException;
import ca.vastier.depense.services.ReceiptService;
import ca.vastier.depense.web.dto.ReceiptDto;
import ca.vastier.depense.web.wsdto.ReceiptWsDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("receipt")
public class ReceiptController
{
	@Setter
	@Getter
	@Autowired
	private ReceiptService receiptService;
	@Setter
	@Getter
	@Autowired
	private ModelMapper modelMapper;


	@RequestMapping(method = RequestMethod.POST)
	public int createReceipt(@RequestBody final ReceiptWsDto receipt)
	{
		final ReceiptDto receiptDto = getModelMapper().map(receipt, ReceiptDto.class);
		final ReceiptDto result = getReceiptService().createReceipt(receiptDto);

		return result.getId();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ReceiptWsDto getReceiptById(@PathVariable("id") final String id)
	{
		final ReceiptDto receiptDto = getReceiptService().findReceiptById(Integer.valueOf(id))
				.orElseThrow(() -> new EntityNotFoundException("Receipt not found"));
		return getModelMapper().map(receiptDto, ReceiptWsDto.class);
	}
}
