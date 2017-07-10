package com.microsoft.healthvault.client;

import com.microsoft.hsg.HVException;

public interface RequestCallback<T> {

    void onError(HVException exception);

    void onSuccess(T t);
}
