/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testegetmac;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Vitor
 */
public class TESTEGETMAC {
    
    public static String userHomedir = System
            .getProperty("user.home") + File.separator + "Desktop" 
            + File.separator + "novo.txt";
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        String macAddress;
        BufferedWriter escritor;
        escritor = new BufferedWriter(new FileWriter(userHomedir));
        
        try {         
           InetAddress address = InetAddress.getLocalHost();  
           NetworkInterface ni = NetworkInterface.getByInetAddress(address);  
           byte[] mac = ni.getHardwareAddress();
           macAddress = "";
           for (int i = 0; i < mac.length; i++) {             
               macAddress += (String.format("%02X-", mac[i]));  
           }
           System.out.println(macAddress.substring(0, macAddress.length()-1));
           escritor.append(macAddress.substring(0, macAddress.length()-1));
           escritor.flush();
           escritor.close();
        } catch (UnknownHostException | SocketException e) {  
            e.printStackTrace();
        }
    }
    
}
