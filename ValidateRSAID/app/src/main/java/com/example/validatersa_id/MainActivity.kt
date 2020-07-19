package com.example.validatersa_id

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.validatersa_id.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private var sum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.inputId.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 13) {
                    binding.verifyButton.isEnabled = true
                    binding.verifyButton.setOnClickListener{
                        val flag =  (validateID(s.toString()))
                        if (flag){
                            binding.validatedOutput.text = "Valid Identity Number!"
                        } else {
                            binding.validatedOutput.text = "Invalid Identity Number!"
                        }
                        binding.verifyButton.isEnabled = false
                    }
                } else {
                    binding.verifyButton.isEnabled = false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.verifyButton.isEnabled = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 13) {
                    binding.verifyButton.isEnabled = true
                    binding.verifyButton.setOnClickListener{
                        validateID(s.toString())
                    }
                } else {
                    binding.verifyButton.isEnabled = false
                }
            }
        })

    }

    private fun validateID(id: String): Boolean {
        var count = 0
        var storeString = ""
        var storeNumber = 0
        for (i in id) {
            if (count % 2 == 1) {
                storeString = id.substring(count, count + 1)
                storeNumber = storeString.toInt()
                storeNumber *= 2
                if (storeNumber.toString().length == 2) {
                    val charOne = storeNumber.toString().substring(0, 1)
                    val charTwo = storeNumber.toString().substring(1, 2)
                    sum += charOne.toInt() + charTwo.toInt()
                } else {
                    sum += storeNumber
                }
            } else {
                storeString = id.substring(count, count + 1)
                storeNumber = storeString.toInt()
                sum += storeNumber
            }
            count += 1
        }

        return sum % 10 == 0
    }


}
