package firstgame.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class FirstGame implements EntryPoint {
	static final String upgradeMessage = "Your browser does not support " +
			"the HTML5 Canvas. Please upgrade your browser to view this game.";
	
	static final int height = 400;
	static final int width = 400;
	
	private Canvas canvas;

	private Context2d context;

	private Image image;

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
		
		RootPanel.get().add(new HTML("Hello to my first game!"));
		RootPanel.get().add(canvas);
		
		context = canvas.getContext2d();
		context.setFillStyle(CssColor.make(230, 230, 255));
		context.fillRect(0, 0, width, height);
		
		loadImage();
	}

	private void loadImage() {
		image = new Image("images/block_brown.png");
		image.addLoadHandler(new LoadHandler() {
			
			@Override
			public void onLoad(LoadEvent event) {
				ImageElement imageElement = (ImageElement) image.getElement().cast();
				context.save();
				context.drawImage(imageElement, 10, 10);
				context.restore();
			}
		});
	}
}
