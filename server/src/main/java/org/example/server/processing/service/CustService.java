package org.example.server.processing.service;

import lombok.AllArgsConstructor;
import org.example.server.processing.AccountDTO;
import org.example.server.processing.CardDTO;
import org.example.server.processing.CustDTO;
import org.example.server.processing.entity.Account;
import org.example.server.processing.entity.Card;
import org.example.server.processing.entity.Cust;
import org.example.server.processing.repository.AccountCrudRepository;
import org.example.server.processing.repository.CardCrudRepository;
import org.example.server.processing.repository.CustCrudRepository;
import org.springframework.stereotype.Service;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Log
public class CustService {
    private CustCrudRepository custCrudRepository;
    private AccountCrudRepository accountCrudRepository;
    private CardCrudRepository cardCrudRepository;

    public CardDTO getCardDTO(String pan){
        Card card = cardCrudRepository.getCardByPan(pan);
        //Account account = accountCrudRepository.findById(card.getAccid().getId()).orElseThrow(RuntimeException::new);
        return new CardDTO( card.getId().intValue(),
                card.getAccid().getId().intValue(),
                pan,
                card.getPin()
        );
    }

    public CustDTO getCustDTO(long id) {
        Cust cust = custCrudRepository.findById(id).orElseThrow(RuntimeException::new);

        Iterable<Account> accounts = cust.getAccounts();
        List<AccountDTO> accountDTOList = new ArrayList<>();

        for (Account account : accounts) {
            Account acct = accountCrudRepository.findById(account.getId()).orElseThrow(RuntimeException::new);

            Iterable<Card> cards = acct.getCards();
            List<CardDTO> cardDTOList = new ArrayList<>();

            for (Card card : cards) {
                cardDTOList.add(new CardDTO(card.getId().intValue(), account.getId().intValue(), card.getPan(), card.getPin()));
            }
            accountDTOList.add(new AccountDTO(account.getId().intValue(), (int) id, account.getBalance(), cardDTOList));
        }

        return new CustDTO((int) id,
                cust.getName(),
                accountDTOList
        );
    }

}
