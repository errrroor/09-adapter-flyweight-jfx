package ohm.softa.a09.model;

import ohm.softa.a09.model.empire.TieBomber;
import ohm.softa.a09.model.empire.TieFighter;
import ohm.softa.a09.model.empire.TieInterceptor;
import ohm.softa.a09.model.rebellion.AWing;
import ohm.softa.a09.model.rebellion.XWing;
import ohm.softa.a09.model.rebellion.YWing;
import ohm.softa.a09.resource.FlyweightFactory;
import ohm.softa.a09.resource.ResourceLoader;
import ohm.softa.a09.util.NameGenerator;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

/**
 * Factory to create new fighters
 * Creates random fighters
 *
 * @author Peter Kurfer
 */
public final class FighterFactory {

	private static final int NumberOfKnownFighterTypes = 6;
	private final Random random;
	private final NameGenerator nameGenerator;
//	private final ResourceLoader<Image> imageResourceLoader;
	private final FlyweightFactory fyf;

	public FighterFactory() {
		nameGenerator = new NameGenerator();
		random = new Random();
//		imageResourceLoader = new ResourceLoader<>(Image::new);
		fyf = new FlyweightFactory();
	}

	/**
	 * Create a random Fighter
	 *
	 * @implNote the method has an implementation flaw because it always loads the fighters image
	 * @return a new Fighter instance
	 */
	public Fighter createFighter() throws URISyntaxException, IOException {
		switch (random.nextInt(NumberOfKnownFighterTypes)) {
			case 0:
				return new AWing(nameGenerator.generateName(), fyf.getFlyweight("fighter/awing.jpg"));
			case 1:
				return new XWing(nameGenerator.generateName(), fyf.getFlyweight("fighter/xwing.jpg"));
			case 2:
				return new YWing(nameGenerator.generateName(), fyf.getFlyweight( "fighter/ywing.jpg"));
			case 3:
				return new TieBomber(nameGenerator.generateName(),fyf.getFlyweight("fighter/tiebomber.jpg"));
			case 4:
				return new TieFighter(nameGenerator.generateName(), fyf.getFlyweight( "fighter/tiefighter.jpg"));
			default:
				return new TieInterceptor(nameGenerator.generateName(), fyf.getFlyweight(  "fighter/tieinterceptor.jpg"));
		}
	}
}
