/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.*;
import java.net.*;

/**
 *
 * @author Carmen_Lucia3
 */
public class TPCServer {
    
    public static void main(String[] args) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        
        ServerSocket welcomeSocket = new ServerSocket(6789);
        
        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            
            BufferedReader inFromClient = new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));
            
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            
            clientSentence = inFromClient.readLine();
            
            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            
            outToClient.writeBytes(capitalizedSentence);
        }   
        
    }
    
}
