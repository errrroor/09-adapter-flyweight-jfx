package ohm.softa.a09.resource;

import javafx.scene.image.Image;

public class FxImageLoaderAdapter {
	ResourceLoader<Image> resourceLoader = new ResourceLoader<>(Image::new);


	public Image loadImage(String resourcePath){
		return resourceLoader.loadResource(ClassLoader.getSystemClassLoader(), resourcePath);
	}

	public Image loadImage(ClassLoader ressourceContext, String resourcePath){
		return resourceLoader.loadResource(ressourceContext, resourcePath);
	}
}
