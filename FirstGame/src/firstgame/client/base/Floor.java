package firstgame.client.base;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

import firstgame.shared.Constant;

public class Floor {
	private int type = Constant.FLOOR.DEFAULT;
	private int size;
	private Image image;
	private FloorCell[][] group;
	private boolean imageLoaded = false;
	private Context2d backContext;

	public Floor(int type, int size) {
		this.type = type;
		this.size = size;
		this.group = new FloorCell[size][size];
		
		init();
	}

	private void init() {
		image = Commons.getBlockImage(type);
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
		
		Canvas backCanvas = Canvas.createIfSupported();
		backCanvas.setCoordinateSpaceWidth(size * 100);
		backCanvas.setCoordinateSpaceHeight((size+1) * 85);
		backContext = backCanvas.getContext2d();
	}
	
	public void draw(Context2d context) {
		if (!imageLoaded) {
			return;
		}
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				group[i][j].draw(backContext);
			}
		}
		
		context.drawImage(backContext.getCanvas(), 25, 25, 400, 400);
	}
	
}
