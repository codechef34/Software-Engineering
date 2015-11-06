

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class description
 *
    Author: Vamsi Gali
          


 *This class is used to log all the users who are connected
 * 
 */
public class LogThemAll {

    private File           log;
    private BufferedWriter out;
    private FileWriter     writer;

    /**
     * Method description
     *
     *
     * @throws IOException
     */
    private void setLog () throws IOException {

        log = new File ( "server.log" );

        if ( !log.exists () ) {
            log.createNewFile ();
        }
    }

    /**
     * Method description
     *
     *
     * @throws IOException
     */
    private void setWriter () throws IOException {
        writer = new FileWriter ( log.getName (), true );
    }

    /**
     * Method description
     *
     */
    private void setOut () {
        out = new BufferedWriter ( writer );
    }

    /**
     * Method description
     *
     *
     * @param str
     *
     * @throws IOException
     */
    public void logit ( String str ) throws IOException {

        setLog ();
        setWriter ();
        setOut ();
        out.write ( str );
        out.close ();
    }
}
