package ca.vastier.depense.services;

import ca.vastier.depense.web.dto.ReceiptDto;


public interface ReceiptService
{
	int createReceipt(ReceiptDto receipt);
}
