package com.wollfish.firebase.iam;

import androidx.annotation.NonNull;
import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallations;

@NativePlugin
public class FirebaseInAppMessaging extends Plugin {

    @PluginMethod
    public void getInstallationId(final PluginCall call) {
        FirebaseInstallations firebaseInstallations = FirebaseInstallations.getInstance();
        Task<String> installationsIdTask = firebaseInstallations.getId();
        installationsIdTask.addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    String installationId = task.getResult();
                    if (installationId != null && installationId.isEmpty()) {
                        call.reject("failed to obtain app instance id");
                    } else {
                        JSObject result = new JSObject();
                        result.put("value", installationId);
                        call.resolve(result);
                    }
                } else {
                    Exception exception = task.getException();
                    call.reject(exception.getLocalizedMessage());
                }
            }
        });
    }
}
