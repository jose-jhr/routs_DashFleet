package com.ingenieria.rutasdashfleet.fragments.customview

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView

class ExpandableCustomListView(context: Context, attrs: AttributeSet?) : ListView(context, attrs) {
    private var expanded = false

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (expanded) {
            // Calculate entire height by providing a very large heightMeasureSpec
            super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(MEASURED_SIZE_MASK, MeasureSpec.AT_MOST))
            layoutParams.height = measuredHeight
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }

    fun setExpanded(expanded: Boolean) {
        this.expanded = expanded
        requestLayout()
    }
}
