package com.taylor.fakepeoplearerealpeopletoo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_generate_person.*

class GeneratePersonActivity : AppCompatActivity() {
    var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_person)

        val viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(FakePersonGeneratorViewModel::class.java)

        person_generate_btn.setOnClickListener { _ ->
            viewModel.generateFakePerson()
        }

        viewModel.state.observe(this, Observer{state: FakePersonViewState? ->
            state?.let {
                person_loading.visibility = if(it.loading) View.VISIBLE else View.INVISIBLE
                showOrHideError(it.error)
                showPersonInformation(it.person)
            }
        })
    }

    private fun showPersonInformation(person: Person?) {
        if(person == null) {
            person_name.text = ""
            person_bday.text = ""
            person_age.text = ""
            person_email.text = ""
            person_user_name.text = ""
            person_password.text = ""
            person_credit_card_number.text = ""
            person_credit_card_security_code.text = ""
        } else {
            person_name.text = "Name: ${person.GivenName} ${person.Surname}"
            person_bday.text = "Birthday: ${person.Birthday}"
            person_age.text = "Age: ${person.Age}"
            person_email.text = "Email: ${person.EmailAddress}"
            person_user_name.text = "Username: ${person.Username}"
            person_password.text = "Password: ${person.Password}"
            person_credit_card_number.text = "Credit Card Number: ${person.CCNumber}"
            person_credit_card_security_code.text = "Credit Card Security Code: ${person.CVV2}"
        }
    }

    private fun showOrHideError(message: String?) {
        person_error.visibility = if(message.isNullOrEmpty()) View.GONE else View.VISIBLE
        person_error.text = message
    }
}