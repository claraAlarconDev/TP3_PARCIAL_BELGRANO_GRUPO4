package com.example.tp3_parcial_belgrano_grupo4.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
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

    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.uploadFotoBtn.setOnClickListener{
            val imageUrl = binding.userImage.text.toString()
            viewModel.setImageUrl(imageUrl)
            binding.userImage.text.clear()
        }

        viewModel.userImageUrl.observe(viewLifecycleOwner, Observer{ imageUrl ->
            Picasso.get().load(imageUrl).into(binding.profileImageView)
        } )

        viewModel.userName.observe(viewLifecycleOwner, Observer { name ->
            binding.userProfileName.text = name
        })

        viewModel.userPhone.observe(viewLifecycleOwner, Observer {phone ->
            binding.userNumberProfile.text = phone
        })
    }

}