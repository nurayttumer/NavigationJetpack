package com.ik.navigationjetpack
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.ik.navigationjetpack.utils.NetworkConection
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        loadList.setOnClickListener {
            if (NetworkConection.isNetworkConnected(context)) {
                Navigation.findNavController(getView()!!).navigate(R.id.listFragment)
            } else {
                val context = activity!!.applicationContext
                val text = "İnternet bağlantınızı kontrol edniniz!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
            }
        }
        loadProfile.setOnClickListener{
            Navigation.findNavController(getView()!!).navigate(R.id.profileFragment)
        }
    }

}
