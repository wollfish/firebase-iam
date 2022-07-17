declare module '@capacitor/core' {
  interface PluginRegistry {
    FirebaseInAppMessaging: FirebaseInAppMessagingPlugin;
  }
}

export interface FirebaseInAppMessagingPlugin {
  getInstallationId(options: { value: string }): Promise<{ value: string }>;
}
