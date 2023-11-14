package ${package}.web.gui.panel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class FooterPanel extends Panel {

	public FooterPanel(final String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		final String copyright = "Copyright &copy; 2023 by Ulrich Fechtelhoff";
		add(new Label("copyright", Model.of(copyright)).setEscapeModelStrings(false));
	}
}
