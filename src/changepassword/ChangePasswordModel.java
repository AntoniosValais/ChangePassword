/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changepassword;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author ToNio
 */
public class ChangePasswordModel
{
	private List<String> loginData;
	private int indexOfValidUserFound;
	
	public ChangePasswordModel()
	{
		loginData = new ArrayList<String>();
		indexOfValidUserFound=-1;
		
	}
	
	private void readLoginDataFromFile()
	{
		loginData.clear();
		try
		{
			Scanner loginDataFile = new Scanner(new File("loginData.lod"));
			
			while(loginDataFile.hasNext())
			{
				loginData.add(loginDataFile.nextLine());
			}
			
			loginDataFile.close();
		}
		catch(FileNotFoundException e)
		{
			
		}
	}
	
	private void writeLoginDataToFile()
	{
		try
		{
			PrintWriter loginDataFile = new PrintWriter(new FileOutputStream("loginData.lod"));
			
			for(String data : loginData)
			{
				loginDataFile.println(data);
			}
			
			loginDataFile.close();
		}
		catch(IOException e)
		{

		}
	}
	
	public boolean userIsValid(String username, char[] password)
	{
		readLoginDataFromFile();
		
		//1os komvos exei to username kai 2os komvos to password etc. :(
		
		for(int indexOnLoginData=0;indexOnLoginData<loginData.size();indexOnLoginData+=2)
		{
			if(loginData.get(indexOnLoginData).equals(username) &&
					Arrays.equals(loginData.get(indexOnLoginData+1).toCharArray(),password))
			{
				indexOfValidUserFound=indexOnLoginData;
				return true;
			}
		}		
		return false;
	}
	
	public boolean checkNewPasswordsMatch(char[] newPassword,char[] retypeNewPassword)
	{
		if(Arrays.equals(newPassword, retypeNewPassword))
		{
			return true;
		}
		
		return false;
	}
	
	public void changeUserPassword(char[] newPassword)
	{
		loginData.set(indexOfValidUserFound+1, String.valueOf(newPassword));
		writeLoginDataToFile();
	}
	

	
}
