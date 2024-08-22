package com.github.thaunknown;

import android.content.Context;
import android.content.Intent;
import java.net.URISyntaxException;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.util.InternalUtils;

@CapacitorPlugin(name = "IntentUri")
public class IntentUriPlugin extends Plugin {
    @PluginMethod
    public void openUri(PluginCall call) {
        String url = call.getString("url");
        if (url == null) {
            call.reject("Must provide a url to open");
            return;
        }

        JSObject ret = new JSObject();
        final PackageManager manager = getContext().getPackageManager();
        Intent launchIntent;
        try {
            launchIntent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
        } catch (URISyntaxException e) {
            ret.put("completed", false);
            call.resolve(ret);
            return;
        }

        try {
            getActivity().startActivity(launchIntent);
            ret.put("completed", true);
        } catch (Exception ex) {
            launchIntent = manager.getLaunchIntentForPackage(url);
            try {
                getActivity().startActivity(launchIntent);
                ret.put("completed", true);
            } catch (Exception expgk) {
                ret.put("completed", false);
            }
        }
        call.resolve(ret);
    }
}
