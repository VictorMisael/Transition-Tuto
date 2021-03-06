/*
 *  Java
 *
 */
package com.mycompany;

import com.mycompany.widget.NewDesktop;
import com.mycompany.widget.TransitionDisplayable;

import ej.microui.MicroUI;
import ej.microui.display.Display;
import ej.mwt.Desktop;
import ej.mwt.Widget;
import ej.mwt.util.Alignment;
import ej.widget.basic.Button;
import ej.widget.basic.Label;
import ej.widget.basic.OnClickListener;
import ej.widget.container.Canvas;

/**
 * Generated by the build-firmware-singleapp-skeleton.<br>
 * Please keep it in sync with the property 'application.main.class' defined in module.ivy
 */
public class Main {

	static Desktop mainScreen;

	public static void main(String[] args) {
		MicroUI.start();
		mainScreen = new Desktop();
		Label title = new Label("Main Screen");
		Button changeScreen = new Button("Click to change the screen");
		Canvas canvas = new Canvas();
		int titleWidth = 64;
		int buttonWidth = 64;
		int buttonHeigth = 24;
		int titleX = Alignment.computeLeftX(titleWidth, 0, Display.getDisplay().getWidth(), Alignment.HCENTER);
		int buttonX = Alignment.computeLeftX(buttonWidth, 0, Display.getDisplay().getWidth(), Alignment.HCENTER);
		int buttonY = Alignment.computeTopY(buttonHeigth, 0, Display.getDisplay().getHeight(), Alignment.VCENTER);
		canvas.addChild(title, titleX, 0, titleWidth, Widget.NO_CONSTRAINT);
		canvas.addChild(changeScreen, buttonX, buttonY, buttonWidth, buttonHeigth);
		changeScreen.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick() {
				NewDesktop newDesktop = new NewDesktop();
				TransitionDisplayable displayable = new TransitionDisplayable(newDesktop, true);
				Display.getDisplay().requestShow(displayable);
			}
		});
		mainScreen.setWidget(canvas);
		mainScreen.requestShow();

	}

	public static void showMainScreen() {
		TransitionDisplayable displayable = new TransitionDisplayable(mainScreen, false);
		Display.getDisplay().requestShow(displayable);
	}
}
