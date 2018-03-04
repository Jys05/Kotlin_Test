package com.su.kotlin_test.activity.baseSyntax;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.su.kotlin_test.frame.BaseActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Mr.Su on 2018/3/3.
 */

public class Java2KotlinTest {

    private void test2() {

    }

    private void test(int jh) {
        List<String> h = new ArrayList<>();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            h.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });
        }
        switch (jh) {
            case 1:
            case 12:
            case 8:
                String v = "sdas";
                v = v + "sadas";
                break;
        }
    }
}
