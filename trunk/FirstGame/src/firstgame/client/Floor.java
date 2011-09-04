package firstgame.client;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

public class Floor {
	private int type = Constant.FLOOR.DEFAULT;
	private int size;
	private Image image;
	private FloorCell[][] group;
	private boolean imageLoaded = false;

	public Floor(int type, int size) {
		this.type = type;
		this.size = size;
		this.group = new FloorCell[size][size];
		
		init();
	}

	private void init() {
		String img = "";
		switch (type) {
		case Constant.FLOOR.BROWN:
			img = "block_brown.png";
			break;
		default:
			img = "block_brown.png";
		}

		image = new Image("images/" + img);
		image.addLoadHandler(new LoadHandler() {
			@Override
			public void onLoad(LoadEvent event) {
				imageLoaded = true;
				
				ImageElement imageElement = (ImageElement) image.getElement().cast();
				for (int i=0; i<size; i++) {
					for (int j=0; j<size; j++) {
						FloorCell cell = new FloorCell(imageElement, new Vector(i*100, j*85));
						group[i][j] = cell;
					}
				}
			}
		});
		image.setVisible(false);
		RootPanel.get().add(image);
	}
	
	public void draw(Context2d context) {
		if (!imageLoaded) {
			return;
		}
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				group[i][j].draw(context);
			}
		}
	}
	
}
