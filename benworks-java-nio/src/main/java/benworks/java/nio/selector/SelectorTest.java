package benworks.java.nio.selector;

import java.nio.channels.Selector;

/**
 * @author Ben
 * @date 2015年11月16日上午11:57:11
 */
public class SelectorTest {
	private static final int MAXSIZE = 5;

	public static final void main( String argc[] ) {
        Selector [] sels = new Selector[ MAXSIZE];
 
            try{
                for( int i = 0 ;i< MAXSIZE ;++i ) {
                    sels[i] = Selector.open();
                    //sels[i].close();
                }
                Thread.sleep(30000);
            }catch( Exception ex ){
                throw new RuntimeException( ex );
            }
    }
}
