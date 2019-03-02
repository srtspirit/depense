import { ReceiptService } from '../rest/receipt.service';
import { Receipt } from '../models';
import { Injectable } from '@angular/core';

@Injectable()
export class ReceiptFacade {
  constructor(private receiptService: ReceiptService) {}

  createReceipt(receipt: Receipt) {
    return this.receiptService.createReceipt(receipt);
  }
}
