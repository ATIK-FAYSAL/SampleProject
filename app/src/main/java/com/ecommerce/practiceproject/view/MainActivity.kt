package com.ecommerce.practiceproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import android.annotation.SuppressLint
import com.ecommerce.practiceproject.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //createObservable()
    }

    private fun createObservable()
    {
        //val animalObservable = Observable.just("Ant","Dog")
        val animalObservable = Observable.fromArray("Ant","Dog","Bat", "Bee", "Bear", "Butterfly",
            "Cat", "Crab", "Cod",
            "Dog", "Dove",
            "Fox", "Frog")

        val animalObserver = object  : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Log.d("animal_name", "onSubscribe")
            }

            override fun onNext(t: String) {
                Log.d("animal_name", "name is: $t")
            }

            override fun onError(e: Throwable) {
                Log.d("animal_name", "error is: $e")
            }

            override fun onComplete() {
                Log.d("animal_name", "complete")
            }
        }

//        animalObservable
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(animalObserver)

        animalObservable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { t -> t.uppercase() }.subscribe(animalObserver)
    }
}
