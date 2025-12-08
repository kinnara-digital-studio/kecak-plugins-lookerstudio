package com.kinnarastudio.kecakplugins.lookerstudio;

import java.util.ArrayList;
import java.util.Collection;

import com.kinnarastudio.kecakplugins.lookerstudio.userview.LookerStudio;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

    protected Collection<ServiceRegistration> registrationList;

    public void start(BundleContext context) {
        registrationList = new ArrayList<ServiceRegistration>();

        //Register plugin here
        registrationList.add(context.registerService(LookerStudio.class.getName(), new LookerStudio(), null));
    }

    public void stop(BundleContext context) {
        for (ServiceRegistration registration : registrationList) {
            registration.unregister();
        }
    }
}