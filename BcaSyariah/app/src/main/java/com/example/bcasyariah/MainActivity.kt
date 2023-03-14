package com.example.bcasyariah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcasyariah.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var input1 = 0
    private var input2 = 0
    private var inputResult = 0
    private var operatorType = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTambah.setOnClickListener {
            changeOperator("+")
            operatorType = OperatorType.TAMBAH
        }

        binding.btnKurang.setOnClickListener {
            changeOperator("-")
            operatorType = OperatorType.KURANG
        }
        binding.btnBagi.setOnClickListener {
            changeOperator("/")
            operatorType = OperatorType.BAGI

        }
        binding.btnKali.setOnClickListener {
            changeOperator("*")
            operatorType = OperatorType.KALI
        }
        binding.btnResult.setOnClickListener {
            calculate()

        }
        //setContentView(R.layout.activity_main)
    }

    private fun calculate() {
        input1 = binding.editInput
            .text
            .toString()
            .toInt()
        input2 = binding.editInput2
            .text
            .toString()
            .toInt()
        when (operatorType) {
            OperatorType.TAMBAH -> {
                tambah()

            }
            OperatorType.KURANG -> {
                kurang()

            }
            OperatorType.KALI -> {
                kali()

            }
            OperatorType.BAGI -> {
                bagi()

            }

        }
        binding.result.text = inputResult.toString()
    }

    private fun changeOperator(operator: String) {
        binding.operator.text = operator

    }

    private fun tambah() {
        inputResult = input1 + input2
    }

    private fun kurang() {
        inputResult = input1 - input2
    }

    private fun kali() {
        inputResult = input1 * input2
    }

    private fun bagi() {
        inputResult = input1 / input2
    }

}