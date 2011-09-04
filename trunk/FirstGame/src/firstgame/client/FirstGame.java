package firstgame.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
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

		initHandlers();
		initGame();
	}

	private void initGame() {
		floor = new Floor(Constant.FLOOR.GRASS, 16);
		character = new Character(new Vector(width/2-50, height/2-100));
		
		final Timer timer = new Timer() {
			@Override
			public void run() {
				context.setFillStyle(CssColor.make(0, 0, 0));
				context.fillRect(0, 0, width, height);
				
				floor.draw(context);
				character.draw(context);
			}
		};
		timer.scheduleRepeating(30);
	}

	private void initHandlers() {
		canvas.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.isUpArrow()) {
					move(0, 10);
					event.preventDefault();
					event.stopPropagation();
				}
				if (event.isDownArrow()) {
					move(0, -10);
					event.preventDefault();
					event.stopPropagation();
				}
				if (event.isLeftArrow()) {
					move(10, 0);
					event.preventDefault();
					event.stopPropagation();
				}
				if (event.isRightArrow()) {
					move(-10, 0);
					event.preventDefault();
					event.stopPropagation();
				}
			}
		});
		
	}
	
	private void move(int deltaX, int deltaY) {
		floor.move(deltaX, deltaY);
	}

}
