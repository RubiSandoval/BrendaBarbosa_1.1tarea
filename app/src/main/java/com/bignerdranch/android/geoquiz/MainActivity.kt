package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
//import android.widget.Button
import android.widget.Toast
import com.bignerdranch.android.geoquiz.databinding.ActivityMainBinding

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private lateinit var trueButton: Button
    //private lateinit var falseButton: Button
    private val questionBank = listOf(
        Question(R.string.question_batman, false),
        Question(R.string.question_spiderman, false),
        Question(R.string.question_ironman, false),
        Question(R.string.question_hulk, true),
        Question(R.string.question_moonlight, false))
    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //trueButton = findViewById(R.id.true_button)
        //falseButton = findViewById(R.id.false_button)
        //trueButton.setOnClickListener {
        binding.trueButton.setOnClickListener { view: View ->
            //Toast.makeText(
            //this,
            //R.string.correct_toast,
            //Toast.LENGTH_SHORT,
            //).show()
            checkAnswer(true)
            }
        //falseButton.setOnClickListener { view: View ->
        binding.falseButton.setOnClickListener { view: View ->
            //Toast.makeText(
            //this,
            //R.string.correct_toast,
            //Toast.LENGTH_SHORT,
            //).show()
            checkAnswer(false)
            }
        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            //val questionTextResId = questionBank[currentIndex].textResId
            //binding.questionTextView.setText(questionTextResId)
            updateQuestion()
        }
        updateQuestion()
        }
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }
    }

//}