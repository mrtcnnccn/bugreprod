package com.bugreproduction.geftimov

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.bugreproduction.R


class GeftimovView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
): RelativeLayout(context, attrs, defStyleAttr){

    private lateinit var content: ViewGroup
    private lateinit var tv : TextView
    private lateinit var reverse : View
    private lateinit var next  : View
    private lateinit var vm  : GeftimovViewModel

    private var pageIndex = 0


    init {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        content = Toolbar.inflate(context,
            R.layout.geftimov_view, this) as ViewGroup
        tv = content.findViewById(R.id.tv)
        reverse = content.findViewById(R.id.reverse)
        next = content.findViewById(R.id.next)
    }

    fun init(pageIndex: Int, vm: GeftimovViewModel){
        this.pageIndex = pageIndex
        this.vm = vm
        tv.text = "PAGE $pageIndex"
        prepareSkipAndReverse()
    }

    fun onPrev() {
        Log.d("CLICK", "Reverse on page $pageIndex")
        Toast.makeText(context, "Reverse clicked on page $pageIndex", Toast.LENGTH_LONG).show()
        vm.toPage(pageIndex - 1)
    }

    fun onNext() {
        Log.d("CLICK", "Next on page $pageIndex")
        Toast.makeText(context, "Next clicked on page $pageIndex", Toast.LENGTH_LONG).show()
        vm.toPage(pageIndex + 1)
    }

    private fun prepareSkipAndReverse() {
        reverse.setOnClickListener { onPrev() }
        next.setOnClickListener { onNext() }
    }
}