package com.xznn.retrofit_rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.xznn.retrofit_rxjava.bean.Subjects;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.click_me_BN)
    Button clickMeBN;
    @Bind(R.id.result_TV)
    TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        getMovie();
    }

    //进行网络请求
    private void getMovie() {
//        //    https://api.douban.com/v2/movie/top250?start=0&count=10
//        String baseUrl = "https://api.douban.com/v2/movie/";
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        MovieService movieService = retrofit.create(MovieService.class);
//        Observable<MovieEntity> observable = movieService.getTopMovie(0, 10);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<MovieEntity>() {
//                    @Override
//                    public void onCompleted() {
//                        Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        resultTV.setText(e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(MovieEntity movieEntity) {
//                        resultTV.setText(movieEntity.toString());
//                    }
//                });

        HttpMethods.getInstance().getTopMovie(new Subscriber<List<Subjects>>() {

            @Override
            public void onCompleted() {
                Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(Throwable e) {
                resultTV.setText(e.getMessage());

            }

            @Override
            public void onNext(List<Subjects> listHttpResult) {
                resultTV.setText(listHttpResult.toString());

            }
        }, 0, 10);


    }


}
