package firstgame.client.base;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

import firstgame.shared.Constant;

public class Character {
	private Vector pos;
	private int type;
	private boolean imageLoaded = false;
	private ImageElement imageElement;

	public Character() {
		this(new Vector(0, 0));
	}
	
	public Character(Vector pos) {
		this(Constant.CHARACTER.DEFAULT, pos);
	}
	
	public Character(int type, Vector pos) {
		this.pos = pos;
		this.type = type;
		
		init();
	}

	private void init() {
		final Image image = Commons.getCharacterImage(type);
		image.addLoadHandler(new LoadHandler() {
			@Override
			public void onLoad(LoadEvent event) {
				imageLoaded = true;
				imageElement = (ImageElement) image.getElement().cast();
			}
		});
		image.setVisible(false);
		RootPanel.get().add(image);
	}
	
	public void draw(Context2d context) {
		if (imageLoaded) {
			context.save();
			context.translate(pos.x, pos.y);
			context.rotate(0);
			context.drawImage(imageElement, 0, 0);
			context.restore();
		}
	}
	
}
