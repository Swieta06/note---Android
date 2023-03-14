package com.bcas.myviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

//class DemoCollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
//
//    override fun getCount(): Int  = 100
//
//    override fun getItem(i: Int): Fragment {
//        val fragment = DemoObjectFragment()
//        fragment.arguments = Bundle().apply {
//            // Our object is just an integer :-P
//            putInt(ARG_OBJECT, i + 1)
//        }
//        return fragment
//    }
//
//    override fun getPageTitle(position: Int): CharSequence {
//        return "OBJECT ${(position + 1)}"
//    }
//}

class MyViewPagerAdapter (fm:FragmentManager):FragmentStatePagerAdapter(fm){
    private val listFragment:MutableList<Fragment> = mutableListOf()
    private val listTitle:MutableList<String> = mutableListOf()

    fun addfragMen(fragment:Fragment,title:String){
        listFragment.add(fragment)
        listTitle.add(title)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return  listFragment.size
    }
    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return listTitle[position]
    }
}