package ca.vastier.depense.services.impl;

import java.util.Optional;

import ca.vastier.depense.daos.ReceiptDao;
import ca.vastier.depense.services.ReceiptService;
import ca.vastier.depense.web.dto.ReceiptDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DefaultReceiptServiceImpl implements ReceiptService
{
	@Setter
	@Getter
	@Autowired
	private ReceiptDao receiptDao;

	@Override
	public ReceiptDto createReceipt(final ReceiptDto receipt)
	{
		return getReceiptDao().save(receipt);
	}

	@Override
	public Optional<ReceiptDto> findReceiptById(final int id)
	{
		return getReceiptDao().findById(id);
	}

	@Override
	public void updateReceipt(final ReceiptDto receiptDto)
	{
		if (!getReceiptDao().existsById(receiptDto.getId()))
		{
			throw new IllegalStateException("receipt with id " + receiptDto.getId() + " doesn't exist");
		}

		getReceiptDao().save(receiptDto);
	}

	@Override
	public void deleteReceiptById(final int id)
	{
		getReceiptDao().deleteById(id);
	}
}
