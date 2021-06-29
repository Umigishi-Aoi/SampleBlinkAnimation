package com.zerokaraapp.sampleblinkanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //アニメーションを定義するAnimatorSetオブジェクトを宣言する
    AnimatorSet set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタンオブジェクトをレイアウトから取得
        Button button = findViewById(R.id.button);
        //AnimatorInflaterで、AnimatorSetオブジェクトを取得
        //前もって作成したR.animator.blink_animationをインフレート
        set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,
                R.animator.blink_animation);
        //アニメーション対称のオブジェクトを設定
        set.setTarget(button);
    }

    //onCreateの中だとStartタイミングが早すぎて間に合わない。
    //onCreateの後の工程のonStartにてstartを実装する
    @Override
    protected void onStart() {
        super.onStart();
        //アニメーションの開始を宣言
        set.start();
    }

}