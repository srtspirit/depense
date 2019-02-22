package ca.vastier.depense.services.impl;

import ca.vastier.depense.services.ReceiptService;
import ca.vastier.depense.web.dto.ReceiptDto;
import org.springframework.stereotype.Component;


@Component
public class DefaultReceiptServiceImpl extends AbstractGenericEntityService<ReceiptDto> implements ReceiptService
{
}
