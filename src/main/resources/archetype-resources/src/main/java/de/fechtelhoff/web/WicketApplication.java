package de.fechtelhoff.web;

import org.apache.wicket.cdi.CdiConfiguration;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.CookieThemeProvider;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import de.agilecoders.wicket.core.settings.ThemeProvider;
import de.agilecoders.wicket.themes.markup.html.bootswatch.BootswatchTheme;
import de.agilecoders.wicket.themes.markup.html.bootswatch.BootswatchThemeProvider;
import de.agilecoders.wicket.webjars.WicketWebjars;
import de.agilecoders.wicket.webjars.settings.WebjarsSettings;
import de.fechtelhoff.web.gui.HomePage;

public class WicketApplication extends WebApplication {

	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	@Override
	public void init() {
		super.init();

		// initializeCsp();

		initializeCdi();
		initializeBootstrap();
		initializeWebJars();

		mountPages();
	}

	/**
	 * Initialize Content Security Policy
	 */
	private void initializeCsp() {
		getCspSettings().blocking().disabled();
		getCspSettings().blocking().unsafeInline();
	}

	/**
	 * Initialize Contexts and Dependency Injection
	 */
	private void initializeCdi() {
		new CdiConfiguration().configure(this);
	}

	private void initializeBootstrap() {
		final IBootstrapSettings bootstrapSettings = new BootstrapSettings();
		final ThemeProvider themeProvider = new BootswatchThemeProvider(BootswatchTheme.Cerulean);
		bootstrapSettings.setThemeProvider(themeProvider);
		bootstrapSettings.setActiveThemeProvider(new CookieThemeProvider());
		Bootstrap.install(this, bootstrapSettings);
	}

	private void initializeWebJars() {
		final WebjarsSettings settings = new WebjarsSettings();
		settings.useCdnResources(false);
		WicketWebjars.install(this, settings);
	}

	private void mountPages() {
		WicketApplicationPrettyUrlConfig.getPageClassByPrettyUrlMap().forEach(this::mountPage);
	}
}
