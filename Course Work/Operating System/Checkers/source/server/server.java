
import java.io.IOException;
import java.net.ServerSocket;  // Package in java that supports server socket programming
import java.net.Socket;
import java.util.ArrayList;

/**
   Author: Vamsi Gali
          
 * This is the main server class which is used to create the socket server connection 
 * To Accept the client connections.
 *
 * 



 */
public class server {

    public static LogThemAll logger;

    /**
     * Method description
     *
     *
     * @param args port number
     * Socket server connection is created by invoking a new instance of serversocket class provided by java which takes the port number as the parameter
     * @throws IOException
     */
    public static void main ( String[] args ) throws IOException {

        ServerSocket      serverSocket = new ServerSocket ( Integer.parseInt ( args[0] ) );
        ArrayList<User>   users        = new ArrayList<User> ();
        ArrayList<Socket> sockets      = new ArrayList<Socket> (); /* an array to store the client sockets*/


        logger = new LogThemAll ();

        while ( true ) {
            try {
                Socket clientSocket = serverSocket.accept ();    // Accepting the client socket requests.

                logger.logit ( clientSocket.getInetAddress ().toString ().split ( "/" )[1] + " "
                               + clientSocket.getPort () + " connected\n" );
                sockets.add ( clientSocket );

                UpdateUsers cliThread = new UpdateUsers ( clientSocket, users, sockets );

                cliThread.start ();   // Creating a thread for each client
            }
            catch ( Exception e ) {
                continue;
            }
        }
    }
}
