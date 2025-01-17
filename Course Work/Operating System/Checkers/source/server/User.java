

import java.net.Socket;

/**

  Author: Vamsi Gali
          
 * Class description
 *
 *This is the class which is used to store the ip address, port and the name of the every client connected to the server
 * 
 */
public class User {

    private String ip;
    private String name;
    private int    port;
    private int    selfServerPort;

    /**
     * Constructs ...
     *
     *
     * @param name
     * @param client
     * @param selfServerPort
     */
    public User ( String name, Socket client, int selfServerPort ) {

        this.name = name;

        String[] str = client.getInetAddress ().toString ().split ( "/" );

        this.ip             = str[1];
        this.port           = client.getPort ();
        this.selfServerPort = selfServerPort;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getName () {
        return name;
    }

    /**
     * Method description
     *
     *
     * @param name
     */
    public void setName ( String name ) {
        this.name = name;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getPort () {
        return port;
    }

    /**
     * Method description
     *
     *
     * @param port
     */
    public void setPort ( int port ) {
        this.port = port;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getIp () {
        return ip;
    }

    /**
     * Method description
     *
     *
     * @param ip
     */
    public void setIp ( String ip ) {
        this.ip = ip;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public String toString () {
        return name;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getSelfServerPort () {
        return selfServerPort;
    }

    /**
     * Method description
     *
     *
     * @param selfServerPort
     */
    public void setSelfServerPort ( int selfServerPort ) {
        this.selfServerPort = selfServerPort;
    }
}
