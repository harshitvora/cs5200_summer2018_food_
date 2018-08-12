package edu.neu.cs5200.web.service;

import edu.neu.cs5200.dao.CreditCardDao;
import edu.neu.cs5200.entity.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CreditCardService {

    @Autowired
    CreditCardDao creditCardDao;

    @GetMapping("/api/creditCard")
    public List<CreditCard> findAllCreditCards() {
        return creditCardDao.findAllCreditCards();
    }

    @GetMapping("/api/creditCard/{creditCardId}")
    public Optional<CreditCard> findCreditCardById(@PathVariable("creditCardId") int id) {
        return creditCardDao.findCreditCardById(id);
    }

    @GetMapping("/api/creditCard/person/{personId}")
    public List<CreditCard> findCreditCardsByPersonId(@PathVariable("personId") int personId) {
        return creditCardDao.findCreditCardsByPersonId(personId);
    }

    @PostMapping("/api/creditCard")
    public CreditCard createCreditCard(@RequestBody CreditCard creditCard) {
        return creditCardDao.createCreditCard(creditCard);
    }

    @DeleteMapping("/api/creditCard/{creditCardId}")
    public void deleteCreditCard(@PathVariable("creditCardId") int id) {
        creditCardDao.deleteCreditCard(id);
    }

    @PutMapping("/api/creditCard/{creditCardId}")
    public CreditCard updateCreditCard(@PathVariable("creditCardId") int id, @RequestBody CreditCard newCreditCard) {
        return creditCardDao.updateCreditCard(id, newCreditCard);
    }
}
