package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory {
    public static Contact builContact(String mobile, String telephone)  {
        // ensuring numbers entered are digits only
        Long mobileNumber = Long.parseLong(mobile);
        Long telephoneNumber  = Long.parseLong(telephone);
        if(Helper.isNullOrEmpty(mobile) && mobile.length() != 10 || Helper.isNullOrEmpty(telephone) && telephone.length() != 10)
            return null;
        return new Contact.Builder().setMobile(mobile)
                .setTelephone(telephone)
                .build();
    }
}


