package ca.vastier.depense.web.controllers;

import java.util.Collection;

import ca.vastier.depense.services.GenericEntityService;
import ca.vastier.depense.services.ReceiptService;
import ca.vastier.depense.web.dto.ExpenseDto;
import ca.vastier.depense.web.dto.ReceiptDto;
import ca.vastier.depense.web.wsdto.ExpenseWsDto;
import ca.vastier.depense.web.wsdto.ReceiptWsDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("receipt")
public class ReceiptController extends AbstractController
{
	@Setter
	@Getter
	@Autowired
	private ReceiptService receiptService;


	@RequestMapping(method = RequestMethod.POST)
	public int createReceipt(@RequestBody final ReceiptWsDto receipt)
	{
		return createEntity(receipt, ReceiptDto.class).getId();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ReceiptWsDto getReceiptById(@PathVariable("id") final String id)
	{

		return getEntityById(id, ReceiptWsDto.class);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateReceipt(@RequestBody final ReceiptWsDto receiptWsDto)
	{
		updateEntity(receiptWsDto, ReceiptDto.class);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteReceiptById(@PathVariable("id") final String id)
	{
		deleteEntity(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<ReceiptWsDto> getAllReceipts()
	{
		return findAllEntities(ReceiptWsDto.class);
	}

	@Override
	protected GenericEntityService<ReceiptDto> getEntityService()
	{
		return receiptService;
	}

	@Override
	protected ModelMapper createMapper()
	{
		final ModelMapper modelMapper = new ModelMapper();

		modelMapper.addMappings(new PropertyMap<ExpenseDto, ExpenseWsDto>()
		{
			@Override
			protected void configure()
			{
				skip().setReceipt(null);
				skip().getArticle().setChildArticles(null);
				skip().getArticle().setParentArticleId(null);
			}
		});

		modelMapper.validate();
		return modelMapper;
	}
}
