package firstgame.client;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;

public class FloorCell {
	private Vector pos;
	private ImageElement imageElement;

	public FloorCell(ImageElement imgEl, Vector pos) {
		this.pos = pos;
		this.imageElement = imgEl;
	}
	
	public void draw(Context2d context) {
		context.save();
		context.translate(pos.x, pos.y - 50);
		context.rotate(0);
		context.drawImage(imageElement, 0, 0);
		context.restore();
	}
}
