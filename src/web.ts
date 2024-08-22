import { WebPlugin } from '@capacitor/core';

import type { IntentUriPlugin } from './definitions';

export class IntentUriWeb extends WebPlugin implements IntentUriPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
