package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<View>(R.id.btnCalculate)

        btn.setOnClickListener() {

            val price = txtPrice.text.toString();
            val downPayment = txtDownPayment.text.toString();
            val loanPeriod = txtLoanPeriod.text.toString();
            val interestRate = txtInterestRate.text.toString();

            val carLoan: Double = price.toDouble() - downPayment.toDouble();
            val interest: Double = carLoan * interestRate.toDouble() / 100 * loanPeriod.toDouble();
            val monthlyRepayment: Double = (carLoan + interest) / loanPeriod.toDouble() / 12;

            txtCarLoan.text = "%.2f".format(carLoan);
            txtInterest.text = "%.2f".format(interest);
            txtMonthlyRepayment.text = "%.2f".format(monthlyRepayment);
        }
    }
}
