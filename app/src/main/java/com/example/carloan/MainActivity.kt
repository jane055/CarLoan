package com.example.carloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculateCarLoan(it)
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            resetCarLoan(it)
        }


    }

    fun calculateCarLoan(view: View){

        val carPrice : Float = editTextCarPrice.text.toString().toFloat()
        val downPayment : Float = editTextDownPayment.text.toString().toFloat()
        val loanPeriod : Float = editTextLoanPeriod.text.toString().toFloat()
        val interestRate : Float = editTextInterestRate.text.toString().toFloat()

        val carLoan : Float = carPrice - downPayment
        val Interest : Float = carLoan * interestRate/100 * loanPeriod
        val monthlyRepayment : Float = ((carLoan+Interest)/loanPeriod)/12

        textViewLoan.text="Loan: RM" + String.format("%.2f", carLoan)
        textViewInterest.text="Interest: RM" + String.format("%.2f", Interest)
        textViewMonthlyRepayment.text="Monthly Repayment: RM" + String.format("%.2f", monthlyRepayment)
    }

    fun resetCarLoan(view:View){
        editTextCarPrice.text = null
        editTextDownPayment.text = null
        editTextLoanPeriod.text = null
        editTextInterestRate.text = null

        textViewLoan.text = "Loan: "
        textViewInterest.text = "Interest: "
        textViewMonthlyRepayment.text = "Monthly Repayment: "
    }

}
