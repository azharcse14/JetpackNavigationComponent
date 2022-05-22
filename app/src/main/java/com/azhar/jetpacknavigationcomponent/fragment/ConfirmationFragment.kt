package com.azhar.jetpacknavigationcomponent.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.azhar.jetpacknavigationcomponent.R
import com.azhar.jetpacknavigationcomponent.data.Money
import com.azhar.jetpacknavigationcomponent.databinding.FragmentConfirmationBinding


class ConfirmationFragment : Fragment() {

    lateinit var binding: FragmentConfirmationBinding
    lateinit var recipient:String
    lateinit var money: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            recipient = it.getString("recipient")!!
            money = it.getParcelable("amount")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val amount = money.amount
        val message = "You hove sent $amount to $recipient"
        binding.confirmationMessage.text = message
    }
}