export interface ResponseWrapper<T> {
  success: boolean;
  data: T;
  message: string;
  timestamp: string;
  errors: string[] | null;
}
