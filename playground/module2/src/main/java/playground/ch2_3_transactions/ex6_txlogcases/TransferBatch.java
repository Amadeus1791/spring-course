package playground.ch2_3_transactions.ex6_txlogcases;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferBatch {

    private final TransferService transfers;
    private final TransferNote note;

    public TransferBatch(TransferService transfers, TransferNote note) {
        this.transfers = transfers;
        this.note = note;
    }

    // Case 1: two calls of transfer inside one transaction.
    @Transactional
    public void twoTransfers() {
        transfers.transfer(1, 2, 5);
        transfers.transfer(2, 1, 5);
    }

    // Case 2: transfer, then a note in its own transaction.
    @Transactional
    public void transferWithNote() {
        transfers.transfer(1, 2, 5);
        note.record("transferred 5");
    }

    // Case 3: transfer fails, the caller catches the exception.
    @Transactional
    public void catchClosed() {
        try {
            transfers.transfer(1, 3, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("caught: " + e.getMessage());
        }
    }
}
