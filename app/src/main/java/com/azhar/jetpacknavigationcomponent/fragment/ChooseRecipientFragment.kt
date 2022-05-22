package com.azhar.jetpacknavigationcomponent.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.azhar.jetpacknavigationcomponent.R
import com.azhar.jetpacknavigationcomponent.databinding.FragmentChooseRecipientBinding
import com.azhar.jetpacknavigationcomponent.databinding.FragmentMainBinding


class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentChooseRecipientBinding
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentChooseRecipientBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.nextBtn.setOnClickListener(this)
        binding.cancelBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.next_btn -> if (!TextUtils.isEmpty(binding.inputRecipient.text.toString().trim())){
                val bundle = bundleOf("recipient" to binding.inputRecipient.text.toString().trim())
                navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle)
            }

            R.id.cancel_btn -> activity?.onBackPressed()
        }
    }

}