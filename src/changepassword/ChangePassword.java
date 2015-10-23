/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changepassword;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ToNio
 */
public class ChangePassword
{

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		
		ChangePasswordModel model = new ChangePasswordModel();
		ChangePasswordView view = new ChangePasswordView();
		
		ChangePasswordController controller = new ChangePasswordController(model,view);
		
		view.setVisible(true);		
	}
	
}
