package de.fechtelhoff.web.gui;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import de.fechtelhoff.web.gui.page.BaseWebPage;
import de.fechtelhoff.web.gui.panel.WicketSettingsPanel;

public class HomePage extends BaseWebPage {

	public HomePage() {
		super();
	}

	@Override
	public String getPageTitle() {
		return "Home Page";
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("title", Model.of(getPageTitle())));
		add(new Label("label", "Start here ..."));
		add(new WicketSettingsPanel("wicketSettingsPanel"));
	}
}
