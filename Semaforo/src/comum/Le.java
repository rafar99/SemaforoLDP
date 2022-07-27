/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comum;

import java.io.*;

/**
 *
 * @author rafar
 */
public class Le {
    // Inibe o construtor por defeito
	private Le() 
	{
	}
	
	// Le um inteiro da entrada padrão. 
	// A entrada é terminada com um return. Se a entrada não for 
	// válida é mostrada a mensagem "!!! Não é um inteiro !!!" e o 
	// utilizador pode tentar de novo.
	// @devolve o número lido

    /**
     *
     * @return
     */

	public static int umInt()
	{
  		while(true)
      	{
        	try
         	{  
         		return Integer.valueOf(umaString().trim()).intValue();
         	} 
      		catch(Exception e)
         	{  
         		System.out.println("!!! Não é um inteiro !!!");
         	}
         }
	}
	
	// Le um double da entrada padrão. 
	// A entrada é terminada com um return. Se a entrada não for
	// válida é mostrada a mensagem "!!! Não é um double !!!" e o 
	// utilizador pode tentar de novo.
	// @devolve o número lido

    /**
     *
     * @return
     */
    public static double umDouble()
	{
  		while(true)
      	{
        	try
         	{ 
         		return Double.valueOf(umaString().trim()).doubleValue();
         	} 
      		catch(Exception e)
         	{  
         		System.out.println("!!! Não é um double !!!");
         	}
         }
	}
	
	// Le um float da entrada padrão. 
	// A entrada é terminada com um return. Se a entrada não for 
	// válida é mostrada a mensagem "!!! Não é um float !!!" e o 
	// utilizador pode tentar de novo.
	// @devolve o número lido

    /**
     *
     * @return
     */

	public static float umFloat()
	{
  		while(true)
      	{
        	try
         	{ 
         		return Float.valueOf(umaString().trim()).floatValue();
         	} 
      		catch(Exception e)
         	{  
         		System.out.println("!!! Não é um float !!!");
         	}
         }
	}
	
	
	// Le um char da entrada padrão.
	// A entrada é terminada com um return. Se a entrada não for
	// válida é mostrada a mensagem "!!! Não é um char !!!" e o
	// utilizador pode tentar de novo.
	// @Devolve o carácter lido

    /**
     *
     * @return
     */

	public static char umChar()
	{
		String s = "";
		
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1);
			s = in.readLine();
		}
		catch (IOException e)
		{
        	System.out.println("!!! Não é um char!!!");
		}
		
		return s.charAt(0);
	}
		
	// Le uma String da entrada padrão. 
	// A entrada é terminada com um return. 
	// @devolve a String lida

    /**
     *
     * @return
     */

	public static String umaString()
	{
		String s = "";
		
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1);
			s = in.readLine();
		}
		catch (IOException e)
		{
        	System.out.println("!!! Não é uma String!!!");
		}
		
		return s;
	}
    
}