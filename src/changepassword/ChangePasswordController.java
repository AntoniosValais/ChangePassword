/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changepassword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author ToNio
 */
public class ChangePasswordController
{
    private ChangePasswordModel model;
    private ChangePasswordView view;

    public ChangePasswordController(ChangePasswordModel model, ChangePasswordView view)
    {
        this.model = model;
        this.view = view;

        this.view.addOkButtonListener(new OkButtonListener());
        this.view.addCancelButtonListener(new CancelButtonListener());
    }

    class OkButtonListener implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            String username = view.getUsernameField();
            char[] password = view.getPasswordField();
            char[] newPassword = view.getNewPasswordField();
            char[] retypeNewPassword = view.getRetypeNewPasswordFiled();

            if (model.userIsValid(username, password) && model.checkNewPasswordsMatch(newPassword, retypeNewPassword))
            {
                model.changeUserPassword(newPassword);
                view.showMessage("Password has changed!");
                view.clearFields();
            } else
            {
                view.showMessage("Wrong input!");
                view.clearFields();
            }
        }
    }

    class CancelButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit( 0 );
        }
    }

}
