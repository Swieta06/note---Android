package com.example.bcasyariah.view.LatihanFragmen.foodmenu

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bcasyariah.databinding.FragmentFoodMenuBinding
import com.example.bcasyariah.model.CategoryFoodModel
import com.example.bcasyariah.model.FoodModel
import com.example.bcasyariah.view.home.CategoryFoodAdapter

class FoodMenuFragment : Fragment() {
    private var binding: FragmentFoodMenuBinding? = null
    private var foodAdapter = FoodAdapter()
    private var categoryFoodAdapter = CategoryFoodAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodMenuBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodAdapter.setData(populateData())
        categoryFoodAdapter.setData(populateDataCategory())

        binding?.rvFood?.adapter = foodAdapter
        binding?.rvCategoryFood?.adapter = categoryFoodAdapter
        categoryFoodAdapter.addOnClickFoodCategory {categoryFoodModel->
            val categoryFoodData = populateDataCategory()
            val category = categoryFoodData.map {
                val category = categoryFoodModel.id
                val isSelected = it.id == category
                it.copy(isSelected = isSelected)

            }

            categoryFoodAdapter.setData(category.toMutableList())
            val data=populateData()
            val filterData=data.filter {dataFood->
            dataFood.category==categoryFoodModel.title
            }
            foodAdapter.setData(filterData.toMutableList())
        }

        binding?.etSearchText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                var data = populateData()
                val filterData = data.filter { data ->
                    data.title.contains(p0.toString(), ignoreCase = true)
                            || data.category.contains(p0.toString(), ignoreCase = true)
                }
                foodAdapter.setData(filterData.toMutableList())
                val editTextValue = binding?.etSearchText?.text
                if (editTextValue?.isEmpty() == true) {
                    binding?.ivClose?.visibility = View.INVISIBLE
                } else {
                    binding?.ivClose?.visibility = View.VISIBLE
                }
            }

        })
        binding?.ivClose?.setOnClickListener {
            binding?.etSearchText?.setText("")
        }
    }

    private fun populateData(): MutableList<FoodModel> {
        val listData = mutableListOf(
            FoodModel(
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1_SkX44fd6C9hMkS9acsDrGj4vRQYlqUjcHPpxlunqQ&s",
                title = "lalalalalalalala",
                subtitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                category = "pedas"
            ),
            FoodModel(
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1_SkX44fd6C9hMkS9acsDrGj4vRQYlqUjcHPpxlunqQ&s",
                title = "lalalalalala",
                subtitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                category = "pedas"
            ),
        )
        return listData
    }

    private fun populateDataCategory(): MutableList<CategoryFoodModel> {
        val listData = mutableListOf(
            CategoryFoodModel(
                id = 1,
                title = "manis",
                isSelected = false
            ),
            CategoryFoodModel(
                id = 2,
                title = "asin",
                isSelected = false
            ),
            CategoryFoodModel(
                id = 3,
                title = "pedas",
                isSelected = false
            ),
            CategoryFoodModel(
                id = 4,
                title = "asam",
                isSelected = false
            ),

            )
        return listData
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}