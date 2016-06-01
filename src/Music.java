
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music extends Thread {
	public Player clip;
        
	@Override
	public void run() {
		go();
		}
	public void go(){
            
		URL url = Menu.class.getResource("music2.mp3");
		try (InputStream audioIn = url.openStream()) {
			clip = new Player(audioIn);
			clip.play();
			
			run();
		} catch (IOException | JavaLayerException  e1) {
			e1.printStackTrace();
		}
	}
	
}