import { registerPlugin } from '@capacitor/core';

import type { IntentUriPlugin } from './definitions';

const IntentUri = registerPlugin<IntentUriPlugin>('IntentUri', {
  web: () => import('./web').then(m => new m.IntentUriWeb()),
});

export * from './definitions';
export { IntentUri };
