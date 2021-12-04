package de.fechtelhoff.web.gui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import de.fechtelhoff.web.gui.panel.WicketSettingsPanel;

public class HomePage extends WebPage {

	public HomePage() {
		super();
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Label("label", "Start here ..."));

		add(new WicketSettingsPanel("wicketSettingsPanel"));
	}
}
