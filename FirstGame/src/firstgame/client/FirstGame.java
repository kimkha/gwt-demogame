package firstgame.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import firstgame.client.base.Character;
import firstgame.client.base.Floor;
import firstgame.client.base.Vector;
import firstgame.shared.Constant;

public class FirstGame implements EntryPoint {
	static final String upgradeMessage = "Your browser does not support " +
			"the HTML5 Canvas. Please upgrade your browser to view this game.";
	
	static final int height = 430;
	static final int width = 450;
	
	private Canvas canvas;

	private Context2d context;

	private Floor floor;

	private Character character;

	public void onModuleLoad() {
		canvas = Canvas.createIfSupported();
		if (canvas == null) {
			RootPanel.get().add(new Label(upgradeMessage));
			return;
		}
		
		canvas.setWidth(width + "px");
		canvas.setHeight(height + "px");
		canvas.setCoordinateSpaceWidth(width);
		canvas.setCoordinateSpaceHeight(height);
		
		RootPanel.get().add(new HTML("Hello to my first game!<br /><br />"));
		RootPanel.get().add(canvas);
		
		context = canvas.getContext2d();
		context.setFillStyle(CssColor.make(0, 0, 0));
		context.fillRect(0, 0, width, height);
		
		initGame();
	}

	private void initGame() {
		floor = new Floor(Constant.FLOOR.GRASS, 8);
		character = new Character(new Vector(20, 10));
		
		Timer timer = new Timer() {
			@Override
			public void run() {
				floor.draw(context);
				character.draw(context);
			}
		};
		timer.scheduleRepeating(40);
	}
}
