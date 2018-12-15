package ca.vastier.depense.services;

import ca.vastier.depense.web.dto.ReceiptDto;


public interface ReceiptService
{
	ReceiptDto createReceipt(ReceiptDto receipt);
	ReceiptDto findReceiptById(long id);
}
