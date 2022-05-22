package com.azhar.jetpacknavigationcomponent.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.azhar.jetpacknavigationcomponent.R
import com.azhar.jetpacknavigationcomponent.data.Money
import com.azhar.jetpacknavigationcomponent.databinding.FragmentChooseRecipientBinding
import com.azhar.jetpacknavigationcomponent.databinding.FragmentSpecifyAmountBinding
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentSpecifyAmountBinding
    lateinit var navController: NavController
    lateinit var recipient:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient")!!
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpecifyAmountBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.sendBtn.setOnClickListener(this)
        binding.cancelBtn.setOnClickListener(this)
        binding.recipient.text = "Sending money to $recipient"
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.send_btn -> if (!TextUtils.isEmpty(binding.inputAmount.text.toString())){
                val amount = Money(BigDecimal(binding.inputAmount.text.toString()))
                val bundle = bundleOf("recipient" to recipient, "amount" to amount)
                navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle)
            }else{
                Toast.makeText(activity,"Enter an Amount", Toast.LENGTH_SHORT).show()
            }

            R.id.cancel_btn -> activity?.onBackPressed()
        }
    }

}