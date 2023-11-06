package com.example.tp3_parcial_belgrano_grupo4.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.tp3_parcial_belgrano_grupo4.databinding.FragmentProfileBinding
import com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels.ProfileViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var _binding: FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.uploadFotoBtn.setOnClickListener{
            //aca iria la logica de llamar el popup, insertar la url, agregar la url
        }

        viewModel.userImageUrl.observe(viewLifecycleOwner){ imageUrl ->
            Picasso.get().load(imageUrl).into(binding.profileImageView)
        }

        viewModel.userName.observe(viewLifecycleOwner, Observer { name ->
            binding.userProfileName.text = name
        })

        viewModel.userPhone.observe(viewLifecycleOwner, Observer {phone ->
            binding.userNumberProfile.text = phone
        })
    }

}