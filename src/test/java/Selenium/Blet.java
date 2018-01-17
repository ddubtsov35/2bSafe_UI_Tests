package Selenium;

import com.dubtsov.safe.ApiMethods.AuthorisationUser.AuthorisationUser;
import com.dubtsov.safe.ApiMethods.DeleteAccount.DeleteAccountClass;
import com.dubtsov.safe.GenerateTestData.GenerateEmail;
import org.junit.Test;

/**
 * Created by user on 17.01.18.
 */
public class Blet {

    @Test
    public void qwe() throws Exception {
        AuthorisationUser authorisationUser = new AuthorisationUser();
        authorisationUser.authorisationUser(GenerateEmail.emailStatic);

        DeleteAccountClass deleteAccountClass = new DeleteAccountClass();
        deleteAccountClass.deleteUser();
    }
}
