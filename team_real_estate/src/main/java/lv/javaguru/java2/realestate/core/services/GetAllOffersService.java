package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.requests.GetAllOffersRequest;
import lv.javaguru.java2.realestate.core.response.GetAllOffersResponse;
import lv.javaguru.java2.realestate.dependency_injection.DIComponent;
import lv.javaguru.java2.realestate.dependency_injection.DIDependency;

@DIComponent
public class GetAllOffersService {
    @DIDependency
    private Database database;

    public GetAllOffersResponse execute(GetAllOffersRequest getAllOffersRequest) {
        return new GetAllOffersResponse(database.getAllOffers());
    }
}
