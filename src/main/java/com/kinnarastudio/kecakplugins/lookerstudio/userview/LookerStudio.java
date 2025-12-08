package com.kinnarastudio.kecakplugins.lookerstudio.userview;

import org.joget.apps.app.service.AppUtil;
import org.joget.apps.userview.model.UserviewMenu;
import org.joget.commons.util.LogUtil;
import org.joget.plugin.base.PluginManager;
import org.joget.plugin.base.PluginWebSupport;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Looker Studio (Google)
 * @author tiyojati
 */
public class LookerStudio extends UserviewMenu implements PluginWebSupport {
    public final static String LABEL = "Looker Studio (Google)";

    @Override
    public String getRenderPage() {
        ApplicationContext appContext = AppUtil.getApplicationContext();
        PluginManager pluginManager = (PluginManager) appContext.getBean("pluginManager");

        final String template = "/templates/LookerView.ftl";

        final Map<String, Object> model = new HashMap<>();
        model.put("className", getClassName());
        final String embedUrl = getUserview().getCurrent().getPropertyString("embedUrl");
        model.put("embedUrl", embedUrl);
        final String secureEmbed = getUserview().getCurrent().getPropertyString("secureEmbed");
        model.put("secureEmbed", secureEmbed);
        final String allowFullScreen = getUserview().getCurrent().getPropertyString("allowFullScreen");
        model.put("allowFullScreen", allowFullScreen);

        return pluginManager.getPluginFreeMarkerTemplate(model, getClass().getName(), template, null);
    }

    @Override
    public void webService(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

    }

    @Override
    public String getCategory() {
        return "Kecak";
    }

    @Override
    public String getIcon() {
        return "<i class=\"fas fa-line-chart\"></i>";
    }

    @Override
    public boolean isHomePageSupported() {
        return true;
    }

    @Override
    public String getDecoratedMenu() {
        return null;
    }

    @Override
    public String getName() {
        return LABEL;
    }

    @Override
    public String getVersion() {
        PluginManager pluginManager = (PluginManager) AppUtil.getApplicationContext().getBean("pluginManager");
        ResourceBundle resourceBundle = pluginManager.getPluginMessageBundle(getClassName(), "/messages/BuildNumber");
        String buildNumber = resourceBundle.getString("buildNumber");
        return buildNumber;
    }

    @Override
    public String getDescription() {
        return getClass().getPackage().getImplementationTitle();
    }

    @Override
    public String getLabel() {
        return LABEL;
    }

    @Override
    public String getClassName() {
        return LookerStudio.class.getName();
    }

    @Override
    public String getPropertyOptions() {
        return AppUtil.readPluginResource(getClass().getName(), "/properties/LookerStudio.json");
    }
}
