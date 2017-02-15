package com.example.administrator.scrollviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    /*解决输入法阻挡输入框的问题
    * 在布局文件最外层添加一个scroll布局并且将“android:fillViewport="true"
    * 最后使用原有的布局就行布局
    * */

    Button mButton;
    TextView mTextView;
    EditText mEditText;
    ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.btn);
        mEditText = (EditText) findViewById(R.id.ed);
        mTextView = (TextView) findViewById(R.id.txt);
        mScrollView = (ScrollView) findViewById(R.id.myscrollview);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = mEditText.getText().toString();

                mTextView.append(s);
                //scrollToBottom(mScrollView,mTextView);//这个方法

                int offset = mTextView.getMeasuredHeight()
                        - mScrollView.getMeasuredHeight();//获取textview的高度减去ScrollView的高度，得到的是需要滑动的长度
                mScrollView.scrollTo(0, offset);//滑动滚动条到指定的位置
            }
        });
    }

}
