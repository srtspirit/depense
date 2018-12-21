package ca.vastier.depense.services;

import java.util.Optional;

import ca.vastier.depense.web.dto.ReceiptDto;


public interface ReceiptService
{
	ReceiptDto createReceipt(ReceiptDto receipt);

	Optional<ReceiptDto> findReceiptById(int id);
}
