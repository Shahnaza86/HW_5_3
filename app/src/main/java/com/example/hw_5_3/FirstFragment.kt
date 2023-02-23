package com.example.hw_5_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw_5_3.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    var itsTen: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.tv0.text = "0"
        itsTen = false
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn1.setOnClickListener {
            if (!itsTen) {
                binding.tv0.text = (binding.tv0.text.toString().toInt() + 1).toString()
                if (binding.tv0.text.toString().toInt() == 10) {
                    binding.btn1.text = "-1"
                    itsTen = true
                }
            } else {
                binding.tv0.text = (binding.tv0.text.toString()
                    .toInt() - 1).toString()
                if (binding.tv0.text.toString() == "0") {
                    val bundle = Bundle()
                    bundle.putString("Key", binding.tv0.text.toString())
                    val secondFragment = SecondFragment()
                    secondFragment.arguments = bundle

                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.conteiner, secondFragment)?.addToBackStack(null)?.commit()
                }
            }
        }
    }

}