package com.lfc.zhihuidangjianapp.net.http;

import android.content.Context;

import com.lfc.zhihuidangjianapp.ui.activity.model.BaseResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ResponseObserver<T> {
    private final String TAG = "ResponseObserver";
    private final InternalObserver actual = new InternalObserver();

    public ResponseObserver(Context context) {
        Context context1 = context;
    }

    protected void onSubscribe(Disposable d) {
    }

    protected void onNext(T response) {
    }

    protected void onError(Throwable e) {
    }

    protected void onComplete() {
    }

    protected void fail(T response){

    }

    public InternalObserver actual() {
        return actual;
    }

    private class InternalObserver implements Observer<BaseResponse<T>> {

        @Override
        public void onSubscribe(Disposable d) {
            ResponseObserver.this.onSubscribe(d);
        }

        @Override
        public void onNext(BaseResponse<T> response) {
            if (response.isSuccessful() || response.getCode() == 90512) {
                ResponseObserver.this.onNext(response.getData());
                return;
            }
        }

        @Override
        public void onError(Throwable e) {
            ResponseObserver.this.onError(e);
        }

        @Override
        public void onComplete() {
            ResponseObserver.this.onComplete();
        }
    }
}
