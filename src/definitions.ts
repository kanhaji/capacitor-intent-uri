export interface IntentUriPlugin {
  openUri(options: { url: string }): Promise<{ completed: boolean }>;
}
