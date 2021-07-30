/**
 *
 */
package com.mycompany.widget;

import com.mycompany.Main;

import ej.microui.display.Display;
import ej.mwt.Desktop;
import ej.mwt.Widget;
import ej.mwt.util.Alignment;
import ej.widget.basic.Button;
import ej.widget.basic.Label;
import ej.widget.basic.OnClickListener;
import ej.widget.container.Canvas;

/**
 *
 */
public class NewDesktop extends Desktop {
	Label title;
	Button backToMain;

	public NewDesktop() {
		this.title = new Label("New Screen");
		this.backToMain = new Button("Go back");
		Canvas canvas = new Canvas();
		int titleWidth = 64;
		int buttonWidth = 64;
		int buttonHeigth = 24;
		int titleX = Alignment.computeLeftX(titleWidth, 0, Display.getDisplay().getWidth(), Alignment.HCENTER);
		int buttonX = Alignment.computeLeftX(buttonWidth, 0, Display.getDisplay().getWidth(), Alignment.HCENTER);
		int buttonY = Alignment.computeTopY(buttonHeigth, 0, Display.getDisplay().getHeight(), Alignment.VCENTER);
		canvas.addChild(this.title, titleX, 0, titleWidth, Widget.NO_CONSTRAINT);
		canvas.addChild(this.backToMain, buttonX, buttonY, buttonWidth, buttonHeigth);
		this.backToMain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick() {
				Main.showMainScreen();
			}
		});
		setWidget(canvas);
	}

}
