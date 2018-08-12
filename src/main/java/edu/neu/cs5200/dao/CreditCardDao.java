package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.CreditCard;
import edu.neu.cs5200.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CreditCardDao {

    @Autowired
    CreditCardRepository creditCardRepository;

    public CreditCard createCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public CreditCard updateCreditCard(int id, CreditCard newAdress) {
        Optional<CreditCard> optional = creditCardRepository.findById(id);
        if (optional.isPresent()) {
            CreditCard creditCard = optional.get();
            creditCard.set(newAdress);
            return creditCardRepository.save(creditCard);
        }
        return null;
    }

    public void deleteCreditCard(int id) {
        creditCardRepository.deleteById(id);
    }

    public void deleteAllCreditCards() {
        creditCardRepository.deleteAll();
    }

    public List<CreditCard> findAllCreditCards() {
        return (List<CreditCard>) creditCardRepository.findAll();
    }

    public Optional<CreditCard> findCreditCardById(int id) {
        return creditCardRepository.findById(id);
    }

    public List<CreditCard> findCreditCardsByPersonId(int personId) {
        return (List<CreditCard>) creditCardRepository.findByPersonId(personId);
    }
}
