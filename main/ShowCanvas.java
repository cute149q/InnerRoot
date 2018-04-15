package main;

import java.util.Optional;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

public class ShowCanvas extends Canvas {
	
	public int[] id = new int[200]; 
	public int count = 0;
	
	public ShowCanvas(Pane parent, double width, double height) {
		super(width, height);
		parent.setPrefSize(width, height);
		HBox.setHgrow(parent, Priority.ALWAYS);
		parent.getChildren().add(this);
		for(int i = 0; i < 200; i++) {
				id[i] = i + 65;
		}
	}
	
	public GraphicsContext clearCanvas() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.clearRect(0, 0, getWidth(), getHeight());
		count = 0;
		return gc;
	}

	public void drawNode(int x, int y) {
    	drawNode(getGraphicsContext2D(), x, y, Color.BLACK);
	}
	
	public void drawNodeTrace(int x, int y) {
    	drawNodeTrace(getGraphicsContext2D(), x, y, Color.RED);
	}
	
	private void drawNodeTrace(GraphicsContext gc, int x, int y, Color color) {
		gc.setStroke(color);
		gc.setLineWidth(10);
		gc.strokeOval(x * 40 + 1, y * 40 + 1, 40, 40);
	}
	
	public void drawPathTrace(int ax, int ay, int bx, int by, int distance) {
		drawPathTrace(getGraphicsContext2D(), ax, ay, bx, by, Color.RED, distance);
	}
	
	private void drawPathTrace(GraphicsContext gc, int ax, int ay, int bx, int by, Color color, int distance) {
		gc.setStroke(color);
		gc.setLineWidth(5);
		gc.strokeLine(ax * 40 + 21, ay * 40 + 21, bx * 40 + 21, by * 40 + 21);
		gc.setLineWidth(1);
		gc.strokeText(Integer.toString(distance), ax * 20 + bx * 20 + 36, ay * 20 + by * 20 + 36);
	}
	
	private void drawNode(GraphicsContext gc, int x, int y, Color color) {
		gc.setStroke(color);
		gc.setLineWidth(1);
		gc.strokeOval(x * 40 + 1, y * 40 + 1, 40, 40);
		char c= (char) id[count];
		gc.strokeText(Character.toString(c), x * 40 + 16, y * 40 + 25);
		count++;
	}
	
	public int drawLine(int ax, int ay, int bx, int by, int op) {
    	return drawLine(getGraphicsContext2D(), ax, ay, bx, by, Color.BLACK, op);
	}

	private int drawLine(GraphicsContext gc, int ax, int ay, int bx, int by, Color color, int op) {
		gc.setStroke(color);
		gc.setLineWidth(1);
		gc.strokeLine(ax * 40 + 21, ay * 40 + 21, bx * 40 + 21, by * 40 + 21);
		if(op != 1 && op != 2) {
		    String value = askInput();
		    gc.strokeText(value, ax * 20 + bx * 20 + 26, ay * 20 + by * 20 + 26);
		    return Integer.parseInt(value);
		}
		else
			return 0;
	}
	
	private String askInput() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Please input the Value of line");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    return result.get();
		}
		return "0";
	}
	
	public void drawShadow(int ax, int ay, double bx, double by) {
    	drawShadow(getGraphicsContext2D(), ax, ay, bx, by, Color.BLACK);
	}

	private void drawShadow(GraphicsContext gc, int ax, int ay, double bx, double by, Color color) {
		gc.setStroke(color);
		gc.setLineWidth(1);
		gc.strokeLine(ax * 40 + 21, ay * 40 + 21, bx, by);
	}
}
