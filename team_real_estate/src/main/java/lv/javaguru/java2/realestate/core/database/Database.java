package lv.javaguru.java2.realestate.core.database;

import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;

import java.util.List;

public interface Database {

    void createAccount(User user);

    boolean logIn(User user);

    void createOffer(Offer offer);

    List<Offer> getAllOffers();

    boolean deleteOfferByID(int id);

    boolean deleteUser(User user);

    List<Offer> searchOffers(SearchOffersRequest request);
}
