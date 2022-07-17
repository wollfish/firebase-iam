import { WebPlugin } from '@capacitor/core';
import { FirebaseInAppMessagingPlugin } from './definitions';

export class FirebaseInAppMessagingWeb extends WebPlugin implements FirebaseInAppMessagingPlugin {
  constructor() {
    super({
      name: 'FirebaseInAppMessaging',
      platforms: ['web'],
    });
  }

  async getInstallationId(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}

const FirebaseInAppMessaging = new FirebaseInAppMessagingWeb();

export { FirebaseInAppMessaging };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(FirebaseInAppMessaging);
