package com.lfc.zhihuidangjianapp.utlis;

import android.app.Application;
import android.speech.tts.TextToSpeech;

import com.hjq.toast.ToastUtils;
import com.lfc.zhihuidangjianapp.app.MyApplication;

import java.util.Locale;

public class ChineseToSpeech {

    private TextToSpeech textToSpeech;

    public ChineseToSpeech() {
        this.textToSpeech = new TextToSpeech(MyApplication.getAppContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.CHINA);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        ToastUtils.show("不支持朗读功能");
                    }
                }
            }
        });
    }

    public void speech(String text) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void destroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

}
