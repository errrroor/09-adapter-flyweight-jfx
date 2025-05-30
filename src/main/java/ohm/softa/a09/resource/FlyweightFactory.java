package ohm.softa.a09.resource;


import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FlyweightFactory {
	private Map<String, Image> flyweights = new HashMap<>();
	private final FxImageLoaderAdapter imageResourceLoader;

	public FlyweightFactory(){
		imageResourceLoader = new FxImageLoaderAdapter();
	}
	public Image getFlyweight(String path) throws URISyntaxException, IOException {
		if (flyweights.containsKey(path))
			return flyweights.get(path);

		// allocate new flyweight

		flyweights.put(path, imageResourceLoader.loadImage(path));
		return flyweights.get(path);
	}
}
