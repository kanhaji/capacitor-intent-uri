export interface IntentUriPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
