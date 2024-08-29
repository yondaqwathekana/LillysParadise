package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {
    public static Address buidAddress(String streetName, String city, String postalCode){
        if(Helper.isNullOrEmpty(streetName)
                || Helper.isNullOrEmpty(city)
                || Helper.isNullOrEmpty(postalCode))
            return  null;

        return new Address.Builder().setStreetName(streetName)
                .setCity(city)
                .setPostalCode(postalCode)
                .build();

    }

}
