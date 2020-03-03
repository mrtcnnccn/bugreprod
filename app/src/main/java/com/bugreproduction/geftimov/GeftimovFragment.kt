package com.bugreproduction.geftimov

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bugreproduction.R

class GeftimovFragment : Fragment() {
    protected lateinit var rootView: ViewGroup
    lateinit var geftimovView: GeftimovView
    private var pageIndex: Int = 0
    private val geftimovVM: GeftimovViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(getLayoutRes(), container, false) as ViewGroup
        initViews()
        return rootView
    }

    fun getLayoutRes(): Int {
        return R.layout.fragment_geftimov
    }

    fun initViews() {
        pageIndex = arguments?.getInt("pageIndex")?:0
        geftimovView = rootView.findViewById(R.id.my_view)
        geftimovView.init(pageIndex, geftimovVM)
    }

    companion object {
        fun newInstance(pageIndex: Int): GeftimovFragment {
            val fragment = GeftimovFragment()
            val args = Bundle()
            args.putInt("pageIndex", pageIndex)
            fragment.arguments = args
            return fragment
        }
    }
}