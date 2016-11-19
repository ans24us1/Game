package com.example.game;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;



import java.lang.Object;



public class Send {
	
	static int a=0;
	public String SendValue(String value) throws InterruptedException
	{
		Socket socket=null,socket1=null;	
	    String result = null;
	    DataOutputStream os = null;
	    DataInputStream is = null;
	    
	    if(socket== null)
	    {
	    	System.out.println("Socket is null so try to connect it.");
	    	try
	    	{
	    		if(value.equalsIgnoreCase("3") || value.equalsIgnoreCase("6") || value.equalsIgnoreCase("8") || value.equalsIgnoreCase("12"))
	    		{
	    	socket = new Socket("192.168.111.165", 8229);
	    	os = new DataOutputStream(socket.getOutputStream());
            os.writeUTF(value);
            /*socket.close();
            TimeUnit.MILLISECONDS.sleep(2100);
            socket1 = new Socket("192.168.111.165", 8339);
            os = new DataOutputStream(socket1.getOutputStream());
            os.writeUTF("migrate");*/
            is = new DataInputStream(socket.getInputStream()); 
             result = is.readUTF();
             //result="yes";
	    		}
	    		else
	    		{
            //socket = new Socket("192.168.111.165", 8339);
            socket = new Socket("59.163.196.167", 8229);
            os = new DataOutputStream(socket.getOutputStream());
            os.writeUTF(value);
            is = new DataInputStream(socket.getInputStream()); 
            result = is.readUTF();
            //result="no";
	    		}
	    		System.out.println(result);
	    		a++;
	    	}
	    	catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		System.out.println("not connected");
	    		e.printStackTrace();
	    	}
	    	
	    	
	    }
	    return result;
	}
	
}