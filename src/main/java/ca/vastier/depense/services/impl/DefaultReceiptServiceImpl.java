package ca.vastier.depense.services.impl;

import ca.vastier.depense.daos.ReceiptDao;
import ca.vastier.depense.services.ReceiptService;
import ca.vastier.depense.web.dto.ReceiptDto;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DefaultReceiptServiceImpl implements ReceiptService
{
	@Setter
	@Autowired
	private ReceiptDao receiptDao;

	@Override
	public ReceiptDto createReceipt(final ReceiptDto receipt)
	{
		return receiptDao.createReceipt(receipt);
	}
}
