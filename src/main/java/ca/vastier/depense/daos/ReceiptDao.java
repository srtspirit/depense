package ca.vastier.depense.daos;

import ca.vastier.depense.web.dto.ReceiptDto;


public interface ReceiptDao
{
	int createReceipt(ReceiptDto receipt);
}
