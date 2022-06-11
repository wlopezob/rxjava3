package com.callback.callback;

public interface CallBack {
  void pushComplete();
  void pushData(String data);
  void pushError(Exception ex);
}
