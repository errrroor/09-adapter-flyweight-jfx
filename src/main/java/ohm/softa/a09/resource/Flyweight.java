package ohm.softa.a09.resource;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

class Flyweight {
	// intrinsic state
	private final Image image;

	Flyweight(String path) throws URISyntaxException, IOException {
		// get resource file uri
		File file = new File(getClass().getClassLoader()
			.getResource(path).toURI());

		// load image (the intrinsic state)
		this.image = new Image(new File(path).toURI().toString());
	}

	 public Image getImagee(){
		return image;
	}
}
